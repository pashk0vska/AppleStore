package com.example.applestore.data.repository

import com.example.applestore.data.model.UserRole

object SessionManager {
    var currentRole: UserRole = UserRole.ADMIN
    var currentClientId: Int = -1
    var currentClientName: String = ""

    fun loginAsAdmin() {
        currentRole = UserRole.ADMIN
        currentClientId = -1
        currentClientName = ""
    }

    fun loginAsClient(clientId: Int, clientName: String) {
        currentRole = UserRole.CLIENT
        currentClientId = clientId
        currentClientName = clientName
    }

    fun isAdmin() = currentRole == UserRole.ADMIN
    fun isClient() = currentRole == UserRole.CLIENT
    fun logout() {
        currentRole = UserRole.ADMIN
        currentClientId = -1
        currentClientName = ""
    }
}