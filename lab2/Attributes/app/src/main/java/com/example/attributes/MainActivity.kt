package com.example.attributes

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.attributes.ui.theme.AttributesTheme
import android.graphics.Color
import android.util.TypedValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.editText)
        val buttonTextColorBlack: Button = findViewById(R.id.button_black_text)
        val buttonTextColorRed: Button = findViewById(R.id.button_red_text)
        val buttonTextSize8SP: Button = findViewById(R.id.button_8sp_size)
        val buttonTextSize24SP: Button = findViewById(R.id.button_24sp_size)
        val buttonTextBackgroundWhite: Button = findViewById(R.id.button_white_background)
        val buttonTextBackgroundYellow: Button = findViewById(R.id.button_yellow_background)

        buttonTextColorBlack.setOnClickListener {
            editText.setTextColor(Color.BLACK)
        }

        buttonTextColorRed.setOnClickListener {
            editText.setTextColor(Color.RED)
        }

        buttonTextSize8SP.setOnClickListener {
            editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 8f)
        }

        buttonTextSize24SP.setOnClickListener {
            editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f)
        }

        buttonTextBackgroundWhite.setOnClickListener {
            editText.setBackgroundColor(Color.WHITE)
        }

        buttonTextBackgroundYellow.setOnClickListener {
            editText.setBackgroundColor(Color.YELLOW)
        }
    }
}
