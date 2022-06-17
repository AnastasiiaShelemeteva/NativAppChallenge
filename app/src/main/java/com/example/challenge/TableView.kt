package com.example.challenge

import Images
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.marginBottom
import androidx.fragment.app.Fragment

class TableView : Fragment(R.layout.fragment_tableview) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainLayout = view.findViewById<LinearLayout>(R.id.tableLayout)

        val imgList = arguments?.get("imgList") as ArrayList<Images>
        for (image in imgList)  {
            val subLinearLayout = createSubLinearLayout(image)
            mainLayout.addView(subLinearLayout)
        }
    }
    private fun createSubLinearLayout(image: Images): LinearLayout {
        val subLayout = LinearLayout(activity)
        val tvImageName = TextView(activity)
        val textViewParam: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        textViewParam.apply {
            0.1
        }
        tvImageName.apply {
            //layoutParams = textViewParam;
            textSize = 20F
            text = image.name.split(".")[0]
            width = 500
            layoutParams = textViewParam
        }
        subLayout.addView(tvImageName)

        if (image.isLiked) {
            val tvIsLiked = TextView(activity)
            tvIsLiked.apply {
                text = "Liked!"
                textSize = 20F
                setTextColor(Color.parseColor("#F30B1E"))
            }

            subLayout.addView(tvIsLiked)
        }
        return subLayout
    }



}