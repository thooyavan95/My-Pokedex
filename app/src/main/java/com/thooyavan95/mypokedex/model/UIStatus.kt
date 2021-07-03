package com.thooyavan95.mypokedex.model

sealed class UIStatus<out T : Any> {

    object Loading : UIStatus<Nothing>()
    data class Content<T : Any>(val content : T) : UIStatus<T>()
    data class Error(val exception: Exception) : UIStatus<Nothing>()
}