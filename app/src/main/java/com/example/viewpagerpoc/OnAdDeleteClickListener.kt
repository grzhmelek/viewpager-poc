package com.example.viewpagerpoc

class OnAdDeleteClickListener(val clickListener: (position: Int) -> Unit) {
    fun onClick(position: Int) = clickListener(position)
}