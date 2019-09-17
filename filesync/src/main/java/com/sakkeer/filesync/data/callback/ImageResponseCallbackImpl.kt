package com.sakkeer.filesync.data.callback

import android.graphics.Bitmap
import com.sakkeer.filesync.client.ImageTarget
import com.sakkeer.filesync.data.repository.ImageRepository
import com.sakkeer.filesync.data.request.ImageRequest
import com.sakkeer.filesync.data.request.Request

class ImageResponseCallbackImpl(
    override val request: Request,
    override val mImageRepository: ImageRepository
) : ImageResponseCallback {

    override fun onFailure(e: Exception) {

        mImageRepository.dequeRequest(request)

        if (request is ImageRequest) {
            request.targets.filterIsInstance<ImageTarget>().forEach {
                val img = request.errorImageResource ?: return
                it.loadImage(img)
            }
        }
    }

    override fun onResponse(data: Bitmap, fromCache: Boolean) {

        if (!fromCache) {
            mImageRepository.cacheRequest(request, data)
            mImageRepository.dequeRequest(request)
        }

        request.targets.filterIsInstance<ImageTarget>().forEach {
            it.loadImage(data)
        }

    }
}