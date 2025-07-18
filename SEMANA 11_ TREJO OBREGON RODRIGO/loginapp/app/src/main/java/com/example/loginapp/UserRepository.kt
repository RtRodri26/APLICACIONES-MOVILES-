package com.example.loginapp

class UserRepository {

    private val users = mutableListOf<User>()

    fun registerUser(user: User): Boolean {
        return if (users.none { it.email == user.email }) {
            users.add(user)
            true
        } else {
            false
        }
    }

    fun loginUser(email: String, password: String): User? {
        return users.find { it.email == email && it.password == password }
    }

    fun userExists(email: String): Boolean {
        return users.any { it.email == email }
    }

    companion object {
        @Volatile
        private var INSTANCE: UserRepository? = null

        fun getInstance(): UserRepository {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: UserRepository().also { INSTANCE = it }
            }
        }
    }
}