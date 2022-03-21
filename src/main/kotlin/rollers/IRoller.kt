package rollers

interface IRoller {
    fun rollDice(): MutableList<Int>
    fun lockDie(dieNum: Int)
}