package com.example.challenge

import Images
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import androidx.core.view.marginRight
import androidx.core.view.setPadding
import androidx.fragment.app.Fragment

class GridView : Fragment(R.layout.fragment_gridview) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainLayout = view.findViewById<GridLayout>(R.id.gridLayout)
        val imgList = arguments?.get("imgList") as ArrayList<Images>
        for (image in imgList)  {
            val (imageView, imageViewLiked) = createImageView(image)
            mainLayout.addView(imageView)
            mainLayout.addView(imageViewLiked)
        }
    }


    private fun createImageView(image: Images): Pair<ImageView, ImageView> {
        val imageView = ImageView(activity)
        val imgBody = activity?.assets?.open(image.name)
        val dImgBody = Drawable.createFromStream(imgBody, null)
        imageView.setImageDrawable(dImgBody)
        val imageViewLiked = ImageView(activity)
        if (image.isLiked) {
            imageViewLiked.apply {
                setImageResource(android.R.drawable.star_big_on)
                setPadding(0, 0 ,50,0)
            }
        }
        imageView.setPadding(10)
        imageView.layoutParams = ViewGroup.LayoutParams(300, 300)
        return Pair(imageView, imageViewLiked)
    }

}