package com.example.challenge

import Images
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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
        val imgList = collectImages()
        loadImage(imgList[0])

        btnReview.setOnClickListener {
            val moveToReview: Intent = Intent(this, ReviewScreen::class.java)
            moveToReview.putExtra("imgList", imgList)
            startActivity(moveToReview)
        }
        btnReview.isClickable = false

        btnLike.setOnClickListener {
            imgList[counter].isLiked = true
            countRates(R.id.likeCounter)
            counter = countRates(R.id.likeDislikeCounter)
            if (counter < imgList.size) {
                loadImage(imgList[counter])
                collectImages()
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
                loadImage(imgList[counter])
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

    private fun loadImage(image: Images) {
        val img = findViewById<ImageView>(R.id.imageView)
        val imgBody = assets.open(image.name)
        val dImgBody = Drawable.createFromStream(imgBody, null)
        img.setImageDrawable(dImgBody)
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private fun collectImages(): ArrayList<Images> {
        var images: ArrayList<Images> = arrayListOf()
        val listImages = assets.list("")
        if (listImages != null) {
           for (img in listImages) {
               if ("." in img) {
                   images.add(Images(img))
               }
           }
        }
        return images
    }
}

