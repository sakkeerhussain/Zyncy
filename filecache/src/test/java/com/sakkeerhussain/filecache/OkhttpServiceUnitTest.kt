package com.sakkeerhussain.filecache;

import com.sakkeerhussain.filecache.data.remote.okhhtp.OkhttpServiceImpl;
import com.sakkeerhussain.filecache.data.remote.okhhtp.Request
import junit.framework.Assert.assertEquals
import org.junit.Test;




class OkhttpServiceUnitTest {
    @Test
    public fun addition_isCorrect() {

        val url = "https://images.unsplash.com/profile-1464495186405-68089dcd96c3?ixlib=rb-0.3.5\\u" +
                "0026q=80\\u0026fm=jpg\\u0026crop=faces\\u0026fit=crop\\u0026h=128\\u0026w=128\\u0026" +
                "s=622a88097cf6661f84cd8942d851d9a2"

        val request = Request()

        OkhttpServiceImpl().get(url)

        assertEquals(4, 2 + 2);
    }
}