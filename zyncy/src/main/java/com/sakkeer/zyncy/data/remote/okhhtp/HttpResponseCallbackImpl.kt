package com.sakkeer.zyncy.data.remote.okhhtp

import com.sakkeer.zyncy.data.request.Request
import com.sakkeer.zyncy.data.callback.ResponseCallback
import okhttp3.Call
import okhttp3.Response
import java.io.IOException

class HttpResponseCallbackImpl(
    override val request: Request,
    override val callback: ResponseCallback
) : HttpResponseCallback, okhttp3.Callback{

    override fun onFailure(call: Call, e: IOException) {
        this.callback.onFailure(e)
    }

    override fun onResponse(call: Call, response: Response) {

        val body = response.body
        if (body == null) {
            onFailure(call, IOException("Received null response"))
            return
        }

        this.callback.onResponse(body.byteStream(), false)
    }
}