package com.sakkeer.filesync.data.repository

import com.sakkeer.filesync.client.BaseTarget
import com.sakkeer.filesync.data.request.Request

/*
 * Created by Sakkeer Hussain on 2019-09-14.
 */
interface BaseRepository {
    fun get(request: Request, target: BaseTarget): Request
    fun dequeRequest(request: Request)
    fun cancelRequest(request: Request)
    fun cacheRequest(request: Request, data: Any)
}