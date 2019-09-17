package com.sakkeer.filesync.data.repository

import com.sakkeer.filesync.client.BaseTarget
import com.sakkeer.filesync.client.ImageTarget
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
    private val mRequestQueue: RequestQueue
): ImageRepository {

    override fun getImage(request: Request, target: BaseTarget) {
        if (isInCache()) {  // a cache miss
            // Fetch from cache
        } else {

            if (target !is ImageTarget) {
                throw Exception("Target should be Image target for loading image")
            }
            if (request !is ImageRequest) {
                throw Exception("Request should be Image request for loading image")
            }

            val queuedRequest = mRequestQueue.enqueue(request, target)
            val callback = ImageResponseCallbackImpl(queuedRequest, this)
            mImageServiceDao.getImage(queuedRequest, callback)
        }
    }

    override fun dequeRequest(request: Request) {
        mRequestQueue.deque(request)
    }

    private fun isInCache(): Boolean {
        return false
    }
}