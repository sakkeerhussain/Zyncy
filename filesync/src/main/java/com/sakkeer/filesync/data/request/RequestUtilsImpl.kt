package com.sakkeer.filesync.data.request

class RequestUtilsImpl(
    val mRequestQueue: RequestQueue
): RequestUtils {

    override fun getExistingImageRequest(request: Request): Request? {

        val url = request.url
        val requests = mRequestQueue.getActiveRequests().filter {  it.url == url }
        return if (requests.isNotEmpty()) requests[0] else null
    }
}