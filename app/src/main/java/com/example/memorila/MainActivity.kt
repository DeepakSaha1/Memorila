package com.example.memorila

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.example.memorila.home.HomeFragment
import com.example.memorila.signin.view.IOnClickListener
import com.example.memorila.signin.view.SignInFragment
import com.example.memorila.signin.view.SignUpFragment

class MainActivity : AppCompatActivity(), IOnClickListener {

    private lateinit var mFragmentManager: FragmentManager
    private lateinit var mSplashScreenFragment: SplashScreenFragment
    private lateinit var mSignInFragment: SignInFragment
    private lateinit var mSignUpFragment: SignUpFragment
    private lateinit var mHomeFragment: HomeFragment

    companion object {
        @JvmStatic
        private val SPLASH_TIME_OUT = 3000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragment()
        mSignInFragment.setOnClickListener(this@MainActivity)

        // adding SPLASH SCREEN fragment
        mFragmentManager = supportFragmentManager
        var mFragmentTransaction: FragmentTransaction = mFragmentManager.beginTransaction()
        mFragmentTransaction.add(R.id.fragment_placeholder, mSplashScreenFragment)
        mFragmentTransaction.commit()

        //REPLACE SPLASH SCREEN and ADD SIGN IN Fragment
        Handler().postDelayed({
            var kFragmentTransaction: FragmentTransaction = mFragmentManager.beginTransaction()
            kFragmentTransaction.replace(R.id.fragment_placeholder, mSignInFragment)
            kFragmentTransaction.commit()

        }, SPLASH_TIME_OUT)
    }

    private fun initFragment() {
        mSplashScreenFragment = SplashScreenFragment()

        mSignUpFragment = SignUpFragment()

        mSignInFragment = SignInFragment()

        mHomeFragment = HomeFragment()
    }

    // Create Account on TextView click in SignIn Fragment
    override fun onCreateAccountListener() {
        val kFragmentTransaction = mFragmentManager.beginTransaction()
        kFragmentTransaction.replace(R.id.fragment_placeholder, mSignUpFragment)
        kFragmentTransaction.addToBackStack("SignUp").commit()
    }

    //    on SignIn Btn click to open Home Fragment
    override fun onSignInClickListener() {
        val kFragmentTransaction = mFragmentManager.beginTransaction()
        kFragmentTransaction.replace(R.id.fragment_placeholder, mHomeFragment)
        kFragmentTransaction.addToBackStack("Home").commit()
    }
}
