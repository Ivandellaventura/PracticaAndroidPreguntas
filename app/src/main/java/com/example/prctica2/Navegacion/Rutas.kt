package com.example.prctica2.Navegacion

sealed class Rutas(val ruta: String) {
    /* TODO
        Crear e identificar las rutas (diferentes pantallas) de nuestra app
     */
    object PantallaMenu: Rutas("Menu")
    object PantallaDos: Rutas("Primero")
    object PantallaTres: Rutas("Segundo")
    object PantallaCuatro: Rutas("Tres")

}