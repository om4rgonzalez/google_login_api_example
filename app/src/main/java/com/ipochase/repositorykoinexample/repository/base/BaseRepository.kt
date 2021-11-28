package com.ipochase.repositorykoinexample.repository.base

import com.ipochase.repositorykoinexample.data.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ):Resource<T>{
        return withContext(Dispatchers.IO){
            try {
                Resource.success(apiCall.invoke())
            }catch (throwable: Throwable){
                when(throwable){
                    is HttpException -> {
                        Resource.failure(isNetworkError = false, throwable.code(), throwable.response()?.errorBody())
                    }
                    else ->{
                        Resource.failure(isNetworkError = true, null, null)
                    }
                }
            }
        }
    }
}