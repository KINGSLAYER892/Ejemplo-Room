package com.example.ejemplo_de_room


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Usuario(
    @PrimaryKey
    var usuario: String,
    var nombre: String? = null,
    var contraseña: String? = null
) {

    constructor() : this("", null, null)
}
