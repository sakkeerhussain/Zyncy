package com.sakkeer.filesync.data.callback

import com.sakkeer.filesync.data.request.Request
import java.io.InputStream

interface ResponseCallback {

    val request: Request

    fun onFailure(e: Exception)
    fun onResponse(inputStream: InputStream, fromCache: Boolean)

    fun removeRequestFromQueue() {


    }
}