package com.systemfailed.wsroom.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.systemfailed.wsroom.data.AccessControl
import com.systemfailed.wsroom.data.UIControlAccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewModelControl : ViewModel() {

    private val ui = MutableStateFlow(UIControlAccess())
    val _ui: StateFlow<UIControlAccess> = ui.asStateFlow()

    private val user = MutableStateFlow(AccessControl())
    val _user: StateFlow<AccessControl> = user.asStateFlow()

    fun changeCode(code: String) {
        ui.value = ui.value.copy(code = code)
    }

    fun statusMessage(message: Boolean) {
        ui.value = ui.value.copy(showMessage = message)
    }


    fun userData(username: String, password: String) {
        user.value = user.value.copy(username = username, password = password)
    }

    fun clearUser() {
        user.value = user.value.copy(username = "", password = "")
    }

    // login
    fun login(navController: NavController) {
        if (user.value.username == "admin" && user.value.password == "admin") {
            ui.value = ui.value.copy(showMessage = false, messageSuccess = "Bienvenido")
            navController.navigate("Home")
        } else {
            ui.value = ui.value.copy(showMessage = true, messageError = "Usuario o contraseña incorrecta")
        }
    }
}