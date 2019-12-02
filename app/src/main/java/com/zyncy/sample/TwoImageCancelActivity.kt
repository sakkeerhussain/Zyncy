package com.zyncy.sample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zyncy.client.Zyncy
import com.zyncy.data.request.Request
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

        val url = "https://images.unsplash.com/profile-1464495186405-68089dcd96c3"

        mRequest1 = Zyncy
            .loadImage(url)
            .placeholder(R.drawable.placeholder)
            .errorImage(R.drawable.error_image)
            .toTarget(ivTest1)

        mRequest2 = Zyncy
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
