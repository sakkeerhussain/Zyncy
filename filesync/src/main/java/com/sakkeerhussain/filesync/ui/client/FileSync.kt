package com.sakkeerhussain.filesync.ui.client

import com.sakkeerhussain.filesync.data.remote.ImageServiceDaoImpl
import com.sakkeerhussain.filesync.data.remote.okhhtp.OkhttpServiceImpl
import com.sakkeerhussain.filesync.data.repository.ImageRepositoryImpl
import com.sakkeerhussain.filesync.data.request.ImageRequestQueueImpl
import com.sakkeerhussain.filesync.data.request.RequestBuilder
import okhttp3.OkHttpClient

interface FileSync {

    fun loadImage(url: String): RequestBuilder
    fun loadJson(url: String): RequestBuilder


    // Option to connect from client code
    // TODO - Could ask client code use with dependecy injection, so that this code can be removed
    companion object {

        fun getClient(): FileSyncImpl {
            // TODO - Implement dependency injection in side file sync library,
            //  hence update this approach
            val client = OkHttpClient()
            val remoteService = OkhttpServiceImpl(client)
            val imageServiceDao = ImageServiceDaoImpl(remoteService)
            val imageRepo = ImageRepositoryImpl(imageServiceDao)
            val queue = ImageRequestQueueImpl(imageRepo)
            return FileSyncImpl(queue)
        }
    }
}