package money

class Franc(override var amount: Int): Money(amount) {
    fun times(multiplier: Int): Franc {
        return Franc(this.amount * multiplier)
    }
}
