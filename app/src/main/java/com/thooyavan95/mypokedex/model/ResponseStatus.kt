package com.thooyavan95.mypokedex.model

sealed class ResponseStatus<out T : Any> {

    class Success<T : Any>(val data : T) : ResponseStatus<T>()
    class Error(val exception : Exception) : ResponseStatus<Nothing>()
}