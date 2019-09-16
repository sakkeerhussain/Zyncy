package com.sakkeerhussain.filecache.ui.request

import com.sakkeerhussain.filecache.ui.client.BaseTarget

interface RequestBuilder {

    val request: Request
    var target: BaseTarget?

    fun addHeader(name: String, value: String): RequestBuilder
    fun toTarget(target: BaseTarget)
}