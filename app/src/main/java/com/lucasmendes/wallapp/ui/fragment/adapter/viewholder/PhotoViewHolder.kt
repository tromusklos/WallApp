package com.lucasmendes.wallapp.ui.fragment.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.RecyclerView
import com.lucasmendes.core.domain.model.PhotoDomain
import com.lucasmendes.wallapp.databinding.FragmentPopularBinding
import com.lucasmendes.wallapp.databinding.ItemPhotoBinding
import com.lucasmendes.wallapp.extentions.loadBlurredImageWithPlaceholder

class PhotoViewHolder(
    itemBinding: ItemPhotoBinding,
    private val clickCallback: (photo: PhotoDomain) -> Unit
): RecyclerView.ViewHolder(itemBinding.root) {

    private val image = itemBinding.image
    private val name = itemBinding.name


    fun bind(photo: PhotoDomain) {
        image.loadBlurredImageWithPlaceholder(
            imageUrl = photo.srcDomain?.original,
            placeholderColor = photo.avgColor
        )

        name.text = photo.photographer
        itemView.setOnClickListener{
            clickCallback.invoke(photo)
        }
    }

    companion object {
        fun create(parent: ViewGroup, photoCallback: (photo: PhotoDomain) -> Unit): PhotoViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemBinding = ItemPhotoBinding.inflate(inflater, parent, false)
            return PhotoViewHolder(itemBinding, photoCallback )
        }
    }
}