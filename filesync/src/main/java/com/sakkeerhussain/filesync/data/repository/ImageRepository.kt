package com.sakkeerhussain.filesync.data.repository

import com.sakkeerhussain.filesync.data.request.Request

/*
 * Created by Sakkeer Hussain on 2019-09-14.
 */
interface ImageRepository {
    fun getImage(request: Request)
}