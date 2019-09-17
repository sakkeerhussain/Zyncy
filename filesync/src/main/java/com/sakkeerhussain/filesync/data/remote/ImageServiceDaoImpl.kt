package com.sakkeerhussain.filesync.data.remote

import android.graphics.BitmapFactory
import com.sakkeerhussain.filesync.data.remote.okhhtp.OkhttpService
import com.sakkeerhussain.filesync.data.request.Request
import okhttp3.Call
import okhttp3.Response
import java.io.IOException

class ImageServiceDaoImpl(
    private val mRemoteService: OkhttpService
): ImageServiceDao {

    private val mCallback = object:okhttp3.Callback{
        override fun onFailure(call: Call, e: IOException) {
            // TODO - Handle failure case
            println(e.message)
        }

        override fun onResponse(call: Call, response: Response) {
            println("Response...")
            response.body ?: onFailure(call, IOException("Received null response"))
            val inputStream = response.body!!.byteStream()
            val bitmap = BitmapFactory.decodeStream(inputStream);
        }
    }

    override fun getImage(request: Request) {
        mRemoteService.get(request, mCallback)
    }
}