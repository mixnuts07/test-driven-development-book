package money

class Dollar(override var amount: Int): Money(amount) {

    fun times(multiplier: Int): Dollar {
        return Dollar(this.amount * multiplier)
    }
}
