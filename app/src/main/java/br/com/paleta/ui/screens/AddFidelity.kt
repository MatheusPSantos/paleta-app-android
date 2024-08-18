package br.com.paleta.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddFidelityScreen() {
    // Variável de estado para armazenar o código inserido
    var code by remember { mutableStateOf("") }

    // Scaffold para a tela
    Scaffold(

        modifier = Modifier.fillMaxSize(),
        content = { innerPadding ->
            // Coluna centralizada
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Texto de instrução
                Text(
                    text = "Informe o código da fidelidade para se cadastrar.",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // Campo de texto para inserir o código de fidelidade
                OutlinedTextField(
                    value = code,
                    onValueChange = { newCode: String ->
                        if (newCode.matches(Regex("[A-Z0-9]{0,6}"))) {
                            code = newCode
                        }
                    },
                    label = { Text("Código de Fidelidade") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                

                // Espaço entre o campo e o botão
                Spacer(modifier = Modifier.height(24.dp))

                // Botão para cadastrar-se
                Button(
                    onClick = { /* Ação de cadastro */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Cadastrar-se")
                }
            }
        }
    )
}