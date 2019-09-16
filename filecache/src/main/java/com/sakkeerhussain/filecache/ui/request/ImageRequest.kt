package com.sakkeerhussain.filecache.ui.request

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import okhttp3.Call

/*
 * Created by Sakkeer Hussain on 2019-09-15.
 */
class ImageRequest(override var url: String) : Request {
    override var headers: HashMap<String, String> = hashMapOf()
    override var listeners: Int = 0
    override var state: MutableLiveData<Request.State> = MutableLiveData()
    override var progress: LiveData<Int>? = null
    override var httpsRequest: Call? = null

    override fun updateState(state: Request.State) {
        this.state.value = state
    }

}