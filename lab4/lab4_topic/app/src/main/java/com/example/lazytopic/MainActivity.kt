package com.example.lazytopic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazytopic.data.DataSource
import com.example.lazytopic.model.Topic
import com.example.lazytopic.ui.theme.LazyTopicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyTopicTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TopicApp(
                        DataSource.topics,
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}


@Composable
fun TopicApp(topicList: List<Topic>, modifier: Modifier = Modifier) {
    Surface(modifier = modifier) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(topicList.size) { index ->
                TopicCard(topicList[index])
            }
        }
    }
}


@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier){
    Card(modifier) {
        Row {
            Image(
                painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(topic.stringResourceId),
                modifier = Modifier
                    .width(68.dp)
                    .height(68.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.padding(top = 16.dp, end = 16.dp)
            ){
                Text(
                    text = stringResource(topic.stringResourceId),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(start = 16.dp)
                )

                Row(modifier = Modifier.padding(top = 8.dp)){
                    Icon(
                        painter = painterResource(R.drawable.dots),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .size(14.dp)
                    )

                    Text(
                        text = topic.number.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LazyTopicTheme {
        TopicApp(
            DataSource.topics,
            modifier = Modifier.padding(8.dp)
        )
        
    }
}