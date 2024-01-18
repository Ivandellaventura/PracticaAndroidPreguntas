package com.example.prctica2.Actividades.VistaSegundo

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.prctica2.Navegacion.Rutas
import com.example.prctica2.R

@Composable
fun Segundo(contexto: Context, navController: NavController){
    val sharedPref = LocalContext.current.getSharedPreferences(
        stringResource(id = R.string.preference_file_key),Context.MODE_PRIVATE
    )
    var aciertos by remember { mutableStateOf(sharedPref.getInt("Aciertos", 0)) }
    var fallos by remember { mutableStateOf(sharedPref.getInt("Fallos", 0)) }
    aciertos = sharedPref.getInt("Aciertos", 0)
    fallos = sharedPref.getInt("Fallos", 0)

    Column (verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Estadísticas", modifier = Modifier.padding(vertical = 20.dp))
        Text(text = "Aciertos = " + aciertos)
        Text(text = "Fallos = " + fallos)
        Button(onClick = {
            navController.navigate(Rutas.PantallaMenu.ruta)}, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Volver al Menú")

        }
    }
}