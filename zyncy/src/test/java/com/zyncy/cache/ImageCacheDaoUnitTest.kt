package com.zyncy.cache

import android.graphics.Bitmap
import com.zyncy.data.cache.ImageCacheDao
import com.zyncy.data.remote.ImageServiceDao
import com.zyncy.data.repository.ImageRepositoryImpl
import com.zyncy.data.request.ImageRequest
import com.zyncy.data.request.RequestQueue
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