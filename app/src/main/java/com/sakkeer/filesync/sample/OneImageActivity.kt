package com.sakkeer.filesync.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sakkeer.filesync.client.FileSync
import kotlinx.android.synthetic.main.activity_one_image.*

class OneImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_image)

        setupViews()
    }

    private fun setupViews() {

        val url = "https://images.unsplash.com/profile-1464495186405-68089dcd96c3"

        FileSync
            .loadImage(url)
            // .addHeader("Authorization", "token goes here") // Add only if required
            .placeholder(R.drawable.placeholder)
            .errorImage(R.drawable.error_image)
            .toTarget(testImageView)
    }
}
