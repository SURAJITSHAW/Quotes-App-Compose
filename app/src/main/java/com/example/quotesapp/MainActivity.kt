package com.example.quotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.quotesapp.models.Quote
import com.example.quotesapp.screens.QuoteDetailScreen
import com.example.quotesapp.screens.QuotesListScreen
import com.example.quotesapp.ui.theme.QuotesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataManager.loadQuotesFromAssets(applicationContext)

        enableEdgeToEdge()
        setContent {
            QuotesAppTheme {
                App()
            }
        }
    }
}


@Composable
fun App(modifier: Modifier = Modifier) {
    var currentScreen by remember { mutableStateOf("Home") }  // Track the current screen
    var selectedQuote: Quote? by remember { mutableStateOf(null) }  // Store the selected quote

    // Check if quotes are loaded
    if (currentScreen == "Home") {
        if (DataManager.isLoaded) {
            QuotesListScreen(
                quotes = DataManager.quotes,
                onQuoteClick = { quote ->
                    selectedQuote = quote  // Set selected quote and navigate to the detail screen
                    currentScreen = "Detail"  // Change screen to Detail
                }
            )
        } else {
            Text(text = "Loading...")
        }
    } else {
        // Pass selected quote to the DetailScreen
        selectedQuote?.let {
            QuoteDetailScreen(quote = it,  onBackPressed = {
                // When the user presses back, return to the Home screen
                currentScreen = "Home"
            })
        }
    }
}