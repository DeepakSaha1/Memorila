package com.example.memorila.signin.presenter

import android.content.Context
import android.util.Log
import com.example.memorila.signin.model.ISignUpModel
import com.example.memorila.signin.model.UserSignUpModel

class SignUpPresenter : IPresenter {
    lateinit var mISignUpModel: ISignUpModel
    override fun onSignUpBtnClick(email: String, password: String, context: Context) {
        Log.d("SignUpPresenter", "$email and $password and $context")
        mISignUpModel = UserSignUpModel()
        mISignUpModel.getEmailAndPassword(email, password, context)
    }
}