package com.example.prctica2.Actividades.Preguntas
import com.example.prctica2.R

class Preguntas {
    var listadoPreguntas = Datos()

    fun Datos() : ArrayList<Pregunta>{
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




        return listadoTemp


    }

}