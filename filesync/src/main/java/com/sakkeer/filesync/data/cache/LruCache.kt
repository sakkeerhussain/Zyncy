package com.sakkeer.filesync.data.cache

import android.graphics.Bitmap
import android.util.LruCache

class LruCache : LruCache<String, Bitmap>(getMaxCache()) {

    override fun sizeOf(url: String?, bitmap: Bitmap?): Int {
        bitmap ?: return 0
        return bitmap.byteCount / 1024
    }

    companion object {
        private fun getMaxCache(): Int {

            val maxMemory = Runtime.getRuntime().maxMemory()
            // Using 1/8 th of available memory for caching
            val cacheLimit = (maxMemory / 8).toInt()
            return cacheLimit
        }
    }
}