package com.example.viewpagerpoc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.viewpagerpoc.databinding.ViewPagerItemBinding


class AdViewPagerAdapter(
    private val data: ArrayList<AdModel>,
    private val clickListener: OnAdDeleteClickListener
) : PagerAdapter() {

    override fun getCount(): Int = data.size

    override fun isViewFromObject(view: View, obj: Any) = view == obj

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) =
        container.removeView(obj as View)

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val binding = ViewPagerItemBinding.inflate(inflater, container, false)
        binding.ads = data[position]
        binding.position =  position
        binding.clickListener = clickListener
        binding.executePendingBindings()
        container.addView(binding.root)
        return binding.root
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }
}