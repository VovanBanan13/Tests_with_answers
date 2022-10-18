package app.data

data class Question(
    val question: String,
    val answers: List<Answer>
)

data class Answer(
    val ans: String,
    val check: Boolean = false
)
