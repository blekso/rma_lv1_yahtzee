package strategies

class LargeStraightStrategy: IStrategy {
    override fun checkStrategy(numbers: MutableList<Int>): Boolean{
        numbers.forEachIndexed { index, number ->
            if(index < numbers.size-1) {
                if (number + 1 != numbers[index + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}