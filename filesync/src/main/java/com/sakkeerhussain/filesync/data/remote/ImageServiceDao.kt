package com.sakkeerhussain.filesync.data.remote

import com.sakkeerhussain.filesync.data.request.Request

/*
 * Created by Sakkeer Hussain on 2019-09-15.
 */
interface ImageServiceDao {

    fun getImage(request: Request)
}