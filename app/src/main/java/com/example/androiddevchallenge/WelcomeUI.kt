package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.background

@Composable
fun Welcome(navController: NavHostController) {
    Surface(color = MaterialTheme.colors.background) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,
                painter = painterResource(id = R.drawable.ic_welcome),
                contentDescription = "welcome imge"
            )
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = "login logo",
                )
                MyButton(
                    modifier = Modifier
                        .padding(top = 32.dp), onClick = { }) {
                    Text("SIGN UP")
                }
                MyButton(
                    backgroundColor = MaterialTheme.colors.secondary,
                    modifier = Modifier
                        .padding(top = 8.dp),
                    onClick = { navController.navigate("login") }) {
                    Text("LOG IN")
                }
            }
        }
    }
}

@Preview
@Composable
fun WelcomePrivew() {
    MyTheme(false) {
        Welcome(navController = rememberNavController())
    }
}

@Preview
@Composable
fun WelcomeDarkPrivew() {

    MyTheme(true) {
        Welcome(navController = rememberNavController())
    }
}
