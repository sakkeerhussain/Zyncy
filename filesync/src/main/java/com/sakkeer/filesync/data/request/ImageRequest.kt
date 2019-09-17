package com.sakkeer.filesync.data.request

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sakkeer.filesync.client.BaseTarget
import com.sakkeer.filesync.client.ImageTarget
import com.sakkeer.filesync.data.repository.BaseRepository
import okhttp3.Call

/*
 * Created by Sakkeer Hussain on 2019-09-15.
 */
class ImageRequest(override var url: String) : Request {

    override var headers: HashMap<String, String> = hashMapOf()
    override var targets: ArrayList<BaseTarget> = arrayListOf()
    override var state: MutableLiveData<Request.State> = MutableLiveData()
    override var progress: LiveData<Int>? = null
    override var httpsRequest: Call? = null
    override var repository: BaseRepository? = null
    var placeHolderImageResource: Int? = null
    var errorImageResource: Int? = null

    override fun updateState(state: Request.State) {
        this.state.value = state
    }

    override fun addTarget(target: BaseTarget) {
        this.targets.add(target)
        displayPlaceHolder(target as ImageTarget)
    }

    override fun cancel() {
        this.repository?.cancelRequest(this)
    }

    private fun displayPlaceHolder(target: ImageTarget) {
        val img = placeHolderImageResource ?: return
        target.loadImage(img)
    }

}