/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
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
                        .padding(top = 32.dp),
                    onClick = { }
                ) {
                    Text("SIGN UP")
                }
                MyButton(
                    backgroundColor = MaterialTheme.colors.secondary,
                    modifier = Modifier
                        .padding(top = 8.dp),
                    onClick = { navController.navigate("login") }
                ) {
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
