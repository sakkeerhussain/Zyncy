package com.sakkeer.zyncy.data.cache

import com.sakkeer.zyncy.data.callback.ResponseCallback
import com.sakkeer.zyncy.data.request.Request

/*
 * Created by Sakkeer Hussain on 2019-09-15.
 */
interface BaseCache {
    fun get(request: Request, callback: ResponseCallback): Boolean
    fun cache(request: Request, data: Any)
    fun clearCache()
}