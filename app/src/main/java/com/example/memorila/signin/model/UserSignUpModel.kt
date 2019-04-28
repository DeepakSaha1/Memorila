package com.example.memorila.signin.model

import android.content.Context
import android.util.Log
import com.google.firebase.auth.FirebaseAuth

class UserSignUpModel: ISignUpModel {
    var mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun getEmailAndPassword(email: String, password: String, context: Context) {
        Log.d("UserSignUpModel", "$email and $password and $context")
        createUserWithEmailAndPasswordFirebase(email, password, context)
    }

    private fun createUserWithEmailAndPasswordFirebase(email: String, password: String, context: Context) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(context) { task ->
                if (task.isSuccessful)
            }
    }


}