package com.sakkeerhussain.filecache.ui.request

import com.sakkeerhussain.filecache.ui.client.BaseTarget

class JsonRequestBuilderImpl(url: String) : RequestBuilder{

    override val request: Request
    override var target: BaseTarget? = null

    init {
        request = ImageRequest(url)
    }

    override fun addHeader(name: String, value: String): RequestBuilder {
        this.request.headers[name] = value
        return this
    }

    override fun toTarget(target: BaseTarget) {
        this.target = target

    }

}