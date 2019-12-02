package com.zyncy.data.remote.okhhtp

import com.zyncy.data.request.Request
import okhttp3.Callback

/*
 * Created by Sakkeer Hussain on 2019-09-15.
 */

interface OkhttpService {

    fun get(request: Request, callback: Callback)
}