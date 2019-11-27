package com.sakkeer.zyncy.data.callback

import com.sakkeer.zyncy.data.request.Request
import java.io.InputStream

interface ResponseCallback {

    val request: Request

    fun onFailure(e: Exception)
    fun onResponse(inputStream: InputStream, fromCache: Boolean)

    fun removeRequestFromQueue() {


    }
}