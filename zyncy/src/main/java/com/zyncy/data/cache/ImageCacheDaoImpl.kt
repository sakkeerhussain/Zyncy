package com.zyncy.data.cache

import android.graphics.Bitmap
import com.zyncy.data.callback.ImageResponseCallback
import com.zyncy.data.request.Request

/*
 * Created by Sakkeer Hussain on 2019-09-15.
 */
class ImageCacheDaoImpl: ImageCacheDao {

    private val mMemoryCache: LruCache = LruCache()

    override fun getImage(request: Request, callback: ImageResponseCallback): Boolean {
        val bitmap = mMemoryCache.get(request.url)

        return if (bitmap == null) {
            false
        } else {
            callback.onResponse(bitmap, true)
            true
        }
    }

    override fun cacheImage(request: Request, bitmap: Bitmap) {
        mMemoryCache.put(request.url, bitmap)
    }

    override fun clearCache() {
        mMemoryCache.evictAll()
    }
}
