package com.sakkeer.filesync.sample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupActions()
    }

    private fun setupActions() {
        btnSingle.setOnClickListener {
            startActivity(Intent(this, OneImageActivity::class.java))
        }

        btnCancelOption.setOnClickListener {
            startActivity(Intent(this, CancelOptionActivity::class.java))
        }

        btnTwoCancel.setOnClickListener {
            startActivity(Intent(this, TwoImageCancelActivity::class.java))
        }
    }
}
