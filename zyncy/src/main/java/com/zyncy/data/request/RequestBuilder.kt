package com.zyncy.data.request

import com.zyncy.client.BaseTarget

interface RequestBuilder {

    var url: String
    var headers: HashMap<String, String>

    fun addHeader(name: String, value: String): RequestBuilder
    fun toTarget(target: BaseTarget): Request
}