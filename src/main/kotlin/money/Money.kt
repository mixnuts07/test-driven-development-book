package money

open class Money(open var amount: Int) {
    fun equals(money: Money): Boolean {
        return this.amount == money.amount && money::class.equals(money::class)
    }
}