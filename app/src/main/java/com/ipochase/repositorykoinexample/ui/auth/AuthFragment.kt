package com.ipochase.repositorykoinexample.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.ipochase.repositorykoinexample.R
import com.ipochase.repositorykoinexample.data.AuthApi
import com.ipochase.repositorykoinexample.data.Resource
import com.ipochase.repositorykoinexample.data.response.LoginResponse
import com.ipochase.repositorykoinexample.databinding.FragmentAuthBinding
import com.ipochase.repositorykoinexample.repository.auth.AuthRepository
import com.ipochase.repositorykoinexample.ui.base.BaseFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AuthFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AuthFragment : BaseFragment<AuthViewModel, FragmentAuthBinding, AuthRepository>() {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.success -> {
                    if(it.value.ok)
                        binding.txtLogin.text = "Login correcto"
                    else
                        binding.txtLogin.text = "Login incorrecto"
                }
                is Resource.failure -> {
                    binding.txtLogin.text = "Login fallo"
                }
            }
        })

        binding.googleLoginButton.setOnClickListener {
            viewModel.login("om4r.gonzalez@gmail.com", "myGoogleId", "GOOGLE")
        }
    }

    override fun getViewModel(): Class<AuthViewModel> = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAuthBinding = FragmentAuthBinding.inflate(inflater,container,false)

    override fun getFragmentRespository(): AuthRepository = AuthRepository(remoteDataSource.buildApi(AuthApi::class.java))

}