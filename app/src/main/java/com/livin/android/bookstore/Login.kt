package com.livin.android.bookstore

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

/*
 * Created by Livin Mathew <mail@livinmathew.me> on 17/10/17.
 */

class Login : AppCompatActivity() {

    private val username = "gdgcochin"
    private val password = "devfest17"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if (prefs.loginStatus)
            startActivity(Intent(this, MainActivity::class.java))

        loginButton.setOnClickListener { valuate() }

    }

    private fun valuate() {
        if (usernameET.text.toString() == username && passwordET.text.toString() == password) {
            startActivity(Intent(this, MainActivity::class.java))
            prefs.loginStatus = true
            shortToast("Login Success")
            finish()
        }else{
            alert {
                setTitle("Error")
                setMessage("Hey. That's a wrong password!")
                setPositiveButton("Ok",{ dialogInterface, _ -> dialogInterface.dismiss() })
            }
        }
    }

}
