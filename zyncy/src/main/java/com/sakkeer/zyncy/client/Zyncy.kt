package com.sakkeer.zyncy.client

import com.sakkeer.zyncy.data.cache.ImageCacheDao
import com.sakkeer.zyncy.data.cache.ImageCacheDaoImpl
import com.sakkeer.zyncy.data.remote.ImageServiceDao
import com.sakkeer.zyncy.data.remote.ImageServiceDaoImpl
import com.sakkeer.zyncy.data.remote.okhhtp.OkhttpService
import com.sakkeer.zyncy.data.remote.okhhtp.OkhttpServiceImpl
import com.sakkeer.zyncy.data.repository.ImageRepository
import com.sakkeer.zyncy.data.repository.ImageRepositoryImpl
import com.sakkeer.zyncy.data.request.*
import okhttp3.OkHttpClient

object Zyncy {

//    override val kodein = Kodein.lazy {
//        bind<OkHttpClient>() with provider { OkHttpClient() }
//        bind<OkhttpService>() with provider { OkhttpServiceImpl(instance()) }
//        bind<ImageServiceDao>() with singleton { ImageServiceDaoImpl(instance()) }
//        bind<ImageRepository>() with singleton { ImageRepositoryImpl(instance()) }
//        bind<RequestQueue>() with singleton { RequestQueueImpl(instance()) }
//    }
//    val mRequestQueue: RequestQueue by instance()
    val client = OkHttpClient()
    val remoteService: OkhttpService = OkhttpServiceImpl(client)
    val imageServiceDao: ImageServiceDao = ImageServiceDaoImpl(remoteService)
    val imageCacheDao: ImageCacheDao = ImageCacheDaoImpl()
    val mRequestQueue: RequestQueue = RequestQueueImpl()
    val mImageRepo: ImageRepository = ImageRepositoryImpl(imageServiceDao, imageCacheDao, mRequestQueue)

    // Exposed methods
    fun loadImage(url: String): ImageRequestBuilderImpl {
        return ImageRequestBuilderImpl(mImageRepo, url)
    }

    fun loadJson(url: String): RequestBuilder {
        return JsonRequestBuilderImpl(mRequestQueue, url)
    }

    fun clearImageCache() {
        mImageRepo.clearCache()
    }
}