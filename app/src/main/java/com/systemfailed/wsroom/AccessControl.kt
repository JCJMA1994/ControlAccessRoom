package com.systemfailed.wsroom

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.systemfailed.wsroom.ui.viewmodel.ViewModelControl

@Composable
fun AccessControl(navController: NavController) {
    val vm: ViewModelControl = viewModel()

    val ui by vm._ui.collectAsState()
    val user by vm._user.collectAsState()



    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Control de Access", fontSize = 30.sp)

        TextField(modifier = Modifier.padding(5.dp), value = user.username, onValueChange = {

            vm.userData(it, user.password)

        }, label = {
            Text("Ingrese su Username")
        })
        Spacer(modifier = Modifier.padding(5.dp))
        TextField(modifier = Modifier.padding(5.dp), value = user.password, onValueChange = {

            vm.userData(user.username, it)

        }, label = {
            Text("Ingrese su Password")
        })

        Button({
            vm.login(navController)


        }) {
            Text(text = "Ingresar")

        }
    }

    if (ui.showMessage) {
        Message(vm)
    }


}

@Composable
fun Message(ui: ViewModelControl) {

    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        confirmButton = {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Ingresar")
            }
        },
        dismissButton = {
            TextButton({
                ui.statusMessage(message = false)
            }) {
                Text("Salir")
            }
        },
        title = { Text(text = "Verificación") },
        text = { Text("Acceso Confirmado") }
    )
}