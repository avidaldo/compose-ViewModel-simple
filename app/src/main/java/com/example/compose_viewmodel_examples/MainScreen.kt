package com.example.compose_viewmodel_examples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlin.random.Random

class DadoViewModel : ViewModel() {
    private var _numero by mutableStateOf(0)
    val numero get() = _numero

    fun changeNumber() {
        _numero = Random.nextInt(from = 1, until = 7)
    }
}

@Composable
fun MainScreen() {
    val viewModel: DadoViewModel = viewModel()
    BotonYText(viewModel.numero, { viewModel.changeNumber() })
}

@Composable
fun BotonYText(numero: Int, changeNumber: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(35.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = changeNumber) {
            Text(text = "Tirar dado")
        }
        Text(text = numero.toString(), fontSize = 80.sp)
    }
}
