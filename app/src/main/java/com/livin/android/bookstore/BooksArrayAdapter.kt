package com.livin.android.bookstore

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

/*
 * Created by Livin Mathew <livin@acoustike.com> on 18/10/17.
 */

class BooksArrayAdapter(private var context: Context, private val books: ArrayList<Book>): RecyclerView.Adapter<BooksArrayAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        Picasso.with(context).load(books[position].cover).into(holder!!.coverImageView)
        holder.titleTextView.text = books[position].title
        holder.authorTextView.text = books[position].author
        holder.yearTextView.text = books[position].publishedYear.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        val layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return ViewHolder(layoutInflater.inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int = books.size

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val coverImageView = itemView!!.findViewById<ImageView>(R.id.bookCover)!!
        val titleTextView = itemView!!.findViewById<TextView>(R.id.titleTextView)!!
        val authorTextView = itemView!!.findViewById<TextView>(R.id.authorTextView)!!
        val yearTextView = itemView!!.findViewById<TextView>(R.id.yearTextView)!!

    }
}