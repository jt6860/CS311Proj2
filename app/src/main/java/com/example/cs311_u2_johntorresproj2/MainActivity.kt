package com.example.cs311_u2_johntorresproj2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    // Initialize button and field variables.
    private var modBtn: Button? = null
    private var addBtn: Button? = null
    private var subtractBtn: Button? = null
    private var divideBtn: Button? = null
    private var exponentsBtn: Button? = null

    private var number1Field: EditText? = null
    private var number2Field: EditText? = null
    private var resultField: TextView? = null

    // Validity flag for number field validation.
    private var isValid = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Launch page layout.
        setContentView(R.layout.activity_main)

        // Pair button variables with layout IDs.
        modBtn = findViewById(R.id.modBtn)
        addBtn = findViewById(R.id.addBtn)
        subtractBtn = findViewById(R.id.subtractBtn)
        divideBtn = findViewById(R.id.divideBtn)
        exponentsBtn = findViewById(R.id.exponentsBtn)

        // Pair field variables with layout IDs.
        number1Field = findViewById(R.id.number1Input)
        number2Field = findViewById(R.id.number2Input)
        resultField = findViewById(R.id.resultField)

        fun castNumToDouble(numberField: EditText): Double {
            // Cast field entries to Doubles
            val numberString = numberField.text.toString()

            return numberString.toDouble()
        }

        // Mod button listener
        modBtn?.setOnClickListener {

            // Runs validation.
            isValid = validateFields()

            // If valid, perform operation.
            if (isValid) {
                val number1: Double = castNumToDouble(number1Field!!)
                val number2: Double = castNumToDouble(number2Field!!)
                val result = number1 % number2
                resultField!!.text = "$number1 % $number2 = $result"
            }
        }

        // Add button listener
        addBtn?.setOnClickListener {

            // Runs validation.
            isValid = validateFields()

            // If valid, perform operation.
            if (isValid) {
                val number1: Double = castNumToDouble(number1Field!!)
                val number2: Double = castNumToDouble(number2Field!!)
                val result = number1 + number2
                resultField!!.text = "$number1 + $number2 = $result"
            }
        }

        // Subtract button listener
        subtractBtn?.setOnClickListener {

            // Runs validation.
            isValid = validateFields()

            // If valid, perform operation.
            if (isValid) {
                val number1: Double = castNumToDouble(number1Field!!)
                val number2: Double = castNumToDouble(number2Field!!)
                val result = number1 - number2
                resultField!!.text = "$number1 - $number2 = $result"
            }
        }

        // Divide button listener
        divideBtn?.setOnClickListener {

            // Runs validation.
            isValid = validateFields()

            // If valid, perform operation.
            if (isValid) {
                val number1: Double = castNumToDouble(number1Field!!)
                val number2: Double = castNumToDouble(number2Field!!)
                val result = number1 / number2
                resultField!!.text = "$number1 / $number2 = $result"
            }
        }

        // Exponents button listener
        exponentsBtn?.setOnClickListener {

            // Runs validation.
            isValid = validateFields()

            // If valid, perform operation.
            if (isValid) {
                val number1: Double = castNumToDouble(number1Field!!)
                val number2: Double = castNumToDouble(number2Field!!)
                val result: Double = number1.pow(number2)
                resultField!!.text = "$number1 ^ $number2 = $result"
            }
        }
    }

    // Field Validation
    private fun validateFields(): Boolean {
        // Check for entries in number fields and show error if blank.
        if (number1Field!!.length() == 0) {
            number1Field!!.error = "First number is required"
            return false
        }
        if (number2Field!!.length() == 0) {
            number2Field!!.error = "Second number is required"
            return false
        }

        // If valid, return true.
        return true
    }
}