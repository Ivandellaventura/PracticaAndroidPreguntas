package com.example.prctica2.Navegacion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.prctica2.Actividades.VistaPrimero.Primero

@Composable
fun Menu(navController: NavHostController){
    Column(verticalArrangement = Arrangement.SpaceEvenly , horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { navController.navigate(Rutas.PantallaCuatro.ruta) }) {
            Text(text = "Modo Exámen")

        }
        Button(onClick = { navController.navigate(Rutas.PantallaDos.ruta) }) {
            Text(text = "Modo Práctica")

        }
        Button(onClick = { navController.navigate(Rutas.PantallaTres.ruta) }) {
            Text(text = "Estadísticas")

        }

    }

}