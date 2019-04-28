package com.example.memorila.signin.model

import android.content.Context

interface ISignUpModel {
    fun getEmailAndPassword(email: String, password: String, context: Context)
}