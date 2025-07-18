package com.example.loginapp

import java.util.regex.Pattern

object ValidationUtils {

    fun isValidEmail(email: String): Boolean {
        val emailPattern = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
        )
        return emailPattern.matcher(email).matches()
    }

    fun isValidPassword(password: String): Boolean {
        return password.length >= 8 &&
                password.any { it.isUpperCase() } &&
                password.any { it.isLowerCase() } &&
                password.any { it.isDigit() } &&
                password.any { "!@#$%^&*()_+-=[]{}|;:,.<>?".contains(it) }
    }

    fun isValidName(name: String): Boolean {
        return name.isNotBlank() && name.length >= 2
    }

    fun getPasswordErrorMessage(password: String): String {
        return when {
            password.length < 8 -> "La contraseña debe tener al menos 8 caracteres"
            !password.any { it.isUpperCase() } -> "Debe contener al menos una mayúscula"
            !password.any { it.isLowerCase() } -> "Debe contener al menos una minúscula"
            !password.any { it.isDigit() } -> "Debe contener al menos un número"
            !password.any { "!@#$%^&*()_+-=[]{}|;:,.<>?".contains(it) } -> "Debe contener al menos un caracter especial"
            else -> ""
        }
    }

    fun getEmailErrorMessage(email: String): String {
        return when {
            email.isBlank() -> "El email es requerido"
            !isValidEmail(email) -> "Formato de email inválido"
            else -> ""
        }
    }

    fun getNameErrorMessage(name: String): String {
        return when {
            name.isBlank() -> "El nombre es requerido"
            name.length < 2 -> "El nombre debe tener al menos 2 caracteres"
            else -> ""
        }
    }
}