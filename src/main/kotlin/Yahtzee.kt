import rollers.Roller
import strategies.IStrategy
import strategies.LargeStraightStrategy
import strategies.PokerStrategy
import strategies.YahtzeeStrategy
import kotlin.system.exitProcess

class Yahtzee {
    private var numbers: MutableList<Int> = mutableListOf()
    private var totalScore: Int = 0

    private var roller: Roller = Roller()
    private var yahtzeeStrategy: IStrategy = YahtzeeStrategy()
    private var largeStraightStrategy: IStrategy = LargeStraightStrategy()
    private var pokerStrategy: IStrategy = PokerStrategy()

    fun startGame(){
        for(i in 0..2){
            startRound()
            if(i<2) {
                userInput()
            }
        }
        exitGame()
    }

    private fun userInput(){
        println("Write next for next round or end to exit game")
        println("Or write 1 .. 6 to lock that die")
        getUserInput()
    }

    private fun getUserInput(){
        when (val userInput: String = readLine()!!) {
            "1", "2", "3", "4", "5", "6" -> {
                val dieNum = Integer.parseInt(userInput)
                println("Locking $dieNum")
                roller.lockDie(dieNum)
            }
            "next" -> {
                return
            }
            "end" -> {
                exitGame()
            }
            else -> {
                println("Wrong input, try again")
                getUserInput()
            }
        }
    }

    private fun exitGame(){
        println("Total score: $totalScore")
        exitProcess(0)
    }

    private fun startRound() {
        numbers = roller.rollDice()

        println(numbers)

        val isYahtzee: Boolean = yahtzeeStrategy.checkStrategy(numbers)
        val isLargeStraight: Boolean = largeStraightStrategy.checkStrategy(numbers)
        val isPoker: Boolean = pokerStrategy.checkStrategy(numbers)

        if(isYahtzee){
            totalScore += 50
            println("Yahtzee!")
        } else if(isLargeStraight) {
            totalScore += 40
            println("Large Straight!")
        }
        else if(isPoker){
                totalScore += 25
                println("Poker!")
        } else {
            totalScore += getRoundScore()
        }

        println("Current score: $totalScore")
        numbers.clear()
    }

    private fun getRoundScore(): Int{
        var score = 0
        numbers.forEach { number ->
            score += number
        }
        return score
    }
}