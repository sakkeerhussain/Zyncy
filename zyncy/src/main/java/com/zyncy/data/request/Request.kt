package com.zyncy.data.request

import com.zyncy.client.BaseTarget
import com.zyncy.data.repository.BaseRepository
import okhttp3.Call

/*
 * Created by Sakkeer Hussain on 2019-09-15.
 */
interface Request {

    var url: String
    var headers: HashMap<String, String>
    var state: State
    // var progress: LiveData<Int>?
    var targets: ArrayList<BaseTarget>
    var httpsRequest: Call?
    var repository: BaseRepository?

    fun updateState(state: State)
    fun addTarget(target: BaseTarget)
    fun cancel()

    enum class State{
        PLACED, WAITING, IN_PROGRESS, FETCHED, SERVED
    }
}