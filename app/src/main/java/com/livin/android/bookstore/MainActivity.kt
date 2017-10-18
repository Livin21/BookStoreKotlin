package com.livin.android.bookstore

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

/*
 * Created by Livin Mathew <mail@livinmathew.me> on 17/10/17.
 */

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
        /*searchView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(key: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(key: CharSequence?, p1: Int, p2: Int, p3: Int) {
                booksRecyclerView.swapAdapter(BooksArrayAdapter(this@MainActivity, books.search(key.toString())),true)
            }
        })*/
        searchView.onTextChanged { searchKey ->
            booksRecyclerView.swapAdapter(
                    BooksArrayAdapter(this@MainActivity, books.search(searchKey)), true
            )
        }
    }

    private fun setUpRecyclerView() {
        val booksAdapter = BooksArrayAdapter(this, getBooks(this))
        booksRecyclerView.layoutManager = LinearLayoutManager(this)
        booksRecyclerView.adapter = booksAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.logout -> {
                prefs.loginStatus = false
                startActivity(Intent(this@MainActivity, Login::class.java))
                finish()
            }
        }
        return true
    }

}
