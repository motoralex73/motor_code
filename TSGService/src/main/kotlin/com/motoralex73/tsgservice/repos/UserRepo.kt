package com.motoralex73.tsgservice.repos

import com.motoralex73.tsgservice.models.User


interface UserRepo : JpaRepository <User, Long> {
    fun findByUsername(username: String): User
}