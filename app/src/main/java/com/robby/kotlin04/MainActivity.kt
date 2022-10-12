package com.robby.kotlin04

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.robby.kotlin04.databinding.ActivityMainBinding

/**
 * @author Robby Tan
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnOpenWeb.setOnClickListener {
            val website = Uri.parse("https://it.maranatha.edu")
            val intent = Intent(Intent.ACTION_VIEW, website)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
        binding.btnOpenDialer.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:08111222338"))
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val emailFromLogin = intent.getStringExtra(Intent.EXTRA_TEXT)
        binding.tvEmail.text = emailFromLogin
    }
}