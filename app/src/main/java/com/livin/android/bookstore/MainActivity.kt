package com.livin.android.bookstore

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONException
import java.io.ByteArrayOutputStream
import java.io.IOException

/*
 * Created by Livin Mathew <mail@livinmathew.me> on 17/10/17.
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

class MainActivity : AppCompatActivity() {

    private lateinit var books: ArrayList<Book>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpRecyclerView()
        setUpSearch()

        longToast("Hello There")

    }

    private fun setUpSearch() {
        books = getBooks(this)
        searchView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(key: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(key: CharSequence?, p1: Int, p2: Int, p3: Int) {
                booksRecyclerView.swapAdapter(BooksArrayAdapter(this@MainActivity, books.search(key.toString())),true)
            }
        })
    }

    private fun setUpRecyclerView() {
        val booksAdapter = BooksArrayAdapter(this, null)
        booksRecyclerView.layoutManager = LinearLayoutManager(this)
        booksRecyclerView.adapter = booksAdapter
    }
}
