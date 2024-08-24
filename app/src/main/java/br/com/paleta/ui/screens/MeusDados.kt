package br.com.paleta.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeusDadosScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Meus Dados") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Voltar")
                    }
                }
            )
        }
    )
    { innerPadding ->


        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Meus Dados", style = MaterialTheme.typography.titleMedium)

            // Campo para o nome do usuário
            OutlinedTextField(
                value = "Nome do Usuário",
                onValueChange = { /* Atualizar o nome do usuário */ },
                label = { Text("Nome Completo") },
                modifier = Modifier.fillMaxWidth()
            )

            // Campo para o email do usuário
            OutlinedTextField(
                value = "usuario@exemplo.com",
                onValueChange = { /* Atualizar o email do usuário */ },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )

            // Campo para o telefone
            OutlinedTextField(
                value = "XX XXXXX-XXXX",
                onValueChange = { /* Atualizar o email do usuário */ },
                label = { Text("Número de celular") },
                modifier = Modifier.fillMaxWidth()
            )

            // Campo para o CPF (não editável)
            OutlinedTextField(
                value = "123.456.789-00",
                onValueChange = { /* Não permite mudanças */ },
                label = { Text("CPF") },
                modifier = Modifier.fillMaxWidth(),
                enabled = false
            )

            Button(
                onClick = { /* Salvar dados */ },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Salvar")
            }
        }
    }
}