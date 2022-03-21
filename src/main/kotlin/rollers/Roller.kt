package rollers

import Die

class Roller: IRoller {
    private val dice = List(6){ Die() }

    override fun rollDice(): MutableList<Int> {
        val numbers: MutableList<Int> = mutableListOf()

        dice.forEach { die ->
            if(!die.isLocked){
                die.roll()
            }
            numbers.add(die.number)
        }
        return numbers
    }

    override fun lockDie(dieNum: Int){
        val dieIndex = dieNum-1
        dice[dieIndex].lock()
    }
}