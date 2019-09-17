package com.sakkeerhussain.filesync.data.remote.okhhtp

import com.sakkeerhussain.filesync.data.request.Request
import okhttp3.Callback

/*
 * Created by Sakkeer Hussain on 2019-09-15.
 */

interface OkhttpService {

    fun get(request: Request, callback: Callback)
}