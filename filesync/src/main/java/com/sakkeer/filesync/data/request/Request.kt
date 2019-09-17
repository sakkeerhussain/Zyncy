package com.sakkeer.filesync.data.request

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sakkeer.filesync.client.BaseTarget
import com.sakkeer.filesync.data.repository.BaseRepository
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
    var repository: BaseRepository?

    fun updateState(state: State)
    fun addTarget(target: BaseTarget)
    fun cancelRequest(request: Request)

    enum class State{
        PLACED, WAITING, IN_PROGRESS, FETCHED, SERVED
    }
}