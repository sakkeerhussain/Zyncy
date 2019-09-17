package com.sakkeer.filesync.data.cache

import com.sakkeer.filesync.data.callback.ImageResponseCallback
import com.sakkeer.filesync.data.request.Request

/*
 * Created by Sakkeer Hussain on 2019-09-15.
 */
interface ImageCacheDao: BaseCache {

    fun getImage(request: Request, callback: ImageResponseCallback)
}