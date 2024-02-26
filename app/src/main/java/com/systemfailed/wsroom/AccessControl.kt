package com.systemfailed.wsroom

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.systemfailed.wsroom.ui.viewmodel.ViewModelControl

@Composable
fun AccessControl(navController: NavController) {
    val vm: ViewModelControl = viewModel()
    val ui by vm._ui.collectAsState()

    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Control de Acceso", fontSize = 30.sp)

        TextField(modifier = Modifier.padding(5.dp), value = ui.code, onValueChange = {

            vm.changeCode(it)

        }, label = {
            Text("Ingrese su Codigo de Usuario")
        })

        Button({
            //vm.statusMessage(true)
            navController.navigate("Start")

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

    val act = LocalContext.current as Activity

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
                //act.finish()
            }) {
                Text("Salir")
            }
        },
        title = { Text(text = "Verificación") },
        text = { Text("Acceso Confirmado") }
    )
}