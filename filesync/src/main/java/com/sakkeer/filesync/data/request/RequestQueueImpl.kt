package com.sakkeer.filesync.data.request

import com.sakkeer.filesync.client.BaseTarget

class RequestQueueImpl : RequestQueue {

    private val mRequestUtils = RequestUtilsImpl(this)
    val mActiveRequests: ArrayList<Request> = arrayListOf()

    override fun getActiveRequests(): List<Request> {
        return this.mActiveRequests
    }

    @Synchronized
    override fun enqueue(request: Request, target: BaseTarget): Request {

        val existingRequest = mRequestUtils.getExistingImageRequest(request)

        return if (existingRequest != null) {

            existingRequest.addTarget(target)
            existingRequest
        } else {

            request.addTarget(target)
            mActiveRequests.add(request)
            request
        }
    }

    @Synchronized
    override fun deque(request: Request) {
        mActiveRequests.remove(request)
    }
}