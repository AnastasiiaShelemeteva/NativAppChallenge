package com.example.challenge

import Images
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.GridView
import androidx.core.view.setPadding

class GridView : Fragment(R.layout.fragment_gridview) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainLayout = view.findViewById<GridLayout>(R.id.gridlayout)


        for (i in 0..5)  {
            val image: Images = arguments?.get(i.toString()) as Images
            val (imageView, imageViewHeart) = createImageView(image)
            mainLayout.addView(imageView)
            //mainLayout.addView(imageViewHeart)
        }
    }

    private fun test(): Button {
        val btn = Button(activity)
        return btn
    }
    private fun createImageView(image: Images): Pair<ImageView, ImageView> {

        val imageView = ImageView(activity)
        imageView.setImageResource(image.id)

        val imageViewHeart = ImageView(activity)
        if (image.isLiked) {
            imageViewHeart.setImageResource(R.mipmap.heartfull)
        } else {
            imageViewHeart.setImageResource(R.mipmap.heartempty)
        }
        imageView.setPadding(100)
        imageView.layoutParams.height = 300;
        imageView.layoutParams.height = 150;
        return Pair(imageView, imageViewHeart)
    }

}