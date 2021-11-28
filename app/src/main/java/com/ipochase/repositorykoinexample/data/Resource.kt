package com.ipochase.repositorykoinexample.data

import okhttp3.ResponseBody

sealed class Resource<out T> {
    data class success<out T>(val value: T): Resource<T>()
    data class failure(
        val isNetworkError: Boolean,
        val errorCode: Int?,
        val errorBody: ResponseBody?
    ): Resource<Nothing>()
}