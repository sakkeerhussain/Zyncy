package com.sakkeerhussain.filecache.data.remote.okhhtp

interface RequestBuilder {

    val request: Request

    fun setUrl(url: String): RequestBuilder {
        this.request.url = url
        return this
    }
}