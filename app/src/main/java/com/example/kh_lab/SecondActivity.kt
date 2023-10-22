package com.example.kh_lab

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class SecondActivity : AppCompatActivity() {
    private lateinit var textViewLabel: TextView
    private lateinit var textViewRandom: TextView
    companion object{
        const val TOTAL_COUNT = "total_count"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        textViewLabel = findViewById(R.id.textViewLabel)
        textViewRandom = findViewById(R.id.textViewRandom)
        showRandomNumber()

    }
    @SuppressLint("StringFormatInvalid")
    fun showRandomNumber(){
        val count = intent.getIntExtra(TOTAL_COUNT, 0)
        val random = Random(42)
        var randomInt = 0

        if (count > 0){
            randomInt = random.nextInt(count +1)
        }
        textViewRandom.text = Integer.toString(randomInt)

        textViewLabel.text = getString(R.string.random_heading, count)

    }
    fun backMe1(view: View){
        val randomIntent = Intent(this, MainActivity::class.java)
        startActivity(randomIntent)
    }
    fun nextMe1(view: View){
        val randomIntent = Intent(this, ThirdActivity::class.java)
        startActivity(randomIntent)
    }
    fun goMultiscreen(view: View){
        val randomIntent = Intent(this, MultiscreenActivity::class.java)
        startActivity(randomIntent)
    }

}