package com.sakkeer.zyncy.data.cache

import android.graphics.Bitmap
import com.sakkeer.zyncy.data.callback.ImageResponseCallback
import com.sakkeer.zyncy.data.callback.ResponseCallback
import com.sakkeer.zyncy.data.request.Request

/*
 * Created by Sakkeer Hussain on 2019-09-15.
 */
interface ImageCacheDao: BaseCache {

    fun getImage(request: Request, callback: ImageResponseCallback): Boolean
    fun cacheImage(request: Request, bitmap: Bitmap)

    override fun get(request: Request, callback: ResponseCallback): Boolean {

        if (callback !is ImageResponseCallback) return false

        return this.getImage(request, callback)
    }

    override fun cache(request: Request, data: Any) {

        if (data !is Bitmap) return

        this.cacheImage(request, data)
    }
}