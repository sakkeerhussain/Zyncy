package com.zyncy.data.remote

import com.zyncy.data.callback.ImageResponseCallback
import com.zyncy.data.request.Request

/*
 * Created by Sakkeer Hussain on 2019-09-15.
 */
interface ImageServiceDao: BaseService {

    fun getImage(request: Request, callback: ImageResponseCallback)
}