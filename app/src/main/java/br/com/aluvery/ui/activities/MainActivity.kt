package br.com.aluvery.ui.activities

import HomeScreen
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.aluvery.dao.ProductDao
import br.com.aluvery.ui.sampledata.sampleCandies
import br.com.aluvery.ui.sampledata.sampleDrinks
import br.com.aluvery.ui.sampledata.sampleSections
import br.com.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {

    private val dao = ProductDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(onFabClick = {
                startActivity(Intent(this, ProductFormActivity::class.java))
            }){
                val sections = mapOf(
                    "Todos produtos" to dao.products(),
                    "Promoções" to sampleDrinks + sampleCandies,
                    "Doces" to sampleCandies,
                    "Bebidas" to sampleDrinks
                )
                HomeScreen(sections = sections)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(onFabClick: () -> Unit = {}, content: @Composable () -> Unit = {}) {
    AluveryTheme {
        Surface {
            Scaffold(floatingActionButton = {
                FloatingActionButton(
                    onClick = onFabClick
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
                }
            }) {
                Box(modifier = Modifier.padding(it)) {
                    content()
                }
            }
        }
    }

}

@Preview
@Composable
fun AppPreview() {
    App()
}