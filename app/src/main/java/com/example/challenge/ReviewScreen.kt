package com.example.challenge

import Images
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import java.util.ArrayList

class ReviewScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_screen)
        val imgList: MutableList<Images> = intent.getSerializableExtra("imgList") as MutableList<Images>
        val bundle = Bundle()
        for (i in imgList.indices) {
            bundle.putSerializable(i.toString(), imgList[i])
        }

        val gridFragment = GridView()
        val tableFragment = TableView()
        tableFragment.arguments = bundle
        gridFragment.arguments = bundle
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, tableFragment)
            commit()
        }

        val btnTable = findViewById<Button>(R.id.btnTable)
        btnTable.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, tableFragment)
                commit()
            }

        }


        val btnGrid = findViewById<Button>(R.id.btnGrid)
        btnGrid.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, gridFragment)
                commit()
            }
        }

    }

    private fun createCardView(): CardView {
        var cardView = CardView(this)
        cardView.layoutParams.apply {
            width = 0
            height = 0
        }
        return cardView
    }

    private fun createImageView(image: Images): ImageView {
        var imageView = ImageView(this)
        //imageView.layoutParams = LinearLayout.LayoutParams(100,100)
        imageView.setImageResource(image.id)
        return imageView
    }

}