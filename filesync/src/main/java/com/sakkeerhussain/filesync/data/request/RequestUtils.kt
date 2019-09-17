package com.sakkeerhussain.filesync.data.request

interface RequestUtils {
    fun getExistingImageRequest(request: Request): ImageRequest?
}