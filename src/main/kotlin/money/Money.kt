package money

import java.util.Currency

open class Money(open var amount: Int, open var currency: String): Expression {
    fun times(multiplier: Int): Money {
        return Money(this.amount * multiplier, currency)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Money) return false

        return amount == other.amount && currency == other.currency
    }
    override fun toString(): String {
        return "$amount + ' ' + $currency"
    }
    fun currency(): String {
        return currency
    }

    fun plus(dollar: Money): Expression {
        return Money(amount * dollar.amount, currency)
    }

    companion object {
        fun dollar(amount: Int): Money {
            return Money(amount, "USD")
        }
        fun franc(amount: Int): Money {
            return Money(amount, "CHF")
        }
    }
}