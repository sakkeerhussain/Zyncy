package com.zyncy.data.remote

import com.zyncy.data.callback.ImageResponseCallback
import com.zyncy.data.remote.okhhtp.HttpResponseCallbackImpl
import com.zyncy.data.remote.okhhtp.OkhttpService
import com.zyncy.data.request.Request

class ImageServiceDaoImpl(
    private val mRemoteService: OkhttpService
): ImageServiceDao {

    override fun getImage(request: Request, callback: ImageResponseCallback) {
        val httpCallback = HttpResponseCallbackImpl(request, callback)
        mRemoteService.get(request, httpCallback)
    }
}