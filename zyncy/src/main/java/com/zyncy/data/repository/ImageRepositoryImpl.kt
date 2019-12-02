package com.zyncy.data.repository

import android.graphics.Bitmap
import com.zyncy.client.BaseTarget
import com.zyncy.client.ImageTarget
import com.zyncy.data.cache.ImageCacheDao
import com.zyncy.data.callback.ImageResponseCallbackImpl
import com.zyncy.data.remote.ImageServiceDao
import com.zyncy.data.request.ImageRequest
import com.zyncy.data.request.Request
import com.zyncy.data.request.RequestQueue

/*
 * Created by Sakkeer Hussain on 2019-09-14.
 */
class ImageRepositoryImpl(
    private val mImageServiceDao: ImageServiceDao,
    private val mImageCacheDao: ImageCacheDao,
    private val mRequestQueue: RequestQueue
): ImageRepository {

    override fun getImage(request: Request, target: BaseTarget): Request {

        if (target !is ImageTarget) {
            throw Exception("Target should be Image target for loading image")
        }
        if (request !is ImageRequest) {
            throw Exception("Request should be Image request for loading image")
        }

        request.addTarget(target)
        val callback = ImageResponseCallbackImpl(request, this)
        val cacheHit = mImageCacheDao.getImage(request, callback)

        return if (cacheHit) {
            request
        } else {

            // Fetch from remote
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

    override fun clearCache() {
        mImageCacheDao.clearCache()
    }

    private fun isInCache(): Boolean {
        return false
    }
}