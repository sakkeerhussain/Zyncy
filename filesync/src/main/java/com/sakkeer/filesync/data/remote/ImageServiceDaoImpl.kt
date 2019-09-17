package com.sakkeer.filesync.data.remote

import com.sakkeer.filesync.data.callback.ImageResponseCallback
import com.sakkeer.filesync.data.remote.okhhtp.OkhttpService
import com.sakkeer.filesync.data.request.Request

class ImageServiceDaoImpl(
    private val mRemoteService: OkhttpService
): ImageServiceDao {

    override fun getImage(request: Request, callback: ImageResponseCallback) {
        val httpCallback = CacheResponseCallbackImpl(request, callback)
        mRemoteService.get(request, httpCallback)
    }
}