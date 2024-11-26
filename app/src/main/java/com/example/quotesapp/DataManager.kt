package com.example.quotesapp

import android.content.Context
import com.example.quotesapp.models.Quote
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken // This import was missing
import java.io.BufferedReader

object DataManager {

    var quotes: List<Quote> = emptyList()
    var isLoaded = false

    fun loadQuotesFromAssets(context: Context, fileName: String = "quotes.json") {
        try {
            // Open the file from the assets folder
            val inputStream = context.assets.open(fileName)
            val bufferedReader = BufferedReader(inputStream.reader())
            val json = bufferedReader.use { it.readText() } // Read the file content

            // Parse the JSON into a list of Quote objects using Gson
            val listType = object : TypeToken<List<Quote>>() {}.type
            quotes = Gson().fromJson(json, listType)
            isLoaded = true
        } catch (e: Exception) {
            e.printStackTrace()
            quotes = emptyList() // Return an empty list if an error occurs
        }
    }
}
