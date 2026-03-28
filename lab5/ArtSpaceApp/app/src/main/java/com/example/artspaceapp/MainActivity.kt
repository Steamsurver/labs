package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.content.res.Configuration
import com.example.artspaceapp.data.PicturesData
import com.example.artspaceapp.model.Picture
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpaceApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier){
    val configuration = LocalConfiguration.current
    var isLand by remember {mutableStateOf(false)}
    isLand = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    val picList: List<Picture> = PicturesData.pictures
    var index by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.statusBarsPadding()
            .padding(horizontal = 40.dp)
            .safeDrawingPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Column(
            modifier = Modifier.weight(if(isLand) 7f else 8f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ArtImage(
                picList[index].imageResId,
                modifier = Modifier
                    .fillMaxHeight(if(isLand) 1f else 0.7f)
                    .fillMaxWidth(if(isLand) 0.7f else 1f)
            )
        }

        Column(
            modifier = Modifier.weight(if(isLand) 3f else 2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ArtDesc(
                picList[index].artTitleId,
                picList[index].authorNameId,
                modifier = Modifier
            )

            Row(
                modifier = Modifier.padding(top = 20.dp)
            ) {
                Button(
                    onClick = {
                        index--
                        when (index) {
                            picList.size -> index = 0
                            -1 -> index = picList.size - 1
                        }
                    },
                    modifier = Modifier
                        .padding(end = 15.dp)
                        .width(120.dp)
                        .height(50.dp)


                ) {
                    Text(stringResource(R.string.button_prev))
                }

                Button(
                    onClick = {
                        index++
                        when (index) {
                            picList.size -> index = 0
                            -1 -> index = picList.size - 1
                        }
                    },
                    modifier = Modifier
                        .padding(start = 15.dp)
                        .width(120.dp)
                        .height(50.dp)


                ) {
                    Text(stringResource(R.string.button_next))
                }
            }
        }
    }
}

@Composable
fun ArtImage(imageId: Int,  modifier: Modifier = Modifier){
    Image(
        painter = painterResource(imageId),
        contentDescription = null,
        modifier = modifier,
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun ArtDesc(artTitleId: Int, artistId: Int, modifier: Modifier = Modifier){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stringResource(artTitleId),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )

        Text(
            text = stringResource(artistId),
            fontSize = 20.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}