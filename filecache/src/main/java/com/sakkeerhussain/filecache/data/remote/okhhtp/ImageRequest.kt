package com.sakkeerhussain.filecache.data.remote.okhhtp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import okhttp3.Call

/*
 * Created by Sakkeer Hussain on 2019-09-15.
 */
class ImageRequest(override var url: String) : Request {
    override var headers: Map<String, String> = emptyMap()
    override var listeners: Int = 0
    override var state: LiveData<Request.State> = MutableLiveData()
    override var progress: LiveData<Int>? = null
    override var httpsRequest: Call? = null

    override fun updateState(state: Request.State) {
        (this.state as MutableLiveData<Request.State>).value = state
    }

}