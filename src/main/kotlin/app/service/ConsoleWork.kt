package app.service

import app.data.Answer
import app.data.Question
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class ConsoleWork(
    private val printQuestion: PrintQuestion,
    private val checkAnswer: CheckAnswer
    ) : CommandLineRunner {

    override fun run(vararg args: String?) {
        println("\n\t Начало работы приложения ")

        val oneQuestion = Question(
            "Сколько будет 2*2?",
            listOf(
                Answer("2"),
                Answer("3"),
                Answer("4", true),
                Answer("5"),
            )
        )
        val secondQuestion = Question(
            "Сколько будет 2+2?",
            listOf(
                Answer("2"),
                Answer("3"),
                Answer("4", true),
                Answer("5"),
            )
        )
        val listQuestions = listOf(oneQuestion, secondQuestion)

        var countRightAnswer = 0

        for (q in listQuestions) {
            printQuestion.print(q)
            if (checkAnswer.check(q)) {
                println("Верный ответ")
                countRightAnswer += 1
            } else println("Не правильно")
        }

        println("Тест завершён, верных ответов $countRightAnswer из ${listQuestions.size}")

        println("\n\t Конец работы приложения ")
    }
}