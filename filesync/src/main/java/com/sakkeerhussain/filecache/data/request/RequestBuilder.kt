package com.sakkeerhussain.filecache.data.request

import com.sakkeerhussain.filecache.ui.client.BaseTarget

interface RequestBuilder {

    var url: String
    var headers: HashMap<String, String>

    fun addHeader(name: String, value: String): RequestBuilder
    fun toTarget(target: BaseTarget)
}