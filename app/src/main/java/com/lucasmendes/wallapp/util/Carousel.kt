package com.lucasmendes.wallapp.util

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ViewFlipper
import com.lucasmendes.core.domain.model.CarouselDomain
import com.lucasmendes.wallapp.databinding.ItemCarouselBinding
import com.lucasmendes.wallapp.extentions.loadBlurredImageWithPlaceholder

class Carousel(
    context: Context,
    attr: AttributeSet?
): ViewFlipper(context, attr) {
    private var carouselList = mutableListOf<CarouselDomain>()

    fun setup (carouselList: MutableList<CarouselDomain>) {
        this.carouselList = carouselList
    }

        fun setLayout(){
            carouselList.forEach{
                val binding = ItemCarouselBinding.inflate(LayoutInflater.from(context), this, false)
                binding.apply {
                    imgCarousel.loadBlurredImageWithPlaceholder(it.imageUrl, it.placeholderColor)
                    txtCategory.text = it.categoryName
                    addView(root)
                }

        }
    }
}