package com.example.quotesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotesapp.models.Quote


@Composable
fun QuotesListItem(quote: Quote, onQuoteClick: (quote: Quote) -> Unit) {
    Card(
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier.padding(10.dp).clickable { onQuoteClick(quote) },
        colors = androidx.compose.material3.CardDefaults.cardColors(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Quote icon with rotation
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(0xFF4B0082)  // Dark Purple (Indigo)
                    )
                    .rotate(180F), // Rotate the quote icon
                colorFilter = ColorFilter.tint(Color.White),
                imageVector = Icons.Filled.FormatQuote,
                contentDescription = null,
            )

            Spacer(modifier = Modifier.width(12.dp)) // Adjust spacer width

            Column(
                modifier = Modifier.weight(1f),
            ) {
                // Quote text
                Text(
                    fontFamily = FontFamily.Serif,
                    maxLines = 1,
                    text = quote.text,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 12.dp),
                    overflow = TextOverflow.Ellipsis
                )

                // Separator line
                Box(
                    modifier = Modifier
                        .background(Color(0xFFEEEEEE))
                        .fillMaxWidth(0.4f)
                        .height(1.dp)
                )

                // Author text
                Text(
                    fontFamily = FontFamily.Serif,
                    text = quote.author,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Thin,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}
