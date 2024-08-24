package br.com.paleta.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FidelityCard(cardTitle: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent, shape = RoundedCornerShape(8.dp))
            .padding(12.dp)
    ) {
        // Componente Cartão menor
        Box(
            modifier = Modifier
                .size(240.dp, 130.dp)
                .background(Color(0xFF03DAC5), shape = RoundedCornerShape(8.dp))
                .align(Alignment.CenterHorizontally)
        ) {
            // Imagem ou conteúdo dentro do cartão
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Título ao lado do cartão
        Text(
            text = cardTitle,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}