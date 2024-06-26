package com.example.ejemplo_de_room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.ejemplo_de_room.ui.theme.Ejemplo_de_roomTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

                val room = remember {
                    Room.databaseBuilder(applicationContext, DBPruebas::class.java, "usuario").build()
                }

                var usuarios by remember { mutableStateOf(listOf<Usuario>()) }

                LaunchedEffect(Unit) {
                    lifecycleScope.launch {
                        // try {

                        // room.daoUsuario().agregarUsuario(Usuario("Kevin Sanmartin", "kev", "1234"))
                        // room.daoUsuario().agregarUsuario(Usuario("David", "el_rolo", "1040"))
                        //  room.daoUsuario().agregarUsuario(Usuario("Richard", "el_crespo", "1050"))
                        //} catch (e: Exception) {
                        //    e.printStackTrace()
                        // }

                        // Obtener información


                        var usuarios = room.daoUsuario().obtenerUsuarios()

                        for (item in usuarios) {
                            println("${item.nombre}, ${item.usuario}, ${item.contraseña}")
                        }
                        //Update
                        room.daoUsuario().actualizarUsuario("Kevin Sanmartin Acosta", "kev_sanmartin", "12345678")
                        print("se actualizaron los datos")
                        usuarios = room.daoUsuario().obtenerUsuarios()
                        for (item in usuarios){
                            println("${item.nombre}, ${item.usuario}, ${item.contraseña}")
                        }
                    }
                }

                     // Eliminar un usuario
                        // room.daoUsuario().borrarUsuario("kev")
                        // println("Usuario kev eliminado")
                    // Leer y mostrar datos después de la eliminación
                        //usuarios = room.daoUsuario().obtenerUsuarios()
                        // for (item in usuarios) {
                     //     println("${item.nombre}, ${item.usuario}, ${item.contraseña}")
                // }

                // } catch (e: Exception) {
             // e.printStackTrace()



            Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { paddingValues ->
                    LazyColumn(modifier = Modifier.padding(paddingValues)) {
                        items(usuarios) { usuario ->
                            Text(text = "${usuario.nombre}, ${usuario.usuario}, ${usuario.contraseña}")
                        }
                    }
                }
            }
        }
    }
