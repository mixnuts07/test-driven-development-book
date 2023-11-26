package money

class Dollar {
    var amount: Int
    constructor(i: Int){
        amount = i
    }

    fun times(i: Int): Dollar {
        this.amount *= i
        return Dollar(this.amount)
    }
}
