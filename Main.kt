import kotlin.random.Random

class Game {
    fun start() {
        println("Welcome to Guessing game! \n Do you want to guess the number or make a guess? Type (1/2): ")
        val guessingGame = readlnOrNull() ?: ""
        when (guessingGame) {
            "1" -> playerGuess()
            "2" -> computerGuess()
        }
    }

    private fun computerGuess() {
        var min = 1
        var max = 100
        var attempts = 0
        val answers = arrayOf("higher", "lower", "correct")
        println("Please select a number from $min to $max.")

        while (min <= max) {
            val guess = (min + max) / 2
            println("Is your number $guess? Please input 'higher', 'lower', or 'correct':")

            var response: String?
            do {
                response = readlnOrNull()
            } while (response !in answers)

            when (response?.lowercase()) {
                "correct" -> {
                    println("Finally! I guessed $guess in $attempts attempts.")
                    return
                }
                "higher" -> min = guess + 1
                "lower" -> max = guess - 1
                else -> println("Please input 'higher', 'lower', or 'correct'")
            }
            attempts++
        }
    }

    private fun playerGuess() {
        val computerNumber = Random.nextInt(1, 100)
        var attempts = 0
        var guesserNumber: Int

        while (true) {
            println("Try to guess the number: ")
            guesserNumber = readlnOrNull()?.toIntOrNull() ?: continue

            when {
                computerNumber < guesserNumber -> println("Number is lower")
                computerNumber > guesserNumber -> println("Number is higher")
                else -> {
                    println("You guessed the number in $attempts attempts!")
                    break
                }
            }
            attempts++
        }
    }
}

fun main() {
    val game = Game()
    game.start()
}

//Dolynko Anton