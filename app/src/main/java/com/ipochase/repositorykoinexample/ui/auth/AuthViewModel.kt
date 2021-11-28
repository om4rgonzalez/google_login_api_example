package com.ipochase.repositorykoinexample.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipochase.repositorykoinexample.data.Resource
import com.ipochase.repositorykoinexample.data.response.LoginResponse
import com.ipochase.repositorykoinexample.repository.auth.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel(
    private val repository: AuthRepository
): ViewModel() {

    private val _loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Resource<LoginResponse>>
    get() = _loginResponse

    fun login(
        email: String,
        googleId: String,
        loginType: String
    ) = viewModelScope.launch {
        _loginResponse.value = repository.login(email, googleId, loginType)
    }

}