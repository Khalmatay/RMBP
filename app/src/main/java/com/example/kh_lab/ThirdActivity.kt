package com.example.kh_lab

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {
    private lateinit var myImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        myImage = findViewById(R.id.imageView1)

    }
    var count=10

    fun increaseSize(view: View) {
        if (count>0) {
            // Увеличиваем размер изображения
            myImage.layoutParams.width = myImage.width +19
            myImage.layoutParams.height = myImage.height + 27
            count--
        }
        myImage.requestLayout()
    }
    fun decreaseSize(view: View) {
        if (count<10) {
            // Увеличиваем размер изображения
            myImage.layoutParams.width = myImage.width -19
            myImage.layoutParams.height = myImage.height - 27
            count++
        }
        myImage.requestLayout()
    }

    fun backMe2(view: View){
        val randomIntent = Intent(this, SecondActivity::class.java)
        startActivity(randomIntent)
    }
    fun nextMe2(view: View){
        val randomIntent = Intent(this, CalculatorActivity::class.java)
        startActivity(randomIntent)
    }


}