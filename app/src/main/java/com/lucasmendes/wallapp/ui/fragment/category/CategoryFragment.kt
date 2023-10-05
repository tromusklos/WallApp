package com.lucasmendes.wallapp.ui.fragment.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasmendes.wallapp.R
import com.lucasmendes.wallapp.databinding.FragmentCategoryBinding
import com.lucasmendes.wallapp.databinding.FragmentCollectionsBinding

class CategoryFragment : Fragment() {
    private lateinit var binding: FragmentCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}