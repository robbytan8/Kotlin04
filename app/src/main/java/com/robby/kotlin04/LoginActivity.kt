package com.robby.kotlin04

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.robby.kotlin04.databinding.ActivityLoginBinding

/**
 * @author Robby Tan
 */
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            if (email == "robby.tan@it.maranatha.edu" && password == "720307") {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra(Intent.EXTRA_TEXT, email)
                startActivity(intent)
                this.finish()
            } else {
                if (email.isEmpty()) {
                    binding.etEmail.error = resources.getString(R.string.message_error_empty_email)
                }
                if (password.isEmpty()) {
                    binding.etPassword.error =
                        resources.getString(R.string.message_error_empty_password)
                }
                Snackbar.make(
                    this,
                    binding.constraintRoot,
                    resources.getString(R.string.message_error_login),
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
    }
}