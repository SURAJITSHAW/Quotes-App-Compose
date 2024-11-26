package com.example.quotesapp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotesapp.models.Quote
@Composable
fun QuotesListScreen(modifier: Modifier = Modifier, quotes: List<Quote>, onQuoteClick: (quote: Quote) -> Unit) {


    Column(
    ) {
        Text(
            fontFamily = FontFamily.Cursive,
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            text = "Quotes List",
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)) // Clip before background
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF6302AA), // Dark Purple (Start color)
                            Color(0xFF9B4DFF)  // Lighter Purple (End color)
                        )
                    )
                ) // Gradient Background
                .padding(top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding(), end = 0.dp, start = 0.dp, bottom = 0.dp) // Add status bar padding
                .padding(vertical = 16.dp, horizontal = 16.dp)
        )
        QuotesList(modifier, quotes, onQuoteClick)
    }
}
