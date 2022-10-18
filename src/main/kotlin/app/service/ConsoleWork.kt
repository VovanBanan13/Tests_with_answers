package app.service

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class ConsoleWork(
    private val printQuestion: PrintQuestion,
    private val checkAnswer: CheckAnswer,
    private val jsonParser: JsonParser
    ) : CommandLineRunner {

    override fun run(vararg args: String?) {
        println("\n\t Начало работы приложения ")

        val jsonFile = "src/main/resources/test.json"

        val test = jsonParser.parse(jsonFile)

        var countRightAnswer = 0

        for (q in test.questions) {
            println()
            printQuestion.print(q)
            if (checkAnswer.check(q)) {
                println("Правильно")
                countRightAnswer += 1
            } else println("Не правильно")
        }

        println("\nТест завершён, верных ответов $countRightAnswer из ${test.questions.size}")

        println("\n\t Конец работы приложения ")
    }
}