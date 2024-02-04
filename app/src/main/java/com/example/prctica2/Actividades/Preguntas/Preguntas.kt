package com.example.prctica2.Actividades.Preguntas
import android.content.Context
import com.example.prctica2.R
import java.io.File

class Preguntas(context: Context) {
    var listadoPreguntas = Datos(context =  context)

    fun Datos(context: Context) : ArrayList<Pregunta>{
        var listadoTemp = ArrayList<Pregunta>()

        var b= Pregunta("La Tierra es Plana", R.drawable.c_mo_estudiar_historia, false)
        var c= Pregunta("Hay dos Naranjas en la foto", R.drawable.images, false)
        var d= Pregunta("Esto es la Torre Eiffel", R.drawable.ciudades_mayas_mas_importantes, false)
        var e= Pregunta("Esto es un coche", R.drawable.elle_mejores_frutas_adelgazar_mango_1644767455, false)
        var f= Pregunta("Esto es Europa", R.drawable.mapa_politico_europa, true)
        var g= Pregunta("Esta es la bandera de México", R.drawable.historia_de_mexico_e1571100993682, true)

        listadoTemp.add(b)
        listadoTemp.add(c)
        listadoTemp.add(e)
        listadoTemp.add(f)
        listadoTemp.add(g)

        val rutaFichero = context.filesDir

        if (File(rutaFichero, "pregunta.txt").exists()) {
            val archivo = File(rutaFichero, "pregunta.txt")
            var contenido = archivo.readLines()
            for (lineas in contenido) {
                val partes = lineas.split(",")
                val pregunta = partes[0].trim()
                val respuesta = partes[1].trim()
                var respuestaBool = false
                if (respuesta == "True") {
                    respuestaBool = true
                }
                listadoTemp.add(Pregunta(Texto = pregunta, Respuesta = respuestaBool, imagen = R.drawable.fallado))
            }
        }
        


        return listadoTemp


    }

}