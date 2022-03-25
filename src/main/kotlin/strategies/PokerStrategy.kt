package strategies

class PokerStrategy: IStrategy {
    override fun checkStrategy(numbers: MutableList<Int>): Boolean{
            for (i in 0 until numbers.size) {
                var countOfKind = 0
                for (j in 0 until numbers.size) {
                    if (numbers[i] == numbers[j]) {
                        countOfKind++
                    }
                }
                if (countOfKind >= 4) {
                    return true
                }
            }
            return false
        }
    }