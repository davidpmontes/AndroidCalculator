package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var numberOne: String
    lateinit var numberTwo: String
    lateinit var output: TextView
    lateinit var buttonOne: Button
    lateinit var buttonThree: Button
    lateinit var buttonTwo: Button
    lateinit var buttonFour: Button
    lateinit var buttonFive: Button
    lateinit var buttonSix: Button
    lateinit var buttonSeven: Button
    lateinit var buttonEight: Button
    lateinit var buttonNine: Button
    lateinit var buttonZero: Button
    lateinit var buttonDecimal: Button
    lateinit var buttonClear: Button
    lateinit var buttonAdd: Button
    lateinit var buttonSubtract: Button
    lateinit var buttonMultiply: Button
    lateinit var buttonDivide: Button
    lateinit var buttonEquals: Button
    lateinit var buttonPosNeg: Button

    var hasDecimalOne: Boolean = false
    var hasDecimalTwo: Boolean = false
    var getNumberOne: Boolean = true
    var currSymbol = ""
    val MAX_LENGTH = 8

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignButtons()
        assignButtonListeners()
    }

    private fun assignButtons()
    {
        numberOne = "0"
        numberTwo = "0"
        output = findViewById(R.id.output)
        buttonOne = findViewById(R.id.button_1)
        buttonTwo = findViewById(R.id.button_2)
        buttonThree = findViewById(R.id.button_3)
        buttonFour = findViewById(R.id.button_4)
        buttonFive = findViewById(R.id.button_5)
        buttonSix = findViewById(R.id.button_6)
        buttonSeven = findViewById(R.id.button_7)
        buttonEight = findViewById(R.id.button_8)
        buttonNine = findViewById(R.id.button_9)
        buttonZero = findViewById(R.id.button_0)
        buttonDecimal = findViewById(R.id.button_decimal)
        buttonClear = findViewById(R.id.button_Clear)
        buttonAdd = findViewById(R.id.button_Add)
        buttonSubtract = findViewById(R.id.button_Subtract)
        buttonMultiply = findViewById(R.id.button_Multiply)
        buttonDivide = findViewById(R.id.button_Divide)
        buttonEquals = findViewById(R.id.button_equals)
        buttonPosNeg = findViewById(R.id.button_PosNeg)
    }

    private fun assignButtonListeners()
    {
        buttonOne.setOnClickListener {
            pressDigit(1)
        }

        buttonTwo.setOnClickListener {
            pressDigit(2)
        }

        buttonThree.setOnClickListener {
            pressDigit(3)
        }

        buttonFour.setOnClickListener {
            pressDigit(4)
        }

        buttonFive.setOnClickListener {
            pressDigit(5)
        }

        buttonSix.setOnClickListener {
            pressDigit(6)
        }

        buttonSeven.setOnClickListener {
            pressDigit(7)
        }

        buttonEight.setOnClickListener {
            pressDigit(8)
        }

        buttonNine.setOnClickListener {
            pressDigit(9)
        }

        buttonZero.setOnClickListener {
            pressDigit(0)
        }

        buttonDecimal.setOnClickListener {
            pressDecimal()
        }

        buttonClear.setOnClickListener {
            pressClear()
        }

        buttonAdd.setOnClickListener {
            pressSymbol("+")
        }

        buttonSubtract.setOnClickListener {
            pressSymbol("-")
        }

        buttonMultiply.setOnClickListener {
            pressSymbol("*")
        }

        buttonDivide.setOnClickListener {
            pressSymbol("/")
        }

        buttonEquals.setOnClickListener {
            pressSymbol("=")
        }

        buttonPosNeg.setOnClickListener {
            pressSymbol("+/-")
        }
    }

    private fun pressDigit(value: Int)
    {
        if (getNumberOne)
        {
            if (numberOne.length < MAX_LENGTH)
            {
                if (numberOne == "0")
                {
                    numberOne = "" + value
                }
                else
                {
                    numberOne += value
                }
            }
            output.text = numberOne
        }
        else
        {
            if (numberTwo.length < MAX_LENGTH)
            {
                if (numberTwo == "0")
                {
                    numberTwo = "" + value
                }
                else
                {
                    numberTwo += value
                }
            }
            output.text = numberOne + currSymbol + numberTwo
        }
    }

    private fun pressClear()
    {
        reset()
        output.text = numberOne
    }

    private fun pressDecimal()
    {
        if (getNumberOne)
        {
            if (!hasDecimalOne)
            {
                if (numberOne.length < MAX_LENGTH)
                {
                    hasDecimalOne = true
                    numberOne += "."
                }
            }
            output.text = numberOne
        }
        else
        {
            if (!hasDecimalTwo)
            {
                if (numberTwo.length < MAX_LENGTH)
                {
                    hasDecimalTwo = true
                    numberTwo += "."
                }
            }
            output.text = numberOne + currSymbol + numberTwo
        }
    }

    private fun pressSymbol(symbol: String)
    {
        if (symbol == "+/-")
        {
            if (getNumberOne)
            {
                if (hasDecimalOne)
                {
                    numberOne = (numberOne.toFloat() * -1).toString()
                    output.text = numberOne
                }
                else
                {
                    numberOne = (numberOne.toInt() * -1).toString()
                    output.text = numberOne
                }
            }
            else
            {
                if (hasDecimalTwo)
                {
                    numberTwo = (numberTwo.toFloat() * -1).toString()
                    output.text = numberOne + currSymbol + numberTwo
                }
                else
                {
                    numberTwo = (numberTwo.toInt() * -1).toString()
                    output.text = numberOne + currSymbol + numberTwo
                }
            }
        }
        if (symbol == "+")
        {
            if (getNumberOne)
            {
                getNumberOne = false
                output.text = numberOne + "+"
                currSymbol = "+"
            }
        }
        else if (symbol == "-")
        {
            if (getNumberOne)
            {
                getNumberOne = false
                output.text = numberOne + "-"
                currSymbol = "-"
            }
        }
        else if (symbol == "*")
        {
            if (getNumberOne)
            {
                getNumberOne = false
                output.text = numberOne + "*"
                currSymbol = "*"
            }
        }
        else if (symbol == "/")
        {
            if (getNumberOne)
            {
                getNumberOne = false
                output.text = numberOne + "/"
                currSymbol = "/"
            }
        }
        else if (symbol == "=")
        {
            if (getNumberOne)
            {

            }
            else
            {
                var numTotalFloat = 0f
                var numTotalInt = 0
                var errorMessage = ""

                if (currSymbol == "+")
                {
                    if (hasDecimalOne || hasDecimalTwo)
                    {
                        numTotalFloat = numberOne.toFloat() + numberTwo.toFloat()
                    }
                    else
                    {
                        numTotalInt = numberOne.toInt() + numberTwo.toInt()
                    }
                }
                else if (currSymbol == "-")
                {
                    if (hasDecimalOne || hasDecimalTwo)
                    {
                        numTotalFloat = numberOne.toFloat() - numberTwo.toFloat()
                    }
                    else {
                        numTotalInt = numberOne.toInt() - numberTwo.toInt()
                    }
                }
                else if (currSymbol == "*")
                {
                    if (hasDecimalOne || hasDecimalTwo)
                    {
                        numTotalFloat = numberOne.toFloat() * numberTwo.toFloat()
                    }
                    else
                    {
                        numTotalInt = numberOne.toInt() * numberTwo.toInt()
                    }

                }
                else if (currSymbol == "/")
                {
                    if (hasDecimalOne || hasDecimalTwo)
                    {
                        if (numberTwo.toFloat() == 0f)
                        {
                            errorMessage = "Divide by 0"
                        }
                        else
                        {
                            numTotalFloat = numberOne.toFloat() / numberTwo.toFloat()
                        }
                    }
                    else
                    {
                        if (numberTwo.toInt() == 0) {
                            errorMessage = "Divide by 0"
                        } else {
                            numTotalInt = numberOne.toInt() / numberTwo.toInt()
                        }
                    }
                }

                if (errorMessage != "")
                {
                    output.text = errorMessage
                }
                else
                {
                    if (hasDecimalOne || hasDecimalTwo)
                    {
                        output.text = numTotalFloat.toString()
                        numberOne = numTotalFloat.toString()
                    }
                    else
                    {
                        output.text = numTotalInt.toString()
                        numberOne = numTotalInt.toString()
                    }
                }

                reset()
            }
        }
    }

    private fun reset()
    {
        numberOne = "0"
        numberTwo = "0"
        hasDecimalOne = false
        hasDecimalTwo = false
        getNumberOne = true
        currSymbol = ""
    }
}
