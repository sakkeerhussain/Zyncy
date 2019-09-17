package com.sakkeer.filesync.data.remote.okhhtp

import com.sakkeer.filesync.data.callback.ResponseCallback
import com.sakkeer.filesync.data.request.Request

interface HttpResponseCallback {

    val request: Request
    val callback: ResponseCallback
}