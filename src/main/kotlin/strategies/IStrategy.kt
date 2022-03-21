package strategies

interface IStrategy {
    fun checkStrategy(numbers: MutableList<Int>): Boolean
}