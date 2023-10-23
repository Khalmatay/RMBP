package com.example.kh_lab

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TextCheckActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private lateinit var resultmistake: TextView
    private lateinit var nameEditText: EditText
    private lateinit var educationLevelEditText: EditText
    private lateinit var courseEditText: EditText
    private lateinit var specialtyEditText: EditText
    private lateinit var checkButton: Button
    private lateinit var validationResultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_check)

        resultTextView = findViewById(R.id.resultTextView)
        nameEditText = findViewById(R.id.nameEditText)
        educationLevelEditText = findViewById(R.id.educationLevelEditText)
        courseEditText = findViewById(R.id.courseEditText)
        specialtyEditText = findViewById(R.id.specialtyEditText)
        checkButton = findViewById(R.id.checkButton)
        validationResultTextView = findViewById(R.id.validationResultTextView)

        checkButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val educationLevel = educationLevelEditText.text.toString()
            val course = courseEditText.text.toString()
            val specialty = specialtyEditText.text.toString()

            if (name.isNotBlank() && educationLevel.isNotBlank() && course.isNotBlank() && specialty.isNotBlank()) {
                resultTextView.text = "Введенные данные: \nFull name: $name\n Email: $educationLevel\n" +
                        " Course: $course\n Spezalization: $specialty"
                resultTextView.setTextAppearance(R.style.ItalicText)
                validationResultTextView.text = ""
            } else {
                validationResultTextView.text = "Один или несколько текстовых полей не заполнены"
                validationResultTextView.setTextAppearance(R.style.RedText)
                validationResultTextView.setTextAppearance(R.style.ItalicText)
                resultTextView.text = ""
            }
        }
    }

}