package com.sakkeerhussain.filesync.ui.client

import com.sakkeerhussain.filesync.data.remote.ImageServiceDao
import com.sakkeerhussain.filesync.data.remote.ImageServiceDaoImpl
import com.sakkeerhussain.filesync.data.remote.okhhtp.OkhttpService
import com.sakkeerhussain.filesync.data.remote.okhhtp.OkhttpServiceImpl
import com.sakkeerhussain.filesync.data.repository.ImageRepository
import com.sakkeerhussain.filesync.data.repository.ImageRepositoryImpl
import com.sakkeerhussain.filesync.data.request.*
import okhttp3.OkHttpClient

object FileSync {

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
    val imageRepo: ImageRepository = ImageRepositoryImpl(imageServiceDao)
    val mRequestQueue: RequestQueue = RequestQueueImpl(imageRepo)

    fun loadImage(url: String): ImageRequestBuilderImpl {
        return ImageRequestBuilderImpl(mRequestQueue, url)
    }

    fun loadJson(url: String): RequestBuilder {
        return JsonRequestBuilderImpl(mRequestQueue, url)
    }
}