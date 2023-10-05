package com.lucasmendes.wallapp.ui.fragment.collections

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasmendes.wallapp.R
import com.lucasmendes.wallapp.databinding.FragmentCollectionsBinding
import com.lucasmendes.wallapp.databinding.FragmentPopularBinding

class CollectionsFragment : Fragment() {
    private lateinit var binding: FragmentCollectionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCollectionsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}