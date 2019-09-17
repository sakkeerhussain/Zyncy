package com.sakkeerhussain.filecache.ui.client

import com.sakkeerhussain.filecache.data.request.RequestBuilder

interface RemoteFile {

    fun loadImage(url: String): RequestBuilder
    fun loadJson(url: String): RequestBuilder
}