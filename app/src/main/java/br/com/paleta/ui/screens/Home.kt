package br.com.paleta.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.paleta.ui.components.BottomNavigationBar
import br.com.paleta.ui.components.FidelityCard
import br.com.paleta.ui.components.MainCard
import br.com.paleta.ui.components.Pontuacao

@Composable
fun HomeScreen(navController: NavHostController) {

    val pontuacoes = listOf(
        Pontuacao("Cartão 1", "100 pontos", "01/08/2024 10:00"),
        Pontuacao("Cartão 2", "50 pontos", "02/08/2024 12:00"),
        Pontuacao("Cartão 3", "200 pontos", "03/08/2024 14:00")
    )

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .fillMaxHeight()
                .padding(horizontal = 16.dp) // Padding horizontal para espaçamento
        ) {
            Text(
                text = "Última Pontuação",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp, top = 16.dp)
            )

            MainCard(score = "85 pontos")

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Meus Cartões Fidelidade",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp), // Padding ajustado
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(39) { index ->
                    FidelityCard(cardTitle = "Cartão ${index + 1}")
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Histórico de pontos",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            //PointsHistory(points = pontuacoes)
//            Spacer(modifier = Modifier.height(1.dp))
//            Text(
//                text = "Ver histórico completo",
//                style = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.primary),
//                modifier = Modifier
//                    .align(Alignment.CenterHorizontally)
//                    .padding(vertical = 16.dp)
//                    .clickable {
//                        navController.navigate("historico_pontos")
//                    }
//
//            )
        }
    }
}
