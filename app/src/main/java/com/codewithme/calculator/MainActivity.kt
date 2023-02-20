package com.codewithme.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    lateinit var input: TextView
    lateinit var output:TextView
    lateinit var button_clear:Button
    lateinit var button_bracket: Button
    lateinit var button_bracket_r:Button
    lateinit var button_division:Button
    lateinit var button_multiply:Button
    lateinit var button_addition:Button
    lateinit var button_subtraction:Button
    lateinit var button_equals:Button
    lateinit var button_dot:Button
    lateinit var button_croxx:Button
    lateinit var button_0:Button
    lateinit var button_1:Button
    lateinit var button_2:Button
    lateinit var button_3:Button
    lateinit var button_4:Button
    lateinit var button_5:Button
    lateinit var button_6:Button
    lateinit var button_7:Button
    lateinit var button_8:Button
    lateinit var button_9:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input = findViewById(R.id.input)
        output = findViewById(R.id.output)
        button_clear = findViewById(R.id.button_clear)
        button_bracket = findViewById(R.id.button_bracket)
        button_bracket_r = findViewById(R.id.button_bracket_r)
        button_division = findViewById(R.id.button_division)
        button_multiply = findViewById(R.id.button_multiply)
        button_addition = findViewById(R.id.button_addition)
        button_subtraction = findViewById(R.id.button_subtraction)
        button_equals = findViewById(R.id.button_equals)
        button_dot = findViewById(R.id.button_dot)
        button_croxx = findViewById(R.id.button_croxx)
        button_0 = findViewById(R.id.button_0)
        button_0 = findViewById(R.id.button_0)
        button_1 = findViewById(R.id.button_1)
        button_2 = findViewById(R.id.button_2)
        button_3 = findViewById(R.id.button_3)
        button_4 = findViewById(R.id.button_4)
        button_5 = findViewById(R.id.button_5)
        button_6 = findViewById(R.id.button_6)
        button_7 = findViewById(R.id.button_7)
        button_8 = findViewById(R.id.button_8)
        button_9 = findViewById(R.id.button_9)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        button_clear.setOnClickListener {
            input.text = ""
            output.text = ""
        }

        button_bracket.setOnClickListener {

            input.text = addToInputText("(")

        }
        button_bracket_r.setOnClickListener {

            input.text = addToInputText(")")

        }

        button_croxx.setOnClickListener {
            val removedLast = input.text.toString().dropLast(1)
            input.text = removedLast
        }

        button_0.setOnClickListener {
            input.text = addToInputText("0")
        }
        button_1.setOnClickListener {
            input.text = addToInputText("1")
        }
        button_2.setOnClickListener {
            input.text = addToInputText("2")
        }
        button_3.setOnClickListener {
            input.text = addToInputText("3")
        }
        button_4.setOnClickListener {
            input.text = addToInputText("4")
        }
        button_5.setOnClickListener {
            input.text = addToInputText("5")
        }
        button_6.setOnClickListener {
            input.text = addToInputText("6")
        }
        button_7.setOnClickListener {
            input.text = addToInputText("7")
        }
        button_8.setOnClickListener {
            input.text = addToInputText("8")
        }
        button_9.setOnClickListener {
            input.text = addToInputText("9")
        }
        button_dot.setOnClickListener {
            input.text = addToInputText(".")
        }
        button_division.setOnClickListener {
            input.text = addToInputText("÷") // ALT + 0247
        }
        button_multiply.setOnClickListener {
            input.text = addToInputText("×") // ALT + 0215
        }

        button_subtraction.setOnClickListener {
            input.text = addToInputText("-")
        }
        button_addition.setOnClickListener {
            input.text = addToInputText("+")
        }

        button_equals.setOnClickListener {
            showResult()
        }
    }

    private fun addToInputText(buttonValue: String): String {

        return input.text.toString() + "" + buttonValue
    }

    private fun getInputExpression(): String {
        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                output.text = ""
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                // Show Result
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception) {
            // Show Error Message
            output.text = ""
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }
}

