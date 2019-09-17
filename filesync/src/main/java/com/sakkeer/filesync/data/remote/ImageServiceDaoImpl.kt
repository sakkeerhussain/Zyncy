package com.sakkeer.filesync.data.remote

import com.sakkeer.filesync.data.remote.okhhtp.OkhttpService
import com.sakkeer.filesync.data.remote.okhhtp.ImageRequestCallbackImpl
import com.sakkeer.filesync.data.request.Request

class ImageServiceDaoImpl(
    private val mRemoteService: OkhttpService
): ImageServiceDao {

    override fun getImage(request: Request) {
        val callback = ImageRequestCallbackImpl(request)
        mRemoteService.get(request, callback)
    }
}