package com.alan.storingdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var ageFromPreferences: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)

        // SharedPreferences Initialize
        sharedPreferences = this.getSharedPreferences("com.alan.storingdata",
            Context.MODE_PRIVATE)

        ageFromPreferences = sharedPreferences.getInt("age", -1)

        if (ageFromPreferences == -1) {
            textView.text = "Your Age"
        } else {
            textView.text = "Your Age: $ageFromPreferences "
        }

    }

    fun save(view: View) {

        val editText: EditText = findViewById(R.id.editTextTextPersonName)
        val textView: TextView = findViewById(R.id.textView)
        val myAge = editText.text.toString().toIntOrNull()


        if (myAge != null) {
            textView.text = "Your Age : " + myAge
            sharedPreferences.edit().putInt("age", myAge).apply()
        }

    }

    fun delete(view: View) {

        val textView: TextView = findViewById(R.id.textView)

        ageFromPreferences = sharedPreferences.getInt("age", -1)

        if (ageFromPreferences != -1) {
            sharedPreferences.edit().remove("age")
                .apply()
            textView.text = "Your Age:"
        }
    }
}