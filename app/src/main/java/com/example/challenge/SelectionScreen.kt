package com.example.challenge

import Images
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable
import java.util.*

class SelectionScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection_screen)
        val btnLike = findViewById<Button>(R.id.btnLike)
        val btnDislike = findViewById<Button>(R.id.btnDislike)
        val btnReview = findViewById<Button>(R.id.btnReview)

        var counter = 0
        val imgList: List<Images> = listOf(
            Images(R.mipmap.img1),
            Images(R.mipmap.img2),
            Images(R.mipmap.img3),
            Images(R.mipmap.a1),
            Images(R.mipmap.awddf),
            Images(R.mipmap.eegfg)
        )

        btnReview.setOnClickListener {
            val moveToReview: Intent = Intent(this, ReviewScreen::class.java)
            moveToReview.putExtra("imgList", imgList as Serializable)
            startActivity(moveToReview)
        }
        btnReview.isClickable = false



        btnLike.setOnClickListener {
            imgList[counter].isLiked = true
            counter = countRates(true)
            if (counter < imgList.size) {
                changeImage(imgList[counter])
            } else {
                btnReview.isClickable = true
                btnDislike.isClickable = false
                btnLike.isClickable = false
                showMessage(getString(R.string.endOfImages), this)
            }
        }

        btnDislike.setOnClickListener {
            counter = countRates(false)
            if (counter < imgList.size) {
                changeImage(imgList[counter])
            } else {
                btnReview.isClickable = true
                btnDislike.isClickable = false
                btnLike.isClickable = false
                showMessage(getString(R.string.endOfImages), this)
            }
        }
   }

    private fun countRates(isLike: Boolean): Int {
        if (isLike) {
            val likeCounterTextValue = findViewById<TextView>(R.id.likeCounter)
            var likeCount = likeCounterTextValue.text.toString().toInt()
            likeCount++
            likeCounterTextValue.text = likeCount.toString()
        }

        val counterTextValue = findViewById<TextView>(R.id.likeDislikeCounter)
        var count = counterTextValue.text.toString().toInt()
        count++
        counterTextValue.text = count.toString()
        return count
    }

    private fun changeImage(image: Images) {
        var img = findViewById<ImageView>(R.id.imageView)
        img.setImageResource(image.id)
    }

    private fun showMessage(message: String, activity: SelectionScreen) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
    }
}
