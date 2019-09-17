package com.sakkeerhussain.filecache

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sakkeerhussain.filecache.ui.client.RemoteFileImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://images.unsplash.com/profile-1464495186405-68089dcd96c3?ixlib=rb-0.3.5\\u" +
                "0026q=80\\u0026fm=jpg\\u0026crop=faces\\u0026fit=crop\\u0026h=128\\u0026w=128\\u0026" +
                "s=622a88097cf6661f84cd8942d851d9a2"

        RemoteFileImpl
            .loadImage(url)
            .addHeader("Authorization", "token goes here")
            .toTarget(testImageView)
    }
}