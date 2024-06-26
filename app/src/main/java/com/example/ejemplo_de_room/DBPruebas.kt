package com.example.ejemplo_de_room




import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ejemplo_room.DaoUsuario

@Database(
    entities = [Usuario::class],
    version = 1

)
abstract class DBPruebas: RoomDatabase(){
    abstract fun daoUsuario(): DaoUsuario
}