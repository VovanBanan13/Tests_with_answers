package app.service

import app.data.Question
import org.springframework.stereotype.Component

@Component
class CheckAnswer {
    fun check(question: Question): Boolean {
        try {
            print("Ответ: ")
            val userAnswer = readln()
            val answerNumber = userAnswer.toInt()
            if (answerNumber < 1 || answerNumber > question.answers.size)
                throw ArrayIndexOutOfBoundsException()
            if (question.answers[answerNumber-1].check)
                return true
        }
        catch (e: NumberFormatException) {
            println("Ввели что-то не то, повторите: ")
            check(question)
        }
        catch (e: ArrayIndexOutOfBoundsException) {
            println("Вариант ответа не входит в диапазон, повторите: ")
            check(question)
        }
        catch (e: Exception) {
            println("Что-то не так, повторите: ")
            check(question)
        }

        return false
    }
}