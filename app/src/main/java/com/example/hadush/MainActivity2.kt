package com.example.hadush

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    private var inputEditText: EditText? = null
    private var resultTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        inputEditText = findViewById(R.id.editTextText)
        resultTextView = findViewById(R.id.textView3)
        val calculateButton = findViewById<Button>(R.id.button)
        val backButton = findViewById<ImageView>(R.id.backButton)

        calculateButton.setOnClickListener { v: View? -> calculateAndDisplayResult() }
        backButton.setOnClickListener { v: View? -> finish() } // Go back to previous activity
    }

    private fun calculateAndDisplayResult() {
        val input = inputEditText!!.text.toString().trim { it <= ' ' }

        if (!input.isEmpty()) {
            try {
                val year = input.toInt()
                val medeb = (5500 + year) % 19
                val wenber = (5500 + year) % 19 - 1
                val abektie = (11 * wenber) % 30
                val metkie = (19 * wenber) % 30
                val mebachHamer = ((5500 + year) + (5500 + year) / 4) % 7
                val mebachHamerName = getMebachHamerName(mebachHamer)
                val zemene=(5500 + year)%4
                val zemene_wengelawiName=getZemeneWengelawi(zemene)
                val result = """
                    ዘመነ ወንጌላው፡ $zemene_wengelawiName
                    መደብ፡ $medeb
                    ወንበር: $wenber
                    አበቅቴ: $abektie
                    መጥቅእ: $metkie
                    መባች ሓመር(መስከረም 1 ዝውእለሉ መአልቲ): $mebachHamerName
                    """.trimIndent()
                resultTextView!!.text = result
            } catch (e: NumberFormatException) {
                resultTextView!!.text = " በይዝኦም ሓቀኛ ቁትሪ የእትዉ"
            }
        } else {
            resultTextView!!.text = "በይዝኦም አመተ ምህረት የእትው"
        }
    }

    private fun getMebachHamerName(dayCode: Int): String {
        return when (dayCode) {
            0 -> "ሶኒ"
            1 -> "ሰሉስ"
            2 -> "ረቡዕ"
            3 -> "ሓሙስ"
            4 -> "ዓርብ"
            5 -> "ቅዳሜ"
            6 -> "ሰንበት"
            else -> "ልክዕ ዘይኮነ ቁጽሪ እዩ"
        }
    }

    private fun getZemeneWengelawi(dayCode: Int): String {
        return when (dayCode) {
            0 -> "ዮሓንስ"
            1 -> "ማቴዎስ"
            2 -> "ማርኮስ"
            3 -> "ሉካስ"

            else -> "ልክዕ ዘይኮነ ቁጽሪ እዩ"
        }
    }
}