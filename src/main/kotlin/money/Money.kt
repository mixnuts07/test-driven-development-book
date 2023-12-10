package money

import java.util.Currency

open class Money(open var amount: Int, open var currency: String) {
    fun times(multiplier: Int): Money {
        return Money(this.amount * multiplier, currency)
    }
//    TODO assetEqualsで使用しているequalsを上書きたい
    fun equals(money: Money): Boolean {
        return this.amount == money.amount && this.currency == money.currency
    }
    override fun toString(): String {
        return "$amount + ' ' + $currency"
    }
    fun currency(): String {
        return currency
    }

    fun plus(dollar: Money): Expression {
        TODO()
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