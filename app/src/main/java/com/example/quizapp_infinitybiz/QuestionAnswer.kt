package com.example.quizapp_infinitybiz

class QuestionAnswer(var Q: String, var ans: String,var opts: Array<String>) {
    fun isCorrect(chosen: String): Boolean
    {
        return if(chosen.equals(answer)) { true } else { false }
    }

    var Question= Q
    var answer = ans
    var options = opts
}