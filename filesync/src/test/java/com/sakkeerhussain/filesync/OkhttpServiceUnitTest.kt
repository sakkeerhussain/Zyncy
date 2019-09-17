package com.sakkeerhussain.filesync;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sakkeerhussain.filesync.data.remote.okhhtp.OkhttpServiceImpl
import com.sakkeerhussain.filesync.data.request.ImageRequest
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Response
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.spy
import java.io.IOException


class OkhttpServiceUnitTest {

    private val TEST_URL = "http://test.jpg"

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun httpServiceTest() {

        val client = spy(OkHttpClient::class.java)
        val callback = MockHttpCallBack()
        val testRequest = okhttp3.Request.Builder().url(TEST_URL).build()
        val testCall = client.newCall(testRequest)
        testCall.enqueue(callback)

        assert(callback.result ?: false)
    }


    @Test
    fun remoteServiceDevCheck() {

        val client = Mockito.mock(OkHttpClient::class.java)
        val callback = MockHttpCallBack()
        val url = "https://images.unsplash.com/profile-1464495186405-68089dcd96c3?ixlib=rb-0.3.5\\u" +
                "0026q=80\\u0026fm=jpg\\u0026crop=faces\\u0026fit=crop\\u0026h=128\\u0026w=128\\u0026" +
                "s=622a88097cf6661f84cd8942d851d9a2"

        val request = ImageRequest(url)
        OkhttpServiceImpl(client).get(request, callback)

        assert(callback.result ?: false)
    }
}

class MockHttpCallBack: Callback {

    var result: Boolean? = null

    override fun onFailure(call: Call, e: IOException) {
        result = false
    }

    override fun onResponse(call: Call, response: Response) {
        result = true
    }

}