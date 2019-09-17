package com.sakkeerhussain.filecache.data.remote.okhhtp

import com.sakkeerhussain.filecache.data.request.Request
import okhttp3.Callback
import okhttp3.OkHttpClient


/*
 * Created by Sakkeer Hussain on 2019-09-15.
 */

class OkhttpServiceImpl(val mClient: OkHttpClient): OkhttpService {

    override fun get(request: Request, callback: Callback) {

        // Status update
        request.updateState(Request.State.IN_PROGRESS)

        val requestBuilder = okhttp3.Request.Builder().url(request.url)
        request.headers.keys.forEach { key ->
            requestBuilder.addHeader(key, request.headers.getValue(key))
        }
        val httpsRequest = mClient.newCall(requestBuilder.build())
        request.httpsRequest = httpsRequest
        httpsRequest.enqueue(callback)
    }
}
