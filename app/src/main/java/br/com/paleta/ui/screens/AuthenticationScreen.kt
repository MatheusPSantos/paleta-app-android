package br.com.paleta.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun AuthenticationScreen(navController: NavHostController) {
    var emailOrCpf by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Que prazer te ver por aqui!",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        OutlinedTextField(
            value = emailOrCpf,
            onValueChange = {
                emailOrCpf = it
            },
            label = { Text("Email, CPF ou Login") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Senha") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        Button(
            onClick = {
                // Lógica de autenticação
                if (isValidLogin(emailOrCpf, password)) {
                    navController.navigate("home")
                } else {
                    errorMessage = "Login ou senha inválidos."
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Entrar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = { /* Navegar para tela de cadastro */ }
        ) {
            Text("Me cadastrar")
        }

        Spacer(modifier = Modifier.height(45.dp))

        Text("Ou entre com")

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            item {

                Button(

                    modifier = Modifier.fillMaxWidth(),
                    onClick = { /* Login com Facebook */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.hsv(221f,0.61f, 0.6f))
                    ) {
                    Text(text = "Login com Facebook")
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Login com Facebook"
                    )
                }
                Button(

                    modifier = Modifier.fillMaxWidth(),
                    onClick = { /* Login com Tiktok */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.hsv(0f,0f, 0f))
                ) {
                    Text(text = "Login com Tiktok")
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Login com TikTok"
                    )
                }
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { /* Login com Gmail */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.hsv(2f, 0.92f, 0.78f))
                ) {
                    Text(text = "Login com Gmail")
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Login com Gmail"
                    )
                }
            }
        }
    }
}

// Função de validação mockada
fun isValidLogin(emailOrCpf: String, password: String): Boolean {
    // Validação simples para mock
    return emailOrCpf == "user@example.com" && password == "password"
}