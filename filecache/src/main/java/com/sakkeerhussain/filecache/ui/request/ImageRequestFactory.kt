package com.sakkeerhussain.filecache.ui.request

open class ImageRequestFactory: RequestFactory {

    override fun getRequest(url: String): ImageRequest {

        // TODO - Update this logic
        return ImageRequest(url)

    }
}