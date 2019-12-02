package com.zyncy.data.callback

import com.zyncy.data.request.Request
import java.io.InputStream

interface ResponseCallback {

    val request: Request

    fun onFailure(e: Exception)
    fun onResponse(inputStream: InputStream, fromCache: Boolean)

    fun removeRequestFromQueue() {


    }
}