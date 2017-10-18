package com.livin.android.bookstore

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

/*
 * Created by Livin Mathew <livin@acoustike.com> on 18/10/17.
 */

class App: Application() {
    companion object {
        var prefs: Prefs? = null
    }

    override fun onCreate() {
        prefs = Prefs(applicationContext)
        super.onCreate()
    }

    class Prefs (context: Context) {
        private val PREFS_FILENAME = "com.gdgcochin.kotlin.bookstore.prefs"
        private val KEY_LOGIN_STATUS = "LoginStatus"
        private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)

        var loginStatus: Boolean
            get() = prefs.getBoolean(KEY_LOGIN_STATUS, false)
            set(value) = prefs.edit().putBoolean(KEY_LOGIN_STATUS, value).apply()
    }

}