package com.example.challenge

import Images
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginLeft

class TableView : Fragment(R.layout.fragment_tableview) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainLayout = view.findViewById<LinearLayout>(R.id.tablelayout)


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
        subLayout.addView(tvFilename)
        if (image.isLiked) {
            val tvIsLiked = TextView(activity)
            tvIsLiked.text = image.isLiked.toString()
            subLayout.addView(tvIsLiked)
        }
        return subLayout
    }



}