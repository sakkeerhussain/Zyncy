package com.sakkeer.filesync.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sakkeer.filesync.client.FileSync
import kotlinx.android.synthetic.main.activity_one_image.*

class OneImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_image)
    }

    private fun setupViews() {

        val url = "http://images.unsplash.com/profile-1464495186405-68089dcd96c3?ixlib=rb-0.3.5\\u" +
                "0026q=80\\u0026fm=jpg\\u0026crop=faces\\u0026fit=crop\\u0026h=128\\u0026w=128\\u0026" +
                "s=622a88097cf6661f84cd8942d851d9a2"

        FileSync
            .loadImage(url)
            // .addHeader("Authorization", "token goes here") // Add only if required
            .placeholder(R.drawable.placeholder)
            .errorImage(R.drawable.error_image)
            .toTarget(testImageView)
    }
}
