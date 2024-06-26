package com.example.ejemplo_room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ejemplo_de_room.Usuario

@Dao
interface DaoUsuario {

    @Query("SELECT * FROM Usuario")
    suspend fun obtenerUsuarios(): List<Usuario>

    @Query("SELECT * FROM Usuario WHERE usuario = :usuario")
    suspend fun obtenerUsuario(usuario: String): Usuario?

    @Insert
    suspend fun agregarUsuario(usuario: Usuario)

    @Query("UPDATE Usuario SET nombre = :nombre, contraseña = :contraseña WHERE usuario = :usuario")
    suspend fun actualizarUsuario(nombre: String, usuario: String, contraseña: String)

    @Query("DELETE FROM Usuario WHERE usuario = :usuario")
    suspend fun borrarUsuario(usuario: String)
}
