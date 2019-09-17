package com.sakkeer.filesync.cache

import android.graphics.Bitmap
import com.sakkeer.filesync.data.cache.ImageCacheDao
import com.sakkeer.filesync.data.remote.ImageServiceDao
import com.sakkeer.filesync.data.repository.ImageRepositoryImpl
import com.sakkeer.filesync.data.request.ImageRequest
import com.sakkeer.filesync.data.request.RequestQueue
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.times

class ImageCacheDaoUnitTest {

    val TEST_URL = "http://test.com/photo.jpg"

    @Test
    fun cacheHitTest() {

        val imageService = Mockito.mock(ImageServiceDao::class.java)
        val requestQueue = Mockito.mock(RequestQueue::class.java)
        val bitmap = Mockito.mock(Bitmap::class.java)
        val imageCache = Mockito.mock(ImageCacheDao::class.java)

        val imageRepository = ImageRepositoryImpl(imageService, imageCache, requestQueue)
        val request1 = ImageRequest(TEST_URL)

        imageRepository.cacheRequest(request1, bitmap)
        Mockito.verify(imageCache, times(1)).cacheImage(request1, bitmap)
    }

//    @Test
//    fun cacheMissTest() {
//
//        val imageService = Mockito.mock(ImageServiceDao::class.java)
//        val requestQueue = Mockito.mock(RequestQueue::class.java)
//        val mockTarget = Mockito.mock(ImageTarget::class.java)
//        val imageCache = Mockito.mock(ImageCacheDao::class.java)
//        val imageRepository = ImageRepositoryImpl(imageService, imageCache, requestQueue)
//
//        val request1 = ImageRequest(TEST_URL)
//        Mockito.`when`(requestQueue.enqueue(request1, any(BaseTarget::class.java))).thenReturn(request1)
//
//        for (i in 1 .. 10) {
//            imageRepository.get(request1, mockTarget)
//        }
//        Mockito.verify(imageService, times(10)).getImage(request1, any())
//    }
}