package com.sakkeerhussain.filecache.data.repository

import com.sakkeerhussain.filecache.data.remote.ImageServiceDao

/*
 * Created by Sakkeer Hussain on 2019-09-14.
 */
class ImageRepositoryImpl(
    private val mImageServiceDao: ImageServiceDao
): ImageRepository {

    override fun getImage(url: String) {
        if (true) {  // a cache miss
            // Fetch from cache
        } else {
            mImageServiceDao.getImage(url)
        }
    }
}