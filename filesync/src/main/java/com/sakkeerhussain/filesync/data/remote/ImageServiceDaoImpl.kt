package com.sakkeerhussain.filesync.data.remote

import com.sakkeerhussain.filesync.data.remote.okhhtp.OkhttpService
import com.sakkeerhussain.filesync.data.remote.okhhtp.ImageRequestCallbackImpl
import com.sakkeerhussain.filesync.data.request.Request

class ImageServiceDaoImpl(
    private val mRemoteService: OkhttpService
): ImageServiceDao {

    override fun getImage(request: Request) {
        val callback = ImageRequestCallbackImpl(request)
        mRemoteService.get(request, callback)
    }
}