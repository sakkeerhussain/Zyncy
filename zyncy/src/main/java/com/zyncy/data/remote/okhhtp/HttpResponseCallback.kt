package com.zyncy.data.remote.okhhtp

import com.zyncy.data.callback.ResponseCallback
import com.zyncy.data.request.Request

interface HttpResponseCallback {

    val request: Request
    val callback: ResponseCallback
}