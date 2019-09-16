package com.sakkeerhussain.filecache

import com.sakkeerhussain.filecache.ui.request.ImageRequest
import com.sakkeerhussain.filecache.ui.request.ImageRequestFactory

class MockImageRequestFactory {

    fun getRequest(url: String): ImageRequest {

//        val state = Mockito.mock(MutableLiveData::class.java)
        val request = ImageRequestFactory().getRequest(url)
//        request.state = state as MutableLiveData<Request.State>
        return request

    }
}