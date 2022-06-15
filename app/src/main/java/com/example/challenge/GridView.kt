package com.example.challenge

import Images
import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import android.widget.ImageView
import androidx.core.view.setPadding
import androidx.fragment.app.Fragment

class GridView : Fragment(R.layout.fragment_gridview) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainLayout = view.findViewById<GridLayout>(R.id.gridLayout)
        for (i in 0..5)  {
            val image: Images = arguments?.get(i.toString()) as Images
            val (imageView, imageViewHeart) = createImageView(image)
            mainLayout.addView(imageView)
            mainLayout.addView(imageViewHeart)
        }
    }


    private fun createImageView(image: Images): Pair<ImageView, ImageView> {
        val imageView = ImageView(activity)
        imageView.setImageResource(image.id)
        val imageViewLiked = ImageView(activity)
        if (image.isLiked) {
            imageViewLiked.setImageResource(android.R.drawable.star_big_on)
        }
        imageView.setPadding(100)
        return Pair(imageView, imageViewLiked)
    }

}