package com.zyncy.data.repository

import com.zyncy.client.BaseTarget
import com.zyncy.data.request.Request

/*
 * Created by Sakkeer Hussain on 2019-09-14.
 */
interface BaseRepository {
    fun get(request: Request, target: BaseTarget): Request
    fun dequeRequest(request: Request)
    fun cancelRequest(request: Request)
    fun cacheRequest(request: Request, data: Any)
    fun clearCache()
}