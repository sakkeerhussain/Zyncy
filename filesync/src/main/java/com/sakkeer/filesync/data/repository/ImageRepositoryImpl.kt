package com.sakkeer.filesync.data.repository

import android.graphics.Bitmap
import com.sakkeer.filesync.client.BaseTarget
import com.sakkeer.filesync.client.ImageTarget
import com.sakkeer.filesync.data.cache.ImageCacheDao
import com.sakkeer.filesync.data.callback.ImageResponseCallbackImpl
import com.sakkeer.filesync.data.remote.ImageServiceDao
import com.sakkeer.filesync.data.request.ImageRequest
import com.sakkeer.filesync.data.request.Request
import com.sakkeer.filesync.data.request.RequestQueue

/*
 * Created by Sakkeer Hussain on 2019-09-14.
 */
class ImageRepositoryImpl(
    private val mImageServiceDao: ImageServiceDao,
    private val mImageCacheDao: ImageCacheDao,
    private val mRequestQueue: RequestQueue
): ImageRepository {

    override fun getImage(request: Request, target: BaseTarget): Request {

        val callback = ImageResponseCallbackImpl(request, this)
        var cacheHit = mImageCacheDao.getImage(request, callback)

//        cacheHit = false

        return if (cacheHit) {
            request
        } else {

            // Fetch from remote
            if (target !is ImageTarget) {
                throw Exception("Target should be Image target for loading image")
            }
            if (request !is ImageRequest) {
                throw Exception("Request should be Image request for loading image")
            }

            val queuedRequest = mRequestQueue.enqueue(request, target)
            val queuedCallback = ImageResponseCallbackImpl(queuedRequest, this)
            mImageServiceDao.getImage(queuedRequest, queuedCallback)
            queuedRequest
        }
    }

    override fun dequeRequest(request: Request) {
        mRequestQueue.deque(request)
    }

    override fun cancelRequest(request: Request) {
        if (request.targets.isEmpty()) return
        val target = request.targets[0]
        val queuedRequest = mRequestQueue.getExistingImageRequest(request) ?: return

        queuedRequest.targets.remove(target)
        if (queuedRequest.targets.isEmpty()) {
            queuedRequest.httpsRequest?.cancel()
            dequeRequest(queuedRequest)
        }
    }

    override fun cacheRequest(request: Request, bitmap: Bitmap) {
        mImageCacheDao.cacheImage(request, bitmap)
    }

    private fun isInCache(): Boolean {
        return false
    }
}