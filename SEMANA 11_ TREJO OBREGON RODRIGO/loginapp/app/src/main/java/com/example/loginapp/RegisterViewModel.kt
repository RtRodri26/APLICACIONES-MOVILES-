package com.example.loginapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {

    private val userRepository = UserRepository.getInstance()

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _confirmPassword = MutableLiveData<String>()
    val confirmPassword: LiveData<String> = _confirmPassword

    private val _nameError = MutableLiveData<String>()
    val nameError: LiveData<String> = _nameError

    private val _emailError = MutableLiveData<String>()
    val emailError: LiveData<String> = _emailError

    private val _passwordError = MutableLiveData<String>()
    val passwordError: LiveData<String> = _passwordError

    private val _confirmPasswordError = MutableLiveData<String>()
    val confirmPasswordError: LiveData<String> = _confirmPasswordError

    private val _isFormValid = MutableLiveData<Boolean>()
    val isFormValid: LiveData<Boolean> = _isFormValid

    private val _registerResult = MutableLiveData<RegisterResult>()
    val registerResult: LiveData<RegisterResult> = _registerResult

    fun setName(name: String) {
        _name.value = name
        validateName(name)
        updateFormValidation()
    }

    fun setEmail(email: String) {
        _email.value = email
        validateEmail(email)
        updateFormValidation()
    }

    fun setPassword(password: String) {
        _password.value = password
        validatePassword(password)
        validateConfirmPassword(_confirmPassword.value ?: "")
        updateFormValidation()
    }

    fun setConfirmPassword(confirmPassword: String) {
        _confirmPassword.value = confirmPassword
        validateConfirmPassword(confirmPassword)
        updateFormValidation()
    }

    private fun validateName(name: String) {
        _nameError.value = ValidationUtils.getNameErrorMessage(name)
    }

    private fun validateEmail(email: String) {
        _emailError.value = ValidationUtils.getEmailErrorMessage(email)
    }

    private fun validatePassword(password: String) {
        _passwordError.value = ValidationUtils.getPasswordErrorMessage(password)
    }

    private fun validateConfirmPassword(confirmPassword: String) {
        val password = _password.value ?: ""
        _confirmPasswordError.value = when {
            confirmPassword.isBlank() -> "Confirme la contraseña"
            confirmPassword != password -> "Las contraseñas no coinciden"
            else -> ""
        }
    }

    private fun updateFormValidation() {
        val nameValid = ValidationUtils.isValidName(_name.value ?: "")
        val emailValid = ValidationUtils.isValidEmail(_email.value ?: "")
        val passwordValid = ValidationUtils.isValidPassword(_password.value ?: "")
        val confirmPasswordValid = _password.value == _confirmPassword.value &&
                (_confirmPassword.value ?: "").isNotBlank()

        _isFormValid.value = nameValid && emailValid && passwordValid && confirmPasswordValid
    }

    fun register() {
        val name = _name.value ?: return
        val email = _email.value ?: return
        val password = _password.value ?: return

        if (userRepository.userExists(email)) {
            _registerResult.value = RegisterResult.Error("El usuario ya existe")
            return
        }

        val user = User(email, password, name)
        val success = userRepository.registerUser(user)

        if (success) {
            _registerResult.value = RegisterResult.Success
        } else {
            _registerResult.value = RegisterResult.Error("Error al registrar usuario")
        }
    }

    sealed class RegisterResult {
        object Success : RegisterResult()
        data class Error(val message: String) : RegisterResult()
    }
}