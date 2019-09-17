package com.sakkeerhussain.filecache.data.repository

import com.sakkeerhussain.filecache.data.request.Request

/*
 * Created by Sakkeer Hussain on 2019-09-14.
 */
interface ImageRepository {
    fun getImage(request: Request)
}