package br.com.paleta

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.paleta.ui.components.BottomNavigationBar
import br.com.paleta.ui.screens.AddFidelityScreen
import br.com.paleta.ui.screens.AuthenticationScreen
import br.com.paleta.ui.screens.ChangePasswordScreen
import br.com.paleta.ui.screens.ConfiguracoesScreen
import br.com.paleta.ui.screens.HistoricoScreen
import br.com.paleta.ui.screens.HomeScreen
import br.com.paleta.ui.screens.MeusDadosScreen
import br.com.paleta.ui.screens.PrivacidadeScreen
import br.com.paleta.ui.screens.ProfileScreen

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("onCreate()")

        setContent {
            val navController = rememberNavController()
            val currentBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = currentBackStackEntry?.destination?.route

            Scaffold(
                bottomBar = {
                    if (currentRoute != "authentication") {
                        BottomNavigationBar(navController = navController)
                    }
                }
            ) {
                NavHost(navController = navController, startDestination = "authentication") {
                    composable("authentication") { AuthenticationScreen(navController = navController) }
                    composable("home") { HomeScreen(navController = navController) }
                    composable("addFidelity") { AddFidelityScreen(navController) }
                    composable("profile") { ProfileScreen(navController) }
                    composable("history") { HistoricoScreen(navController) }
                    composable("configuracoes") { ConfiguracoesScreen(navController) }
                    composable("privacidade") { PrivacidadeScreen(navController) }
                    composable("change_password") { ChangePasswordScreen(navController) }
                    composable("meus_dados") { MeusDadosScreen(navController) }
                }
            }
        }
    }
}
