package com.sakkeer.zyncy.sample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sakkeer.zyncy.client.Zyncy
import com.sakkeer.zyncy.data.request.Request
import kotlinx.android.synthetic.main.activity_cancel_option.*

class CancelOptionActivity : AppCompatActivity() {

    private lateinit var mRequest: Request

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cancel_option)

        setupViews()
        setupListeners()
    }

    private fun setupViews() {

        val url = "https://images.unsplash.com/profile-1464495186405-68089dcd96c3"

        mRequest = Zyncy
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
