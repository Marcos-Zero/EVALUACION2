package cl.mmr.leviathan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaInicioUI()


        }
    }
}


data class ingredientes(
    val nombre: String,

    )


@Preview(showSystemUi = true)
@Composable
fun PantallaInicioUI(){

    var Agregar by remember { mutableStateOf("") }
    var Marcar by remember { mutableStateOf(true)

    }
    val contexto = LocalContext.current

    val ingredientes = listOf<ingredientes>(
        ingredientes("Harina"),
        ingredientes("Huevo"),
        ingredientes("Azucar"),
        ingredientes("Leche"),
        ingredientes("Vainilla"),
    )

    Text(
        text = contexto.getString(R.string.app_name),
        fontWeight = FontWeight.ExtraBold,
        fontSize = 25.sp,
        modifier = Modifier.fillMaxWidth()

    )

    Column {

        Spacer(modifier = Modifier.height(100.dp))

        TextField(value =Agregar, onValueChange = {Agregar = it} )
        Checkbox(checked = Marcar, onCheckedChange ={Marcar=it} )

        Row (
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ){
            

            Image(
                painter = painterResource(id = R.drawable.carro),
                contentDescription = "Logo"
            )


        }

        LazyColumn(
            modifier = Modifier.padding(horizontal = 25.dp, vertical = 230.dp)
        ) {
            items(ingredientes) { ingredientes ->
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(ingredientes.nombre.toString())

                             }
        }
    }





@Composable
fun AppCompras(
    navcontroller:NavHostController = rememberNavController()

) {
    NavHost(
        navController = navcontroller,
        startDestination = "inicio"


    ) {


    }
}}}