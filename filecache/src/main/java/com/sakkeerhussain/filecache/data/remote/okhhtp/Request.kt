package com.sakkeerhussain.filecache.data.remote.okhhtp

import androidx.lifecycle.LiveData
import okhttp3.Call

/*
 * Created by Sakkeer Hussain on 2019-09-15.
 */
interface Request {

    var url: String
    var headers: Map<String, String>
    var listeners: Int
    var state: LiveData<State>
    var progress: LiveData<Int>?
    var httpsRequest: Call?

    fun updateState(state: State)

    enum class State{
        PLACED, WAITING, IN_PROGRESS, FETCHED, SERVED
    }
}