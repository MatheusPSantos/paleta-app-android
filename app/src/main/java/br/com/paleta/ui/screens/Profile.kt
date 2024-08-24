@file:OptIn(ExperimentalMaterial3Api::class)

package br.com.paleta.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Meu Perfil") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Voltar")
                    }
                }
            )

        }) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
//            Text(
//                text = "Meu Perfil",
//                style = MaterialTheme.typography.titleMedium,
//                modifier = Modifier
//                    .padding(bottom = 24.dp)
//                    .align(alignment = Alignment.CenterHorizontally)
//            )
            // Container da foto de perfil e botão de editar
            Box(modifier = Modifier.padding(top = 16.dp)) {
                // Foto de perfil (mocked)
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .background(color = Color.Gray, shape = CircleShape)
                        .align(Alignment.Center)
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Foto do usuário",
                        modifier = Modifier
                            .padding(bottom = 18.dp)
                            .size(100.dp)
                            .align(Alignment.Center),
                        tint = Color.White
                    )
                }

            }

            Spacer(modifier = Modifier.height(24.dp))

            // Nome do usuário
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 24.dp)
            ) {
                Text(
                    text = "Nome do Usuário",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(end = 8.dp)
                )
            }

            Divider()

            // Opções do perfil
            ProfileOption("Configurações") {
                navController.navigate("configuracoes")
            }
            ProfileOption("Privacidade") {
                navController.navigate("privacidade")
            }
            ProfileOption("Ajuda") {}
            ProfileOption("Sobre") {}
            ProfileOption("Sair") {}
        }
    }
}

@Composable
fun ProfileOption(optionText: String, onClick: () -> Unit) {
    TextButton(onClick = onClick, modifier = Modifier.fillMaxWidth()) {
        var opcaoCor: Color
        if (!optionText.equals("Sair")) {
            opcaoCor = Color.Black
        } else {
            opcaoCor = Color.Red
        }

        Text(
            text = optionText,
            fontSize = 18.sp,
            color = opcaoCor,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
    Divider(color = Color.Gray, thickness = 0.5.dp)
}

@Preview
@Composable
fun ProfileScreenPreview() {
    val mockNavController = rememberNavController()
    ProfileScreen(navController = mockNavController)
}