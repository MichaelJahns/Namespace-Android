package com.michaeljahns.namespace

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }, 1500)

//       Splash Leyline Animation
//        Splash Sound Accompaniment
    }
}