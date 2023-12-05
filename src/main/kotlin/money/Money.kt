package money

import java.util.Currency

abstract class Money(open var amount: Int, open var currency: String) {
    abstract fun times(multiplier: Int): Money
    fun equals(money: Money): Boolean {
        if (this === money) return true
        return this.amount == money.amount && this.currency == money.currency
        return false
    }
    fun currency(): String {
        return currency
    }
    companion object {
        fun dollar(amount: Int): Dollar {
            return Dollar(amount, "USD")
        }
        fun franc(amount: Int): Franc {
            return Franc(amount, "CHF")
        }
    }
}