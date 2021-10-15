package com.example.viewpagerpoc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewpagerpoc.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.viewModel = homeViewModel
        binding.lifecycleOwner = this

        homeViewModel.ads.observe(viewLifecycleOwner, Observer {
            binding.viewPager.adapter = AdViewPagerAdapter(it, OnAdDeleteClickListener { position ->
                homeViewModel.onAdDeleteClicked(position)
                binding.viewPager.adapter?.notifyDataSetChanged()
            })
        })

        return binding.root

    }
}