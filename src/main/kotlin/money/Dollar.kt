package money

class Dollar(override var amount: Int, override var currency: String): Money(amount, currency) {
    override fun times(multiplier: Int): Money {
        return Dollar(this.amount * multiplier, "USD")
    }
}
