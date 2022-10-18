package app.service

import app.data.Question
import org.springframework.stereotype.Component

@Component
class PrintQuestion {
    fun print(question: Question) {
        println(question.item)
        println("Варианты ответа:")
        for (i in 1..question.answers.size) {
            println("${i}) ${question.answers[i-1].ans}")
        }
    }
}