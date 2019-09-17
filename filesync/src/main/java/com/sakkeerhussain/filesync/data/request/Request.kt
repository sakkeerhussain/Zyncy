package com.sakkeerhussain.filesync.data.request

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sakkeerhussain.filesync.client.BaseTarget
import okhttp3.Call

/*
 * Created by Sakkeer Hussain on 2019-09-15.
 */
interface Request {

    var url: String
    var headers: HashMap<String, String>
    var state: MutableLiveData<State>
    var progress: LiveData<Int>?
    var targets: ArrayList<BaseTarget>
    var httpsRequest: Call?

    fun updateState(state: State)
    fun addTarget(target: BaseTarget)

    enum class State{
        PLACED, WAITING, IN_PROGRESS, FETCHED, SERVED
    }
}