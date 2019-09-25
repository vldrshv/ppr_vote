package com.example.ppr_vote.login.model

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class User (
        val userId: Int,
        val email: String,
        val password: String
)
