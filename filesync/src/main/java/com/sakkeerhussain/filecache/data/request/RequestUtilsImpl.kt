package com.sakkeerhussain.filecache.data.request

class RequestUtilsImpl(
    val mImageRequestQueueImpl: ImageRequestQueueImpl
): RequestUtils {

    override fun getExistingImageRequest(request: Request): ImageRequest? {

        val url = request.url
        val requests = mImageRequestQueueImpl.mActiveRequests.filter {  it.url == url }
        return if (requests.isNotEmpty()) requests[0] else null
    }
}