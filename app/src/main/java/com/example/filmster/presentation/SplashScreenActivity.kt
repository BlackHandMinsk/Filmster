package com.example.filmster.presentation

import android.annotation.SuppressLint
import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.findNavController
import com.example.filmster.R
import com.example.filmster.databinding.ActivitySplashScreenBinding
import dagger.hilt.android.AndroidEntryPoint


@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

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