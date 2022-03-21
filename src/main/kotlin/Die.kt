import java.util.*

class Die {
    var number: Int = 0;
    var isLocked: Boolean = false;

    fun roll() {
        number = (1..6).random()
    }

    fun lock() {
        isLocked = true
    }
}