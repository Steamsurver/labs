package com.example.myinformation

import android.icu.text.IDNA
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myinformation.ui.theme.MyInformationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyInformationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Information(
                        modifier = Modifier.padding(innerPadding).fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun Information(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        val profileImage = painterResource(R.drawable.user);
        val phoneImage = painterResource(R.drawable.telephone);
        val socialImage = painterResource(R.drawable.telegram);
        val mailImage = painterResource(R.drawable.mail);
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(3f)
       ){
            Image(
                painter = profileImage,
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )
            Text(
                text = stringResource(R.string.user_name),
                fontSize = 30.sp
            )
            Text(
                text = stringResource(R.string.title),
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.weight(1f))
        Column(
            modifier = Modifier.padding(start = 25.dp, end = 25.dp)
                .weight(1f)
        ){
            Row(){
                Image(
                    painter = phoneImage,
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )

                Text(
                    text = stringResource(R.string.user_phone),
                    fontSize = 20.sp
                )
            }
            Row(){
                Image(
                    painter = socialImage,
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )

                Text(
                    text = stringResource(R.string.user_social_media),
                    fontSize = 20.sp
                )
            }
            Row(){
                Image(
                    painter = mailImage,
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )

                Text(
                    text = stringResource(R.string.user_mail),
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyInformationTheme {
        Information()
    }
}