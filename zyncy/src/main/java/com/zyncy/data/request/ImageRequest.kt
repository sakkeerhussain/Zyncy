package com.zyncy.data.request

import com.zyncy.client.BaseTarget
import com.zyncy.client.ImageTarget
import com.zyncy.data.repository.BaseRepository
import okhttp3.Call

/*
 * Created by Sakkeer Hussain on 2019-09-15.
 */
class ImageRequest(override var url: String) : Request {

    override var headers: HashMap<String, String> = hashMapOf()
    override var targets: ArrayList<BaseTarget> = arrayListOf()
    override var state: Request.State = Request.State.PLACED
    // override var progress: LiveData<Int>? = null
    override var httpsRequest: Call? = null
    override var repository: BaseRepository? = null
    var placeHolderImageResource: Int? = null
    var errorImageResource: Int? = null

    override fun updateState(state: Request.State) {
        this.state = state
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