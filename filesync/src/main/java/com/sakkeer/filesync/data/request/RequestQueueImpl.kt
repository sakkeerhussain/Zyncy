package com.sakkeer.filesync.data.request

import com.sakkeer.filesync.client.BaseTarget

class RequestQueueImpl : RequestQueue {

    val mActiveRequests: ArrayList<Request> = arrayListOf()

    override fun getActiveRequests(): List<Request> {
        return this.mActiveRequests
    }

    @Synchronized
    override fun enqueue(request: Request, target: BaseTarget): Request {

        val existingRequest = getExistingImageRequest(request)

        return if (existingRequest != null) {

            existingRequest.addTarget(target)
            existingRequest
        } else {

            mActiveRequests.add(request)
            request
        }
    }

    @Synchronized
    override fun deque(request: Request) {
        mActiveRequests.remove(request)
    }

    override fun getExistingImageRequest(request: Request): Request? {
        val url = request.url
        val requests = mActiveRequests.filter {  it.url == url }
        return if (requests.isNotEmpty()) requests[0] else null
    }
}