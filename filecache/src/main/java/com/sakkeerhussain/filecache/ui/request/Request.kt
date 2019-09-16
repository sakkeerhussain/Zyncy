package com.sakkeerhussain.filecache.ui.request

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import okhttp3.Call

/*
 * Created by Sakkeer Hussain on 2019-09-15.
 */
interface Request {

    var url: String
    var headers: HashMap<String, String>
    var listeners: Int
    var state: MutableLiveData<State>
    var progress: LiveData<Int>?
    var httpsRequest: Call?

    fun updateState(state: State)

    enum class State{
        PLACED, WAITING, IN_PROGRESS, FETCHED, SERVED
    }
}