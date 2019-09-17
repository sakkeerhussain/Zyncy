package com.sakkeer.filesync.data.cache

import android.graphics.Bitmap
import com.sakkeer.filesync.data.callback.ImageResponseCallback
import com.sakkeer.filesync.data.request.Request

/*
 * Created by Sakkeer Hussain on 2019-09-15.
 */
class ImageCacheDaoImpl: BaseCache {

    val map = Map<String, Bitmap>

    fun getImage(request: Request, callback: ImageResponseCallback) {

    }
}