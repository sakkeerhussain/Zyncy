package com.sakkeer.filesync.data.repository

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

    override fun dequeRequest(request: Request)
    override fun cancelRequest(request: Request)
}