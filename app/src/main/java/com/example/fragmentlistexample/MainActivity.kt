package com.example.fragmentlistexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import com.example.fragmentlistexample.ui.theme.FragmentListExampleTheme

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FragmentListExampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Text("With AndroidView:")
                        Pages(modifier = Modifier.weight(1f)) {
                            FragmentWrapper(text = it)
                        }
                        Text("With AndroidViewBinding:")
                        Pages(modifier = Modifier.weight(1f)) {
                            LayoutFragmentWrapper(text = it)
                        }
                    }
                }
            }
        }
    }
}
