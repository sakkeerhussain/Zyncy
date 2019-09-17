package com.sakkeer.filesync.sample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sakkeer.filesync.client.FileSync
import com.sakkeer.filesync.data.request.Request
import kotlinx.android.synthetic.main.activity_cancel_option.*
import kotlinx.android.synthetic.main.activity_one_image.testImageView

class CancelOptionActivity : AppCompatActivity() {

    private lateinit var mRequest: Request

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cancel_option)

        setupViews()
        setupListeners()
    }

    private fun setupViews() {

        val url = "http://images.unsplash.com/profile-1464495186405-68089dcd96c3?ixlib=rb-0.3.5\\u" +
                "0026q=80\\u0026fm=jpg\\u0026crop=faces\\u0026fit=crop\\u0026h=128\\u0026w=128\\u0026" +
                "s=622a88097cf6661f84cd8942d851d9a2"

        mRequest = FileSync
            .loadImage(url)
            .placeholder(R.drawable.placeholder)
            .errorImage(R.drawable.error_image)
            .toTarget(testImageView)

    }

    private fun setupListeners() {

        btnCancel.setOnClickListener {
            mRequest.cancel()
            Toast.makeText(this, "Canceled image request", Toast.LENGTH_SHORT).show()
        }
    }
}
