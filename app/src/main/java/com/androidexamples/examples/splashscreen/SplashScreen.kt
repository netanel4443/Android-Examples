package com.androidexamples.examples.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidexamples.examples.pixabayapi.PixabayActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent=Intent(this, PixabayActivity::class.java)
        startActivity(intent)
        finish()
    }
}