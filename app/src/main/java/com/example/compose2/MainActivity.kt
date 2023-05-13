package com.example.compose2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose2.ui.theme.Compose2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose2Theme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android") Esta es otra función
                    //DirectionDetector() Otra también
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomAppBar() {
                TextButton(onClick = {navController.navigate("ScreenOne")},
                    modifier = Modifier.weight(1f)) {
                    Text(text = "One", )
                }
                TextButton(onClick = {navController.navigate("ScreenTwo")},
                    modifier = Modifier.weight(1f)) {
                    Text(text = "Two", )
                }
                TextButton(onClick = {navController.navigate("ScreenThree")},
                    modifier = Modifier.weight(1f)) {
                    Text(text = "Three", )
                }
            }
        }
    ) {
        Box(modifier = Modifier.padding(it)){
            NavHost(navController = navController, startDestination = "ScreenOne"){
                composable("ScreenOne"){ ScreenOne()}
                composable("ScreenTwo"){ ScreenTwo() }
                composable("ScreenThree"){ ScreenThree() }
            }
        }
    }
}

@Composable
fun ScreenOne() {
    Box(Modifier.fillMaxSize()){

       Text(text = "Screen One",
           style = MaterialTheme.typography.headlineLarge,
           modifier = Modifier.align(Alignment.Center))
    }
}
@Composable
fun ScreenTwo() {
    Box(Modifier.fillMaxSize()){

        Text(text = "Screen Two",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.align(Alignment.Center))
    }
}
@Composable
fun ScreenThree() {
    Box(Modifier.fillMaxSize()){

        Text(text = "Screen Three",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)) {
        ExpandableBlock(title = "Title1", body = "Body1")
        ExpandableBlock(title = "Title2", body = "Body2")
    }
}

@Composable
fun ExpandableBlock(title:String, body:String){
    var expanded by remember {
        mutableStateOf(false)
    }
    Column(){
        Row(){
            Text(text = title,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.headlineLarge)
            TextButton(onClick = { expanded = ! expanded }) {
                Text(text = "+")
            }
        }
        if (expanded){
            Row() {
                Text(text = body, style = MaterialTheme.typography.bodyLarge)
            }
        }

    }
}

@Composable
fun DirectionDetector(){
    BoxWithConstraints(
        Modifier.fillMaxSize()
    ) {
        if ( this.maxHeight > this.maxWidth){
            Text(text = "Portrait", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.align(
                Alignment.Center))
        }else{
            Text(text = "Landscape", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.align(
                Alignment.Center))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose2Theme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            //Greeting("Android") Esta es otra función
            //DirectionDetector() Otra también
            MainScreen()
        }
    }
}