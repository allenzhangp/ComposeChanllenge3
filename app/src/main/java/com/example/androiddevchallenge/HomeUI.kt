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

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.bottomNavigationElevation
import com.example.androiddevchallenge.ui.theme.gridPadding
import com.example.androiddevchallenge.ui.theme.screenPadding
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

@Composable
fun Home(navigator: NavHostController) {
    var searchValue by remember { mutableStateOf("") }
    var scrollSate = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = screenPadding)
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 56.dp, bottom = 160.dp)
                    .verticalScroll(scrollSate)
            ) {
                TextField(
                    textStyle = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = searchValue,
                    onValueChange = { searchValue = it },
                    placeholder = { Text(text = "Search") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                )
                Text(
                    "FAVORITE COLLECTIONS",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .paddingFromBaseline(top = 40.dp)
                        .padding(bottom = gridPadding)
                )

                LazyRow(
                    contentPadding = PaddingValues(gridPadding),
                    horizontalArrangement = Arrangement.spacedBy(gridPadding)
                ) {
                    dataSource1.chunked(2) { (item1, item2) ->
                        item {
                            Column(verticalArrangement = Arrangement.spacedBy(gridPadding)) {
                                RoundedCornerItem(id = item1.id, text = item1.text)
                                RoundedCornerItem(id = item2.id, text = item2.text)
                            }
                        }
                    }
                }
                Text(
                    "ALIGN YOUR BODY",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .paddingFromBaseline(top = 40.dp)
                        .padding(bottom = gridPadding)
                )
                LazyRow(horizontalArrangement = Arrangement.spacedBy(gridPadding)) {
                    items(dataSource2) { item ->
                        CircleItem(
                            id = item.id,
                            item.text,
                        )
                    }
                }
                Text(
                    "ALIGN YOUR MIND",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .paddingFromBaseline(top = 40.dp)
                        .padding(bottom = gridPadding)
                )
                LazyRow(horizontalArrangement = Arrangement.spacedBy(gridPadding)) {
                    items(dataSource3) { item ->
                        CircleItem(
                            id = item.id,
                            item.text,
                        )
                    }
                }
            }
        }
        Box(
            Modifier
                .align(Alignment.BottomStart)
        ) {
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.background,
                elevation = bottomNavigationElevation,
                modifier = Modifier.navigationBarsPadding()
            ) {
                BottomNavigationItem(
                    selected = true,
                    onClick = { /*TODO*/ },
                    label = { Text("HOME") },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Spa,
                            contentDescription = "HOME",
                            Modifier.size(18.dp)
                        )
                    }
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = { /*TODO*/ },
                    label = { Text("PROFILE") },
                    icon = {
                        Icon(
                            modifier = Modifier.size(18.dp),
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = "PROFILE"
                        )
                    }
                )
            }
            Button(
                onClick = {},
                shape = CircleShape,
                modifier = Modifier
                    .align(Alignment.Center)
                    .requiredSize(56.dp)
                    .offset(y = -28.dp),
            ) {
                Icon(
                    imageVector = Icons.Filled.PlayArrow,
                    tint = MaterialTheme.colors.onPrimary,
                    contentDescription = null,
                    modifier = Modifier.requiredSize(24.dp)
                )
            }
        }
    }
}

@Composable
fun CircleItem(@DrawableRes id: Int, text: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Surface(shape = CircleShape, modifier = Modifier.size(88.dp)) {
            Image(
                contentScale = ContentScale.Crop,
                painter = painterResource(id = id),
                contentDescription = text
            )
        }
        Text(
            text = text,
            style = MaterialTheme.typography.h3,
            modifier = Modifier.paddingFromBaseline(top = 24.dp)
        )
    }
}

@Composable
fun RoundedCornerItem(@DrawableRes id: Int, text: String) {
    Surface(modifier = Modifier.size(192.dp, 56.dp), shape = RoundedCornerShape(4.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier.width(64.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = id),
                contentDescription = text
            )
            Text(
                text = text,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(start = gridPadding)
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun HomePreview() {
    var controller = rememberNavController()
    MyTheme {
        Home(controller)
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun HomeDarkPreview() {
    var controller = rememberNavController()
    MyTheme(true) {
        Home(controller)
    }
}

val dataSource1: List<ItemData> = listOf(
    ItemData(R.drawable.img1, "ccc"),
    ItemData(R.drawable.img2, "ccc"),
    ItemData(R.drawable.img3, "ccc"),
    ItemData(R.drawable.img3, "ccc"),
    ItemData(R.drawable.img5, "ccc"),
    ItemData(R.drawable.img6, "ccc"),
)
val dataSource2: List<ItemData> = listOf(
    ItemData(R.drawable.img7, "align body"),
    ItemData(R.drawable.img8, "ccc"),
    ItemData(R.drawable.img9, "ccc"),
    ItemData(R.drawable.img10, "ccc"),
    ItemData(R.drawable.img11, "ccc"),
    ItemData(R.drawable.img12, "ccc"),
)
val dataSource3: List<ItemData> = listOf(
    ItemData(R.drawable.img13, "ccc"),
    ItemData(R.drawable.img14, "ccc"),
    ItemData(R.drawable.img15, "ccc"),
    ItemData(R.drawable.img16, "ccc"),
    ItemData(R.drawable.img17, "ccc"),
)
