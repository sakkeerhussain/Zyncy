package com.zyncy.data.repository

import android.graphics.Bitmap
import com.zyncy.client.BaseTarget
import com.zyncy.data.request.Request

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
}