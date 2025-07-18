package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
        setupObservers()
    }

    private fun setupUI() {
        binding.apply {
            etEmail.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    viewModel.setEmail(s.toString())
                }
            })

            etPassword.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    viewModel.setPassword(s.toString())
                }
            })

            btnLogin.setOnClickListener {
                viewModel.login()
            }

            tvRegister.setOnClickListener {
                startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            }
        }
    }

    private fun setupObservers() {
        viewModel.emailError.observe(this) { error ->
            binding.tilEmail.error = if (error.isNotBlank()) error else null
        }

        viewModel.passwordError.observe(this) { error ->
            binding.tilPassword.error = if (error.isNotBlank()) error else null
        }

        viewModel.isFormValid.observe(this) { isValid ->
            binding.btnLogin.isEnabled = isValid
            binding.btnLogin.alpha = if (isValid) 1.0f else 0.5f
        }

        viewModel.loginResult.observe(this) { result ->
            when (result) {
                is LoginViewModel.LoginResult.Success -> {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("USER_NAME", result.userName)
                    startActivity(intent)
                    finish()
                }
                is LoginViewModel.LoginResult.Error -> {
                    Toast.makeText(this, result.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
