package com.livin.android.bookstore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

/*
 * Created by Livin Mathew <mail@livinmathew.me> on 17/10/17.
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        longToast("Hello There")

    }
}
