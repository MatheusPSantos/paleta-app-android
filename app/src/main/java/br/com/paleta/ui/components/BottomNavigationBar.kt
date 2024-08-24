package br.com.paleta.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.paleta.ui.screens.AddFidelityScreen

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    BottomAppBar(
        contentPadding = PaddingValues(0.dp),
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            selected = true,
            onClick = { navController.navigate("home") },
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Início") })
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("addFidelity") },
            label = { Text("Adicionar") },
            icon = { Icon(Icons.Default.AddCircle, contentDescription = "Adicionar") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("history") },
            label = { Text("Histórico") },
            icon = { Icon(Icons.Default.List, contentDescription = "Histórico") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("profile") },
            label = { Text("Perfil") },
            icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") }
        )
    }
}