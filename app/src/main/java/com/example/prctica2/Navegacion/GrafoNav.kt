package com.example.prctica2.Navegacion

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.prctica2.Actividades.Preguntas.PantallaSubir
import com.example.prctica2.Actividades.VistaPrimero.Primero
import com.example.prctica2.Actividades.VistaSegundo.Segundo
import com.example.prctica2.Actividades.VistaTercero.Tercero

@Composable
fun GrafoNav(context: Context){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Menu"){
    composable(Rutas.PantallaMenu.ruta){
        Menu(navController = navController)
    }
        composable(Rutas.PantallaDos.ruta){
            Primero(context = context, navController)
        }
        composable(Rutas.PantallaTres.ruta){
            Segundo(contexto = context, navController)
        }
        composable(Rutas.PantallaCuatro.ruta){
            Tercero(context = context, navController)
        }
        composable(Rutas.PantallaSubir.ruta){
            PantallaSubir(navController = navController, context = context)
        }

    }

}