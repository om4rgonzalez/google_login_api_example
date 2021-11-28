package com.ipochase.repositorykoinexample.repository.auth

import com.ipochase.repositorykoinexample.data.AuthApi
import com.ipochase.repositorykoinexample.repository.base.BaseRepository

class AuthRepository(
    private val api: AuthApi
): BaseRepository() {

    suspend fun login(
        email: String,
        googleId: String,
        loginType: String
    ) = safeApiCall {
        api.login(email, googleId, loginType)
    }
}