package com.sakkeerhussain.filecache

import androidx.lifecycle.MutableLiveData
import com.sakkeerhussain.filecache.data.remote.okhhtp.ImageRequest
import com.sakkeerhussain.filecache.data.remote.okhhtp.ImageRequestFactory
import com.sakkeerhussain.filecache.data.remote.okhhtp.Request
import org.mockito.Mockito

class MockImageRequestFactory {

    fun getRequest(url: String): ImageRequest {

//        val state = Mockito.mock(MutableLiveData::class.java)
        val request = ImageRequestFactory().getRequest(url)
//        request.state = state as MutableLiveData<Request.State>
        return request

    }
}