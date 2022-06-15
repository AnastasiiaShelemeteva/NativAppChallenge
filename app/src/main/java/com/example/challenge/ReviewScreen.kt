package com.example.challenge

import Images
import android.os.Bundle
import android.text.TextUtils.replace
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
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
        switchToFragment(tableFragment)

        val btnTable = findViewById<Button>(R.id.btnTable)
        btnTable.setOnClickListener {
            switchToFragment(tableFragment)
        }

        val btnGrid = findViewById<Button>(R.id.btnGrid)
        btnGrid.setOnClickListener {
            switchToFragment(gridFragment)
        }
    }

    private fun switchToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
    }
}