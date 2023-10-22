package com.example.kh_lab
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorActivity : AppCompatActivity() {
    private lateinit var mathOperationTextView: TextView
    private lateinit var resultTextView: TextView

    private var currentInput: StringBuilder = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        mathOperationTextView = findViewById(R.id.math_operation)
        resultTextView = findViewById(R.id.result)

        val numberButtons = listOf<Button>(
            findViewById(R.id.btn_0), findViewById(R.id.btn_1), findViewById(R.id.btn_2),
            findViewById(R.id.btn_3), findViewById(R.id.btn_4), findViewById(R.id.btn_5),
            findViewById(R.id.btn_6), findViewById(R.id.btn_7), findViewById(R.id.btn_8),
            findViewById(R.id.btn_9)
        )

        numberButtons.forEach { button ->
            button.setOnClickListener { onNumberButtonClick(button) }
        }

        // Обработчики событий для операторов
        findViewById<Button>(R.id.btn_com).setOnClickListener { onDecimalPointClick() }
        findViewById<Button>(R.id.btn_eq).setOnClickListener { onEqualsClick() }
        findViewById<Button>(R.id.btn_mns).setOnClickListener { onOperatorClick("-") }
        findViewById<Button>(R.id.btn_div).setOnClickListener { onOperatorClick("/") }
        findViewById<Button>(R.id.btn_mlp).setOnClickListener { onOperatorClick("*") }
        findViewById<Button>(R.id.btn_pls).setOnClickListener { onOperatorClick("+") }
        findViewById<Button>(R.id.btn_back).setOnClickListener { onBackspaceClick() }
    }

    private fun onNumberButtonClick(button: Button) {
        currentInput.append(button.text)
        updateMathOperationText()
    }

    private fun onDecimalPointClick() {
        if (!currentInput.contains('.')) {
            currentInput.append(".")
            updateMathOperationText()
        }
    }

    private fun onOperatorClick(operator: String) {
        if (currentInput.isNotEmpty()) {
            currentInput.append(" $operator ")
            updateMathOperationText()
        }
    }

    private fun onEqualsClick() {
        // Здесь вы можете добавить логику для вычисления результата
        // и отобразить его в resultTextView
        if (currentInput.isNotEmpty()) {
            try {
                val expression = ExpressionBuilder(currentInput.toString()).build()
                val result = expression.evaluate()
                resultTextView.text = result.toString()
            } catch (e: ArithmeticException) {
                resultTextView.text = "Ошибка"
            }
        }
    }

    private fun onBackspaceClick() {
        if (currentInput.isNotEmpty()) {
            currentInput.deleteCharAt(currentInput.length - 1)
            updateMathOperationText()
        }
    }

    private fun updateMathOperationText() {
        mathOperationTextView.text = currentInput.toString()
    }
}
