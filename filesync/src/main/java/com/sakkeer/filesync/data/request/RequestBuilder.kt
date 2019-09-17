package com.sakkeer.filesync.data.request

import com.sakkeer.filesync.client.BaseTarget

interface RequestBuilder {

    var url: String
    var headers: HashMap<String, String>

    fun addHeader(name: String, value: String): RequestBuilder
    fun toTarget(target: BaseTarget)
}