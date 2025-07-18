package com.example.loginapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
        setupObservers()
    }

    private fun setupUI() {
        binding.apply {
            etName.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    viewModel.setName(s.toString())
                }
            })

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

            etConfirmPassword.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    viewModel.setConfirmPassword(s.toString())
                }
            })

            btnRegister.setOnClickListener {
                viewModel.register()
            }

            tvLogin.setOnClickListener {
                finish()
            }
        }
    }

    private fun setupObservers() {
        viewModel.nameError.observe(this) { error ->
            binding.tilName.error = if (error.isNotBlank()) error else null
        }

        viewModel.emailError.observe(this) { error ->
            binding.tilEmail.error = if (error.isNotBlank()) error else null
        }

        viewModel.passwordError.observe(this) { error ->
            binding.tilPassword.error = if (error.isNotBlank()) error else null
        }

        viewModel.confirmPasswordError.observe(this) { error ->
            binding.tilConfirmPassword.error = if (error.isNotBlank()) error else null
        }

        viewModel.isFormValid.observe(this) { isValid ->
            binding.btnRegister.isEnabled = isValid
            binding.btnRegister.alpha = if (isValid) 1.0f else 0.5f
        }

        viewModel.registerResult.observe(this) { result ->
            when (result) {
                is RegisterViewModel.RegisterResult.Success -> {
                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                    finish()
                }
                is RegisterViewModel.RegisterResult.Error -> {
                    Toast.makeText(this, result.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}