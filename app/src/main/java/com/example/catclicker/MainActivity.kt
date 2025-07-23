package com.example.catclicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import com.example.catclicker.ui.theme.CatClickerTheme
import androidx.compose.ui.unit.dp
import kotlin.random.Random
import androidx.compose.foundation.layout.size
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.CircleShape

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CatClickerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var count by remember { mutableStateOf(0) }
                    val alignments = listOf(
                        Alignment.TopStart, Alignment.TopCenter, Alignment.TopEnd,
                        Alignment.CenterStart, Alignment.Center, Alignment.CenterEnd,
                        Alignment.BottomStart, Alignment.BottomCenter, Alignment.BottomEnd
                    )
                    var catAlignment by remember { mutableStateOf(Alignment.Center) }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        Text(
                            text = "Liczba kliknięć: $count",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 24.dp, bottom = 24.dp)
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxSize(),
                            contentAlignment = catAlignment
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.cat),
                                contentDescription = "Zdjęcie kota",
                                modifier = Modifier
                                    .size(120.dp)
                                    .clip(CircleShape)
                                    .clickable {
                                        count++
                                        val newAlignments = alignments.filter { it != catAlignment }
                                        catAlignment = newAlignments.random()
                                    }
                            )
                        }
                    }
                }
            }
        }
    }
}