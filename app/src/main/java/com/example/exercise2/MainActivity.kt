package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val weight = findViewById<EditText>(R.id.editTextWeight)
        val height = findViewById<EditText>(R.id.editTextHeight)
        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{
            if(weight.text.toString().isNotEmpty()&& height.text.toString().isNotEmpty()){
                calculateBMI(it)
            }else if(weight.text.toString().isEmpty()){
                Toast.makeText(this, "Require to input weight", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Require to input height", Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<Button>(R.id.buttonReset).setOnClickListener{
            clearScreen(it)
        }
    }

    private fun calculateBMI(view: View){
        val weight = findViewById<EditText>(R.id.editTextWeight)
        val height = findViewById<EditText>(R.id.editTextHeight)
        val resultBMI = findViewById<ImageView>(R.id.imageViewProfile)

        val result:Double = weight.text.toString().toDouble() / (height.text.toString().toDouble()/100*height.text.toString().toDouble()/100)
        val text = findViewById<TextView>(R.id.textViewBMIResult)
        text.text = result.toString()
        when{
            result<18.5 ->resultBMI.setBackgroundResource(R.drawable.under)
            result>24.9->resultBMI.setBackgroundResource(R.drawable.over)
            else -> resultBMI.setBackgroundResource(R.drawable.normal)
        }
    }
    private fun clearScreen(view: View){

        findViewById<EditText>(R.id.editTextWeight).setText("")
        findViewById<EditText>(R.id.editTextHeight).setText("")
        findViewById<ImageView>(R.id.imageViewProfile).setBackgroundResource(R.drawable.empty)
        findViewById<TextView>(R.id.textViewBMIResult).setText("")

    }
}