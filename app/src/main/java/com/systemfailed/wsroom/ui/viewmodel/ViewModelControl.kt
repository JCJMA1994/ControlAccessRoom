package com.systemfailed.wsroom.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.systemfailed.wsroom.data.UIControlAccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewModelControl : ViewModel() {

    private val ui = MutableStateFlow(UIControlAccess())
    val _ui: StateFlow<UIControlAccess> = ui.asStateFlow()

    fun changeCode(code: String) {
        ui.value = ui.value.copy(code = code)
    }

    fun statusMessage(message: Boolean) {
        ui.value = ui.value.copy(showMessage = message)
    }
}