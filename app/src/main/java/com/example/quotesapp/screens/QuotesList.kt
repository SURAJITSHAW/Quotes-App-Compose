package com.example.quotesapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.quotesapp.models.Quote

@Composable
fun QuotesList(
    modifier: Modifier = Modifier,
    quotes: List<Quote>,
    onQuoteClick: (quote: Quote) -> Unit
) {
    LazyColumn {
        item { quotes.forEach { quote -> QuotesListItem(quote, onQuoteClick) } }
    }
}