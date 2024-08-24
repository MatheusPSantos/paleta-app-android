package br.com.paleta.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import br.com.paleta.ui.components.PointsHistory
import br.com.paleta.ui.components.Pontuacao

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoricoScreen(navController: NavHostController) {
    val pontuacoes = listOf(
        Pontuacao("Cartão 1", "100 pontos", "01/08/2024 10:00"),
        Pontuacao("Cartão 2", "50 pontos", "02/08/2024 12:00"),
        Pontuacao("Cartão 3", "200 pontos", "03/08/2024 14:00")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Histórico de Pontos") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Voltar")
                    }
                }
            )
        }
    ) {innerPadding ->
        PointsHistory(
            points = pontuacoes,
            padding = innerPadding
        )
    }
}