package com.sakkeerhussain.filecache.data.repository

import com.sakkeerhussain.filecache.data.remote.ImageServiceDao
import com.sakkeerhussain.filecache.data.request.Request

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