package io.groovin.draggesturepickupenabledissue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ComposeFoundationFlags
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.groovin.draggesturepickupenabledissue.ui.theme.DragGesturePickUpEnabledIssueTheme

class MainActivity : ComponentActivity() {
    private val itemList = listOf(
        "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10",
    )

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        //ComposeFoundationFlags.DragGesturePickUpEnabled = false
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DragGesturePickUpEnabledIssueTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var showBottomSheet by remember { mutableStateOf(false) }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        Button(
                            onClick = {
                                showBottomSheet = true
                            }
                        ) {
                            Text("BottomSheet")
                        }
                    }
                    if (showBottomSheet) {
                        ModalBottomSheet(
                            onDismissRequest = {
                                showBottomSheet = false
                            }
                        ) {
                            LazyColumn(
                                modifier = Modifier.fillMaxSize()
                            ) {
                                items(itemList) {
                                    Text(
                                        modifier = Modifier.fillMaxWidth().padding(8.dp),
                                        text = it,
                                        fontSize = 16.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

