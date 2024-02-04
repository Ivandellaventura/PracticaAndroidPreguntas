package com.example.prctica2.Actividades.VistaTercero

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.prctica2.Actividades.Preguntas.Preguntas
import com.example.prctica2.Navegacion.Rutas
import com.example.prctica2.R
import com.example.prctica2.Actividades.VistaTercero.Dialogo
import kotlin.random.Random

@Composable
fun Tercero(context: Context, navController: NavController) {


    val sharedPref = LocalContext.current.getSharedPreferences(
        stringResource(id = R.string.preference_file_key), Context.MODE_PRIVATE
    )

    var aciertos by remember { mutableStateOf(sharedPref.getInt("Aciertos", 0)) }
    var fallos by remember { mutableStateOf(sharedPref.getInt("Fallos", 0)) }

    var listaPreguntas = Preguntas(context =  context).listadoPreguntas
    var Contador by remember {
        mutableStateOf(0)
    }
    var colorBien by remember {
        mutableStateOf(Color.Red)
    }
    var cMen by remember {
        mutableStateOf(false)
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
    var Estado by remember {
        mutableStateOf(false)
    }
    var enableButtons by remember { mutableStateOf(true) }
    if (cMen){
        if(aciertos == listaPreguntas.size-1){
            Dialogo().Dialogo(
                onDismissRequest = { navController.navigate(Rutas.PantallaMenu.ruta)},
                painter = R.drawable.sobresaliente,
                imageDescription = "Imagen",
                text  = "Has sacado un sobresaliente. Enhorabuena"
            )

        }else if (aciertos >= (listaPreguntas.size-1)/2){
            Dialogo().Dialogo(
                onDismissRequest = { navController.navigate(Rutas.PantallaMenu.ruta)},
                painter = R.drawable.suficiente,
                imageDescription = "Imagen",
                text  = "Has sacado un suficiente"
            )

        }else{
            Dialogo().Dialogo(
                onDismissRequest = { navController.navigate(Rutas.PantallaMenu.ruta)},
                painter = R.drawable.fallado,
                imageDescription = "Imagen",
                text  = "Lo siento, has suspendido"
            )

        }

    }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = listaPreguntas[Contador].Texto)
        Image(
            painterResource(id = listaPreguntas[Contador].imagen),
            contentDescription = null,
            Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Text(text = TextoRespuesta, modifier = Modifier, color = colorBien)
        Column(horizontalAlignment = Alignment.CenterHorizontally) {


            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                // Afirmar
                Button(
                    onClick = {
                        if (enableButtons) {
                            if (listaPreguntas[Contador].Respuesta) {
                                TextoRespuesta = "Respuesta Correcta"
                                colorBien = Color.Green
                                aciertos++
                            } else {
                                TextoRespuesta = "Respuesta Errónea"
                                colorBien = Color.Red
                                fallos++
                            }
                            enableButtons = false
                        }
                    },
                    modifier = Modifier.width(200.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                    enabled = enableButtons
                ) {
                    Text(text = "Verdadero")
                }

                // Negar
                Button(
                    onClick = {
                        if (enableButtons) {
                            if (!listaPreguntas[Contador].Respuesta) {
                                TextoRespuesta = "Respuesta Correcta"
                                colorBien = Color.Green
                                aciertos++
                            } else {
                                TextoRespuesta = "Respuesta Errónea"
                                colorBien = Color.Red
                                fallos++
                            }
                            enableButtons = false
                        }
                    },
                    modifier = Modifier.width(200.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    enabled = enableButtons
                ) {
                    Text(text = "Falso")
                }
            }

            Button(
                onClick = {
                    if (!enableButtons) {
                        if (Contador == listaPreguntas.size - 1) {
                            cMen = true

                            





                        } else {
                            TextoRespuesta = ""
                            Contador++
                        }
                        enableButtons = true
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painterResource(id = R.drawable.baseline_arrow_forward_24),
                    contentDescription = null
                )
                Text(text = "Siguiente")
            }
        }
    }
}

