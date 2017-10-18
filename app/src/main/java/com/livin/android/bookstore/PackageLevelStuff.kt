package com.livin.android.bookstore

import android.content.Context
import org.json.JSONArray
import org.json.JSONException
import java.io.ByteArrayOutputStream
import java.io.IOException

/*
 * Created by Livin Mathew <livin@acoustike.com> on 18/10/17.
 */

fun getBooks(context: Context): ArrayList<Book>{
    val books = ArrayList<Book>()
    val inputStream = context.resources.openRawResource(R.raw.books)
    val byteArrayOutputStream = ByteArrayOutputStream()
    var ctr: Int
    var i = 0
    try {
        ctr = inputStream.read()
        while (ctr != -1) {
            byteArrayOutputStream.write(ctr)
            ctr = inputStream.read()
        }
        inputStream.close()
    } catch (e: IOException) {
        e.printStackTrace()
    }
    try {
        val booksJsonArray = JSONArray(byteArrayOutputStream.toString())
        while (i < booksJsonArray.length()){
            books.add(
                    Book(
                            booksJsonArray.getJSONObject(i).getString("title"),
                            booksJsonArray.getJSONObject(i).getString("author"),
                            booksJsonArray.getJSONObject(i).getInt("year"),
                            booksJsonArray.getJSONObject(i++).getString("thumbnail")
                    )
            )
        }
    } catch (e: JSONException) {
        e.printStackTrace()
    }
    return books
}


val prefs: App.Prefs by lazy {
    App.prefs!!
}