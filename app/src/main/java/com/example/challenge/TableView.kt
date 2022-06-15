package com.example.challenge

import Images
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class TableView : Fragment(R.layout.fragment_tableview) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainLayout = view.findViewById<LinearLayout>(R.id.tableLayout)


        for (i in 0..5)  {
            val image: Images = arguments?.get(i.toString()) as Images
            val subLayout = createLinearLayout(image)
            mainLayout.addView(subLayout)
        }
    }
    private fun createLinearLayout(image: Images): LinearLayout {
        val subLayout = LinearLayout(activity)
        val tvFilename = TextView(activity)
        tvFilename.text = image.id.toString()
        val textViewParam: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        textViewParam.apply {
            setMargins(0, 15, 150, 10)
        }
        tvFilename.apply {
            layoutParams = textViewParam;
            tvFilename.textSize = 20F
        }

        subLayout.addView(tvFilename)
        if (image.isLiked) {
            val tvIsLiked = TextView(activity)
            tvIsLiked.apply {
                text = "Liked!"
                textSize = 20F
                setTextColor(Color.parseColor("#F30B1E"))
            }
            tvFilename.layoutParams = textViewParam
            subLayout.addView(tvIsLiked)
        }
        return subLayout
    }



}