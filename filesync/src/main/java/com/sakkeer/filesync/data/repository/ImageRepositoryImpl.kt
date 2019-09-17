package com.sakkeer.filesync.data.repository

import com.sakkeer.filesync.data.remote.ImageServiceDao
import com.sakkeer.filesync.data.request.Request

/*
 * Created by Sakkeer Hussain on 2019-09-14.
 */
class ImageRepositoryImpl(
    private val mImageServiceDao: ImageServiceDao
): ImageRepository {

    override fun getImage(request: Request) {
        if (false) {  // a cache miss
            // Fetch from cache
        } else {
            mImageServiceDao.getImage(request)
        }
    }
}