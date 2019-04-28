package com.example.memorila.signin.presenter

import android.content.Context

interface IPresenter {
    fun onSignUpBtnClick(email: String, password: String, context: Context)
}