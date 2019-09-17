package com.sakkeer.filesync.data.request

import com.sakkeer.filesync.data.repository.ImageRepository
import com.sakkeer.filesync.client.BaseTarget
import com.sakkeer.filesync.client.ImageTarget

class RequestQueueImpl(
    private val mImageRepository: ImageRepository
): RequestQueue {

    private val mRequestUtils = RequestUtilsImpl(this)
    val mActiveRequests: ArrayList<ImageRequest> = arrayListOf()


    // TODO - Make this can handle all type of requests
    override fun enqueue(request: Request, target: BaseTarget): Request {
        if (target !is ImageTarget) {
            throw Exception("Target should be Image target for loading image")
        }
        if (request !is ImageRequest) {
            throw Exception("Request should be Image request for loading image")
        }
        return this.enqueue(request, target)
    }

    // Can be consider moving this to a common target class
    @Synchronized
    fun enqueue(request: ImageRequest, target: ImageTarget): Request {

        val existingRequest = mRequestUtils.getExistingImageRequest(request)

        return if (existingRequest != null) {

            existingRequest.addTarget(target)
            existingRequest
        } else {

            request.addTarget(target)
            mActiveRequests.add(request)
            mImageRepository.getImage(request)
            request
        }
    }
}