package com.livin.android.bookstore

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
/*import android.text.InputType.TYPE_CLASS_TEXT
import android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
import android.view.Gravity
import android.widget.EditText
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick*/
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

        /*verticalLayout {
            gravity = Gravity.CENTER
            padding = dip(16)
            val usernameET = editText {
                hintResource = R.string.username
                gravity = Gravity.CENTER
            }
            val passwordET = editText {
                hintResource = R.string.password
                inputType = TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PASSWORD
                gravity = Gravity.CENTER
            }
            button("Login") {
                onClick {
                    valuate(usernameET, passwordET)
                }
            }
        }*/

        if (prefs.loginStatus) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        loginButton.setOnClickListener { valuate() }

    }

    private fun valuate(/*usernameET: EditText, passwordET: EditText*/) {
        if (usernameET.text.toString() == username && passwordET.text.toString() == password) {
            startActivity(Intent(this, MainActivity::class.java))
            prefs.loginStatus = true
            shortToast("Login Success")
            finish()
        } else {
            alert {
                setTitle("Error")
                setMessage("Hey. That's a wrong password!")
                setPositiveButton("Ok", { dialogInterface, _ -> dialogInterface.dismiss() })
            }
        }
    }

}
