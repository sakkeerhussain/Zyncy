package com.sakkeer.filesync.sample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sakkeer.filesync.client.FileSync
import com.sakkeer.filesync.data.request.Request
import kotlinx.android.synthetic.main.activity_two_image_cancel.*

class TwoImageCancelActivity : AppCompatActivity() {

    private lateinit var mRequest1: Request
    private lateinit var mRequest2: Request

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_image_cancel)

        setupViews()
        setupListeners()
    }

    private fun setupViews() {

        val url = "http://images.unsplash.com/profile-1464495186405-68089dcd96c3?ixlib=" +
                "rb-0.3.5\\u0026q=80\\u0026fm=jpg\\u0026crop=faces\\u0026fit=crop\\u0026h=128" +
                "\\u0026w=128\\u0026s=622a88097cf6661f84cd8942d851d9a2"

        mRequest1 = FileSync
            .loadImage(url)
            .placeholder(R.drawable.placeholder)
            .errorImage(R.drawable.error_image)
            .toTarget(ivTest1)

        mRequest2 = FileSync
            .loadImage(url)
            .placeholder(R.drawable.placeholder)
            .errorImage(R.drawable.error_image)
            .toTarget(ivTest2)

    }

    private fun setupListeners() {

        btnCancel1.setOnClickListener {
            mRequest1.cancel()
            Toast.makeText(this, "Canceled image-1 request", Toast.LENGTH_SHORT).show()
        }

        btnCancel2.setOnClickListener {
            mRequest2.cancel()
            Toast.makeText(this, "Canceled image-2 request", Toast.LENGTH_SHORT).show()
        }
    }
}
