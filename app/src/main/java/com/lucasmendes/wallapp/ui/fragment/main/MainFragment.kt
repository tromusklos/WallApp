package com.lucasmendes.wallapp.ui.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.lucasmendes.wallapp.R
import com.lucasmendes.wallapp.databinding.FragmentMainBinding
import com.lucasmendes.wallapp.framework.local.Carousel
import com.lucasmendes.wallapp.ui.fragment.category.CategoryFragment
import com.lucasmendes.wallapp.ui.fragment.collections.CollectionsFragment
import com.lucasmendes.wallapp.ui.fragment.popular.PopularFragment
import com.lucasmendes.wallapp.ui.pagaadapter.ViewPageAdapter

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val tabTitle = listOf("Popular", "Collections", "Categories")
    private val fragments = listOf(PopularFragment(), CategoryFragment(), CollectionsFragment())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initViewPager()
        initTabLayout()
        initCarousel()
        detail()
    }

    private fun initCarousel(){
        with(binding.carouselViewFlipper){
            setOutAnimation(activity, android.R.anim.slide_out_right)
            setup(Carousel.list)
            setLayout()
        }
    }

    private fun initToolbar() {
        with (binding.toolbar) {
            title = "Wallpapers"
            (activity as AppCompatActivity).setSupportActionBar(this)
        }
    }

    private fun initViewPager(){
        val pageAdapter = ViewPageAdapter(requireActivity(), fragments)
        binding.run {
            viewPager.adapter = pageAdapter
        }
    }

    private fun initTabLayout(){
        TabLayoutMediator(binding.tabLayout, binding.viewPager){tab, position ->
            tab.text = tabTitle[position]
        }.attach()

    }

    private fun detail(){
        binding.fab.setOnClickListener{

        }
    }

}