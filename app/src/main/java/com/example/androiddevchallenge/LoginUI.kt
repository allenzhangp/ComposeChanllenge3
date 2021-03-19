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
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.ui.theme.gridPadding
import com.example.androiddevchallenge.ui.theme.screenPadding

@Composable
fun Login(navigator: NavHostController) {
    var email by remember { mutableStateOf("") }
    var passWord by remember { mutableStateOf("") }
    Surface(Modifier.fillMaxSize().background(color = MaterialTheme.colors.background)) {
        Box {
            Image(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.ic_login),
                contentDescription = "Login image"
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("LOG IN", style = MaterialTheme.typography.h1)
                TextField(

                    modifier = Modifier
                        .padding(top = 32.dp, start = screenPadding, end = screenPadding)
                        .height(56.dp)
                        .fillMaxWidth(),
                    value = email,
                    placeholder = {
                        Text(
                            text = "Email address",
                            style = MaterialTheme.typography.body1
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.surface,
                        unfocusedIndicatorColor = MaterialTheme.colors.onSurface
                    ),
                    onValueChange = { email = it },
                    shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
                TextField(
                    modifier = Modifier
                        .padding(top = gridPadding, start = screenPadding, end = screenPadding)
                        .height(56.dp)
                        .fillMaxWidth(),
                    value = passWord,
                    placeholder = {
                        Text(
                            text = "Password",
                            style = MaterialTheme.typography.body1
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.surface,
                        unfocusedIndicatorColor = MaterialTheme.colors.onSurface
                    ),
                    shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp),
                    onValueChange = { passWord = it },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )
                MyButton(
                    modifier = Modifier.padding(top = gridPadding),
                    onClick = { navigator.navigate("home") }
                ) {
                    Text(text = "LOG IN")
                }

//                val annotatedString =
//                    AnnotatedString.Builder("Don't have an account? Sign up")
//                        .apply {
//                            addStyle(
//                                style = SpanStyle(textDecoration = TextDecoration.Underline),
//                                23,
//                                30
//                            )
//                        }.toAnnotatedString()

                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle()) {
                            append("Don't have an account?")
                        }
                        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                            append("Sign up")
                        }
                    },
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .paddingFromBaseline(top = 32.dp, bottom = 0.dp),
                )
            }
        }
    }
}
