package com.systemfailed.wsroom.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.systemfailed.wsroom.ui.viewmodel.ViewModelUser
import kotlinx.coroutines.launch

@Composable
fun Add() {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card {
            Column {

                val coroutineScope = rememberCoroutineScope()
                val context = LocalContext.current

                val viewModelUser: ViewModelUser = viewModel()

                val user by viewModelUser._user.collectAsState()

                TB(valor = user.name, change = {

                    viewModelUser.setUser(user.copy(name = it))

                }, tag = "Ingrese sus Nombres")

                TB(valor = user.lastName, change = {
                    viewModelUser.setUser(user.copy(lastName = it))
                }, tag = "Ingrese sus Apellidos")

                TB(valor = user.dni, change = {
                    viewModelUser.setUser(user.copy(dni = it))
                }, tag = "Ingrese sus DNI")

                TB(valor = user.username, change = {
                    viewModelUser.setUser(user.copy(username = it))
                }, tag = "Ingrese sus Username")

                TB(valor = user.password, change = {
                    viewModelUser.setUser(user.copy(password = it))
                }, tag = "Ingrese sus Password")

                Button(onClick = {
                    coroutineScope.launch {
                        viewModelUser.saveUser(user.copy())
                    }
                }) {
                    Text(text = "Guardar")
                }
            }
        }
    }
}

@Composable
fun TB(valor: String, change: (str: String) -> Unit, tag: String) {

    TextField(
        modifier = Modifier.padding(5.dp),
        value = valor,
        onValueChange = { change(it) },
        label = {
            Text("Ingrese su $tag")
        })

}