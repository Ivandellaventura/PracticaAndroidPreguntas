package com.example.prctica2.Actividades.VistaPrimero


import com.example.prctica2.R
import android.R.*
import android.content.Context
import android.provider.Settings.Global.getString
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import com.example.prctica2.Actividades.Preguntas.Preguntas
import com.example.prctica2.Navegacion.Rutas
import kotlin.random.Random
import kotlin.random.nextInt


@Composable
fun Primero(context: Context, navController: NavController) {
    val sharedPref = LocalContext.current.getSharedPreferences(
        stringResource(id = com.example.prctica2.R.string.preference_file_key),Context.MODE_PRIVATE
    )
    var aciertos by remember { mutableStateOf(sharedPref.getInt("Aciertos", 0)) }
    var fallos by remember { mutableStateOf(sharedPref.getInt("Fallos", 0)) }

    var listaPreguntas = Preguntas().Datos()
    var Contador by remember {
        mutableStateOf(0)
    }
    var colorBien by remember {
        mutableStateOf(Color.Red)
    }

    var TextoRespuesta by remember {
        mutableStateOf("")
    }

    var Respuesta by remember {
        mutableStateOf(true)
    }
    if (Contador < 0) {
        Contador = listaPreguntas.size - 1
    }
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = listaPreguntas[Contador].Texto)
        Image(painterResource(id = listaPreguntas[Contador].imagen), contentDescription = null, Modifier.fillMaxWidth(), contentScale = ContentScale.FillWidth)
        Text(text = TextoRespuesta, modifier = Modifier, color = colorBien)
        Column(horizontalAlignment = Alignment.CenterHorizontally){

        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            //Anterior Pregunta
            Button(onClick = { Contador--
                TextoRespuesta = ""
            }, modifier = Modifier.width(200.dp)) {
                Image(painterResource(id = R.drawable.baseline_arrow_back_24 ), contentDescription = null)
                Text(text = "Anterior") }
            //Siguiente Pregunta
            Button(onClick = {
                if (Contador == listaPreguntas.size-1) {
                    Contador = 0

                }else{
                    Contador++


                }

                TextoRespuesta = ""
            }, modifier = Modifier.width(200.dp)) {
                Image(painterResource(id = R.drawable.baseline_arrow_forward_24 ), contentDescription = null)
                Text(text = "Siguiente") }

        }


            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                //Afirmar
                Button(onClick = {
                    if (listaPreguntas[Contador].Respuesta) {
                        TextoRespuesta = "Respuesta Correcta"
                        colorBien = Color.Green
                        aciertos++

                    } else {
                        TextoRespuesta = "Respuesta Errónea"
                        colorBien = Color.Red
                        fallos++

                    }

                }, modifier = Modifier.width(200.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.Green)) {
                    Text(text = "Verdadero")
                } //Negar
                Button(onClick = {
                    if (!listaPreguntas[Contador].Respuesta) {
                        TextoRespuesta = "Respuesta Correcta"
                        colorBien = Color.Green
                        aciertos++

                    } else {
                        TextoRespuesta = "Respuesta Errónea"
                        colorBien = Color.Red
                        fallos++
                    }

                }, modifier = Modifier.width(200.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.Red)) {
                    Text(text = "Falso")
                }

            }
            Button(onClick = {
                Contador = Random.nextInt(listaPreguntas.size-1)


            },modifier = Modifier.fillMaxWidth()) {
                Image(painterResource(id = R.drawable.baseline_device_unknown_24), contentDescription = null)
                Text(text = "Random")

            }
            Button(onClick = {
                aciertos = aciertos + sharedPref.getInt("Aciertos", 0)
                fallos = fallos + sharedPref.getInt("Fallos", 0)

                sharedPref.edit().putInt("Aciertos", aciertos).putInt("Fallos", fallos
                ).apply()


                navController.navigate(Rutas.PantallaMenu.ruta)}, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Volver al Menú")

            }


        }}
    }












