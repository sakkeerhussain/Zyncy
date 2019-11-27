package com.sakkeer.zyncy.data.remote

import com.sakkeer.zyncy.data.callback.ImageResponseCallback
import com.sakkeer.zyncy.data.remote.okhhtp.HttpResponseCallbackImpl
import com.sakkeer.zyncy.data.remote.okhhtp.OkhttpService
import com.sakkeer.zyncy.data.request.Request

class ImageServiceDaoImpl(
    private val mRemoteService: OkhttpService
): ImageServiceDao {

    override fun getImage(request: Request, callback: ImageResponseCallback) {
        val httpCallback = HttpResponseCallbackImpl(request, callback)
        mRemoteService.get(request, httpCallback)
    }
}