package com.sakkeerhussain.filecache.data.request

interface RequestUtils {
    fun getExistingImageRequest(request: Request): ImageRequest?
}