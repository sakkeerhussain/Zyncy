package com.sakkeerhussain.filecache.ui.request

interface RequestFactory {
    fun getRequest(url: String): ImageRequest
}