package br.com.paleta.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Pontuacao(
    val nomeCartao: String,
    val valorPontuacao: String,
    val dataHora: String
)

@Composable
fun PointsHistory(points: List<Pontuacao>, padding: PaddingValues) {
    LazyColumn(
        modifier = Modifier.padding(padding),
        contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(9.dp)
    ) {
        items(points) { point ->
            HistoryItem(point = point)
        }
    }
}

@Composable
fun HistoryItem(point: Pontuacao) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = point.nomeCartao,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(3.dp))

            Text(
                text = "Pontuação: ${point.valorPontuacao}",
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(3.dp))

            Text(
                text = point.dataHora,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}
