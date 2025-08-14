/*
 * Copyright 2025 Kazimierz Pogoda / Xemantic
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

package com.xemantic.compose.html.demo

import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        App()
    }
}

@Composable
fun App() {
    var count by remember { mutableStateOf(0) }
    
    Div({
        style {
            padding(20.px)
            fontFamily("Arial, sans-serif")
            textAlign("center")
        }
    }) {
        H1({
            style {
                color(Color.blue)
                marginBottom(20.px)
            }
        }) {
            Text("Compose HTML Demo")
        }
        
        P({
            style {
                fontSize(18.px)
                marginBottom(20.px)
            }
        }) {
            Text("Welcome to Jetpack Compose for Web!")
        }
        
        Div({
            style {
                marginBottom(10.px)
            }
        }) {
            Text("You clicked the button $count times")
        }
        
        Button({
            onClick { count++ }
            style {
                padding(10.px, 20.px)
                fontSize(16.px)
                backgroundColor(Color.lightblue)
                border(1.px, LineStyle.Solid, Color.darkblue)
                borderRadius(5.px)
                cursor("pointer")
            }
        }) {
            Text("Click me!")
        }
    }
}
