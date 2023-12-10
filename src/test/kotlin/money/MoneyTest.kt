package money

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MoneyTest {
    private val five: Money = Money.dollar(5)
    @Test
    fun testEquality() {
        assertTrue { (Money.dollar(5).equals(Money.dollar(5))) }
        assertFalse { (Money.dollar(5).equals(Money.dollar(6))) }
        assertTrue { (Money.franc(5).equals(Money.franc(5))) }
        assertFalse { (Money.franc(5).equals(Money.franc(6))) }
        assertFalse { (Money.franc(5).equals(Money.dollar(5))) }
    }

    @Test
    fun testCurrency(){
        assertEquals("USD", Money.dollar(1).currency())
        assertEquals("CHF", Money.franc(1).currency())
    }

    @Test
    fun testSimpleAddition() {
        val sum: Expression = five.plus(five)
        val reduced = Bank.reduce(sum, "USD")
        assertEquals(Money.dollar(10), reduced)
    }
}