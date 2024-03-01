package com.systemfailed.wsroom.data

data class UIControlAccess(
    var code: String = "",
    var showMessage: Boolean = false,
    var messageError: String = "",
    var messageSuccess: String = "",
)


data class AccessControl(
    var username: String = "",
    var password: String = ""
)
