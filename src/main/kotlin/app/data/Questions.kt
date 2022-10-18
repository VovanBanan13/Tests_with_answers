package app.data

data class Test(
    val questions: List<Question>
)

data class Question(
    val item: String,
    val answers: List<Answer>
)

data class Answer(
    val ans: String,
    val check: Boolean = false
)
