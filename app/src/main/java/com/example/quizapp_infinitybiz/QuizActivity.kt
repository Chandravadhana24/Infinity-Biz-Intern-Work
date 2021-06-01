package com.example.quizapp_infinitybiz

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class QuizActivity : AppCompatActivity() {

    private fun openCorrectDialog(d:Dialog) {
        d.setContentView(R.layout.correct_dialog_layout)
        d.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        d.show()
    }

    private fun openWrongDialog(d:Dialog) {
        d.setContentView(R.layout.wrong_dialog_layout)
        d.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        d.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        var Qs = QuestionAnswer("What is the capital of India","Delhi",arrayOf<String>("Kochi","Delhi","Jaipur","Coimbatore"))
        var q_text = findViewById<TextView>(R.id.question)
        q_text.text = Qs.Question
        var option1 = findViewById<Button>(R.id.opt1)
        option1.text = Qs.options[0]
        var option2 = findViewById<Button>(R.id.opt2)
        option2.text = Qs.options[1]
        var option3 = findViewById<Button>(R.id.opt3)
        option3.text = Qs.options[2]
        var option4 = findViewById<Button>(R.id.opt4)
        option4.text = Qs.options[3]


        val radioGroup = findViewById<RadioGroup>(R.id.radioGrp)
        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            //Toast.makeText(this,"option "+i+" is selected",Toast.LENGTH_LONG).show()
            val selectedOption: Int = radioGroup!!.checkedRadioButtonId

            var option = findViewById<RadioButton>(selectedOption)

            //Toast.makeText(this, option.text, Toast.LENGTH_SHORT).show()
            val dialog = Dialog(this)
            if(Qs.isCorrect(option.text.toString()))
            {
                option.setBackgroundColor(Color.GREEN)
                //Toast.makeText(this, "CORRECT ANS", Toast.LENGTH_SHORT).show()
                openCorrectDialog(dialog)
            }
            else
            {
                openWrongDialog(dialog)
            }
        })

//        q_text.text = Qs.Question
//        option1.text = Qs.options[0]
//        option2.text = Qs.options[1]
//        option3.text = Qs.options[2]
//
//        option1.setOnClickListener{
//            if(isCorrect(option1.text.toString(),Qs.answer))
//            {
//                option1.setBackgroundColor(Color.GREEN)
//            }
//        }
//        option2.setOnClickListener{
//            if(isCorrect(option2.text.toString(),Qs.answer))
//            {
//                option2.setBackgroundColor(Color.GREEN)
//            }
//        }
//        option3.setOnClickListener{
//            if(isCorrect(option3.text.toString(),Qs.answer))
//            {
//                option3.setBackgroundColor(Color.GREEN)
//            }
//        }
//        option4.setOnClickListener{
//            if(isCorrect(option4.text.toString(),Qs.answer))
//            {
//                option4.setBackgroundColor(Color.GREEN)
//            }
//        }
    }
}