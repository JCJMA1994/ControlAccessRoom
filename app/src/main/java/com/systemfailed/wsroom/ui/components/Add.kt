package com.systemfailed.wsroom.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Add() {
    Column {
        Card() {
            Column {

                var nombres by remember {
                    mutableStateOf("")
                }

                var apellidos by remember {
                    mutableStateOf("")
                }

                var dni by remember {
                    mutableStateOf("")
                }

                TB(valor = nombres, change = {
                    nombres = it
                }, tag = "Ingrese sus Nombres")

                TB(valor = apellidos, change = {
                    apellidos = it
                }, tag = "Ingrese sus Nombres")

                TB(valor = dni, change = {
                    dni = it
                }, tag = "Ingrese sus Nombres")


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