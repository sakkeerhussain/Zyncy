package com.sakkeerhussain.filecache.data.remote

import android.graphics.BitmapFactory
import com.sakkeerhussain.filecache.data.remote.okhhtp.ImageRequestFactory
import com.sakkeerhussain.filecache.data.remote.okhhtp.OkhttpService
import okhttp3.Call
import okhttp3.Response
import java.io.IOException

class ImageServiceDaoImpl(
    private val mRemoteService: OkhttpService,
    private val mImageRequestFactory: ImageRequestFactory
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

    fun getImage(url: String) {
        val request = mImageRequestFactory.getRequest(url)
        mRemoteService.get(request, mCallback)
    }
}