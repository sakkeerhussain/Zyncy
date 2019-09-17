package com.sakkeerhussain.filecache.data.remote

import com.sakkeerhussain.filecache.data.request.Request

/*
 * Created by Sakkeer Hussain on 2019-09-15.
 */
interface ImageServiceDao {

    fun getImage(request: Request)
}