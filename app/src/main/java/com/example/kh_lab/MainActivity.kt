package com.example.kh_lab

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var textView3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView3 = findViewById(R.id.textView3)
    }

    fun alertMe(view: View){
        val myToast = Toast.makeText(this, "Hello, Nurbek!", Toast.LENGTH_SHORT)
        myToast.show()
    }

    fun increaseMe(view: View){
        val countString = textView3.text.toString()
        var count: Int = Integer.parseInt(countString)
        count++
        textView3.text = count.toString()

    }
    fun decreaseMe(view: View){
        val countString = textView3.text.toString()
        var count: Int = Integer.parseInt(countString)
        count--
        textView3.text = count.toString()

    }
    fun randomMe(view: View){
        val randomIntent = Intent(this, SecondActivity::class.java)
        val countString = textView3.text.toString()
        val count = Integer.parseInt(countString)
        randomIntent.putExtra(SecondActivity.TOTAL_COUNT, count)
        startActivity(randomIntent)
    }

}