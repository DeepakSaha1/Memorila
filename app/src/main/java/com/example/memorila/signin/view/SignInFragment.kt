package com.example.memorila.signin.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.memorila.R
import kotlinx.android.synthetic.main.fragment_sign_in.*

class SignInFragment : Fragment() {

    private lateinit var mIOnClickListener: IOnClickListener

    fun setOnClickListener(iIOnClickListener: IOnClickListener) {
        this.mIOnClickListener = iIOnClickListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_link_signup.setOnClickListener {
            mIOnClickListener.onCreateAccountListener()
        }

        btn_login.setOnClickListener{
            mIOnClickListener.onSignInClickListener()
        }
    }


}
