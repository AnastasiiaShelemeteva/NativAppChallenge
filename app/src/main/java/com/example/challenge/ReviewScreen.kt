package com.example.challenge

import Images
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ReviewScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_screen)


        val imgList: MutableList<Images> = intent.getSerializableExtra("imgList") as MutableList<Images>

    }
}