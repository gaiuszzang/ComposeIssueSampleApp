package com.gaiuszzang.composeissuesampleapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.gaiuszzang.composeissuesampleapp.ui.theme.SampleAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SampleAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val context = LocalContext.current
                    Column(modifier = Modifier.fillMaxSize()) {
                        TextButton(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                Toast.makeText(context, "Hello!", Toast.LENGTH_SHORT).show()
                            }
                        ) {
                            Text(
                                text = "Toast Button"
                            )
                        }

                    }
                }
            }
        }
        //For Debugging code but not working
        /*
        val existingComposeView = window.decorView
            .findViewById<ViewGroup>(android.R.id.content)
            .getChildAt(0) as? ComposeView
        existingComposeView?.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnDetachedFromWindow)
        */
    }
}
