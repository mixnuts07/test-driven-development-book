package money

class Franc(override var amount: Int, override var currency: String): Money(amount, currency) {
    override fun times(multiplier: Int): Money {
        return Franc(this.amount * multiplier, "CHF")
    }
}
