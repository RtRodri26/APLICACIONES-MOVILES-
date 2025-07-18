package com.example.loginapp


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val userRepository = UserRepository.getInstance()

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _emailError = MutableLiveData<String>()
    val emailError: LiveData<String> = _emailError

    private val _passwordError = MutableLiveData<String>()
    val passwordError: LiveData<String> = _passwordError

    private val _isFormValid = MutableLiveData<Boolean>()
    val isFormValid: LiveData<Boolean> = _isFormValid

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun setEmail(email: String) {
        _email.value = email
        validateEmail(email)
        updateFormValidation()
    }

    fun setPassword(password: String) {
        _password.value = password
        validatePassword(password)
        updateFormValidation()
    }

    private fun validateEmail(email: String) {
        _emailError.value = ValidationUtils.getEmailErrorMessage(email)
    }

    private fun validatePassword(password: String) {
        _passwordError.value = if (password.isBlank()) {
            "La contraseña es requerida"
        } else {
            ""
        }
    }

    private fun updateFormValidation() {
        val emailValid = ValidationUtils.isValidEmail(_email.value ?: "")
        val passwordValid = (_password.value ?: "").isNotBlank()
        _isFormValid.value = emailValid && passwordValid
    }

    fun login() {
        val email = _email.value ?: return
        val password = _password.value ?: return

        val user = userRepository.loginUser(email, password)
        if (user != null) {
            _loginResult.value = LoginResult.Success(user.name ?: "Usuario")
        } else {
            _loginResult.value = LoginResult.Error("Credenciales incorrectas")
        }
    }

    sealed class LoginResult {
        data class Success(val userName: String) : LoginResult()
        data class Error(val message: String) : LoginResult()
    }
}