package com.example.challenge

import Images
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.io.Serializable

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
            countRates(R.id.likeCounter)
            counter = countRates(R.id.likeDislikeCounter)
            if (counter < imgList.size) {
                changeImage(imgList[counter])
            } else {
                modifyBtn(btnReview, true)
                modifyBtn(btnDislike, false)
                modifyBtn(btnLike, false)
                showMessage(getString(R.string.endOfImages))
            }
        }

        btnDislike.setOnClickListener {
            counter = countRates(R.id.likeDislikeCounter)
            if (counter < imgList.size) {
                changeImage(imgList[counter])
            } else {
                modifyBtn(btnReview, true)
                modifyBtn(btnDislike, false)
                modifyBtn(btnLike, false)
                showMessage(getString(R.string.endOfImages))
            }
        }
   }

    private fun modifyBtn(btn: Button, isActive: Boolean){
        if (isActive) {
            btn.apply {
                isClickable = true
                setBackgroundColor(ContextCompat.getColor(context, R.color.blue))
                setTextColor(ContextCompat.getColor(context, R.color.white))
            }
        } else {
            btn.apply {
                isClickable = false
                setBackgroundColor(ContextCompat.getColor(context, R.color.grey))
                setTextColor(ContextCompat.getColor(context, R.color.white))
            }
        }

    }

    private fun countRates(textViewId: Int): Int {
        val counterTextView = findViewById<TextView>(textViewId)
        var count = counterTextView.text.toString().toInt()
        count++
        counterTextView.text = count.toString()
        return count
    }

    private fun changeImage(image: Images) {
        val img = findViewById<ImageView>(R.id.imageView)
        img.setImageResource(image.id)
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
