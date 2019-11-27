package com.sakkeer.zyncy.data.remote.okhhtp

import com.sakkeer.zyncy.data.callback.ResponseCallback
import com.sakkeer.zyncy.data.request.Request

interface HttpResponseCallback {

    val request: Request
    val callback: ResponseCallback
}