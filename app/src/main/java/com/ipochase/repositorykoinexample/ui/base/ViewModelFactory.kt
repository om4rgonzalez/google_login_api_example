package com.ipochase.repositorykoinexample.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ipochase.repositorykoinexample.repository.auth.AuthRepository
import com.ipochase.repositorykoinexample.repository.base.BaseRepository
import com.ipochase.repositorykoinexample.ui.auth.AuthViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(
    private val repository: BaseRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T
            else -> throw IllegalArgumentException("ViewModel class not found")
        }
    }
}