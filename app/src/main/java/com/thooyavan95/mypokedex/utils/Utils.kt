package com.thooyavan95.mypokedex.utils

import com.squareup.picasso.Picasso

object Utils {

    fun getImageLoader() = Picasso.get()

    fun getIndex(url : String) = url.split("/").dropLast(1).last()

}