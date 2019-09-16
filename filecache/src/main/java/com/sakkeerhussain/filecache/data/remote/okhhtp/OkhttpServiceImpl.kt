package com.sakkeerhussain.filecache.data.remote.okhhtp

import android.graphics.BitmapFactory
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Response
import java.io.IOException


/*
 * Created by Sakkeer Hussain on 2019-09-15.
 */

class OkhttpServiceImpl(val client: OkHttpClient): OkhttpService {

    override fun get(request: Request) {

        // Status update
        request.updateState(Request.State.IN_PROGRESS)

        val requestBuilder = okhttp3.Request.Builder().url(request.url)
        request.headers.keys.forEach { key ->
            requestBuilder.addHeader(key, request.headers.getValue(key))
        }
        val httpsRequest = client.newCall(requestBuilder.build())
        request.httpsRequest = httpsRequest
        httpsRequest.enqueue(object:okhttp3.Callback{
            override fun onFailure(call: Call, e: IOException) {
                // TODO - Handle failure case
            }

            override fun onResponse(call: Call, response: Response) {
                println("Response...")
                response.body ?: onFailure(call, IOException("Received null response"))
                val inputStream = response.body!!.byteStream()
                val bitmap = BitmapFactory.decodeStream(inputStream);
            }
        })
    }
}
