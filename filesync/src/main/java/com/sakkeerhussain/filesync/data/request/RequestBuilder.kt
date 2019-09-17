package com.sakkeerhussain.filesync.data.request

import com.sakkeerhussain.filesync.ui.client.BaseTarget

interface RequestBuilder {

    var url: String
    var headers: HashMap<String, String>

    fun addHeader(name: String, value: String): RequestBuilder
    fun toTarget(target: BaseTarget)
}