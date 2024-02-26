package com.systemfailed.wsroom.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.systemfailed.wsroom.AccessControl


@Composable
fun MyNavigation(navController: NavHostController = rememberNavController()) {

    NavHost(navController = navController, startDestination = "AccessControl") {
        composable("AccessControl") {
            AccessControl(navController = navController)
        }
        composable("Home") {
            Home(navController = navController)
        }
        composable("Add") {
            Add()
        }
    }

}

@Composable
fun Home(navController: NavHostController) {
    Scaffold(topBar = {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp), text = "Registro de Usuarios", textAlign = TextAlign.Center
        )
    }, floatingActionButton = {
        FloatingActionButton(onClick = {
            navController.navigate("Add")
        }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = null)
        }
    }) {
        it
        Content()
    }
}

@Composable
fun Content() {

}