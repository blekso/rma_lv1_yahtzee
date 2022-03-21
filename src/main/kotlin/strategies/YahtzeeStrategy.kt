package strategies

class YahtzeeStrategy: IStrategy {
    override fun checkStrategy(numbers: MutableList<Int>): Boolean{
        numbers.forEach { number ->
            if(number != numbers[0]){
                return false;
            }
        }
        return true;
    }
}