package com.sakkeer.filesync.data.repository

import android.graphics.Bitmap
import com.sakkeer.filesync.client.BaseTarget
import com.sakkeer.filesync.data.request.Request

/*
 * Created by Sakkeer Hussain on 2019-09-14.
 */
interface ImageRepository: BaseRepository {

    override fun get(request: Request, target: BaseTarget): Request {
        return getImage(request, target)
    }
    fun getImage(request: Request, target: BaseTarget): Request

    override fun cacheRequest(request: Request, data: Any) {
        if (data is Bitmap) this.cacheRequest(request, data)
    }
    fun cacheRequest(request: Request, bitmap: Bitmap)

    override fun dequeRequest(request: Request)
    override fun cancelRequest(request: Request)
}