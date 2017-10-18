package com.livin.android.bookstore

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast

/*
 * Created by Livin Mathew <livin@acoustike.com> on 18/10/17.
 */

inline fun Context.alert(func: AlertDialog.Builder.() -> AlertDialog.Builder) {
    AlertDialog.Builder(this).func().show()
}

fun Context.shortToast(message: String) = Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
fun Context.longToast(message: String) = Toast.makeText(this,message,Toast.LENGTH_LONG).show()



fun ArrayList<Book>.search(key: String): ArrayList<Book>{
    val newBooks: ArrayList<Book> = ArrayList()
    return if (key.isBlank()){
        this
    }else{
        forEach {
            if (it.title.contains(key) || it.author.contains(key) || it.publishedYear.toString().contains(key))
                newBooks.add(it)
        }
        newBooks
    }
}