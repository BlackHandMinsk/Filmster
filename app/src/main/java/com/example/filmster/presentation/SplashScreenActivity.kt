package com.example.filmster.presentation

import android.annotation.SuppressLint
import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.findNavController
import com.example.filmster.R
import com.example.filmster.databinding.ActivitySplashScreenBinding
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class SplashScreenActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
            supportActionBar?.hide()
//        binding.splashScreenImg.alpha = 0f
//        binding.splashScreenImg.animate().setDuration(1500).alpha(1f).withEndAction() {
//        val i = Intent(this@SplashScreenActivity, MainActivity::class.java)
//            startActivity(i)
//            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
//            finish()
//        }

        Handler().postDelayed({
            val intent = Intent(this@SplashScreenActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
}
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = this.findNavController(R.id.NavHostFragment)
//        return navController.navigateUp()
//    }
}