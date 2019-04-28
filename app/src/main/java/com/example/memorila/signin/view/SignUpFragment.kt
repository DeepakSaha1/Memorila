package com.example.memorila.signin.view


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.memorila.R
import com.example.memorila.signin.presenter.IPresenter
import com.example.memorila.signin.presenter.SignUpPresenter
import kotlinx.android.synthetic.main.fragment_sign_up.*

class SignUpFragment : Fragment() {
    private lateinit var mIPresenter: IPresenter
    private lateinit var mEmail: String
    private lateinit var mPassword: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mIPresenter = SignUpPresenter()

        btn_signup.setOnClickListener {
            mEmail = et_signup_email.text.toString()
            mPassword = et_signup_password.text.toString()
            Log.d("SignUpFragment", "$mEmail and $mPassword")

            /**send email and pass to SignUpPresenter */
            mIPresenter.onSignUpBtnClick(mEmail, mPassword, requireContext())
        }
    }

}
