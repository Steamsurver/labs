package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ColorBox(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ColorBox(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Row(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.weight(1f)) {
                Column(
                    modifier = Modifier.weight(1f)
                        .background(colorResource(R.color.color1))
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        stringResource(R.string.text_composable),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    Text(stringResource(R.string.text1),
                        textAlign = TextAlign.Justify
                    )
                }

                Column(
                    modifier = Modifier.weight(1f)
                        .background(colorResource(R.color.color3))
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(stringResource(R.string.row_composable),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    Text(stringResource(R.string.text3),
                        textAlign = TextAlign.Justify
                    )
                }
            }

            Column(modifier = Modifier.weight(1f)) {
                Column(
                    modifier = Modifier.weight(1f)
                        .background(colorResource(R.color.color2))
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(stringResource(R.string.image_composable),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Text(stringResource(R.string.text2),
                        textAlign = TextAlign.Justify
                    )
                }

                Column(
                    modifier = Modifier.weight(1f)
                        .background(colorResource(R.color.color4))
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(stringResource(R.string.column_composable),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    Text(stringResource(R.string.text4),
                        textAlign = TextAlign.Justify
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ColorBoxPreview() {
    ComposeQuadrantTheme {
        ColorBox()
    }
}