package com.ipochase.repositorykoinexample.data.response

data class LoginResponse(
    val ok: Boolean,
    val message: String,
    val userId: Int,
    val rol: String
) {
}