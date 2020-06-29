class Player: YahtzeePlayer {
    var rolledDice = mutableListOf<Int>()
    var hand = mutableListOf<Int>()

    override fun rollDice(numberOfDice: Int): List<Int> {
        val result = mutableListOf<Int>()
        for (number in 1..numberOfDice){
            result.add(roll())
        }
        rolledDice = result
        return result
    }

    private fun roll(): Int {
        return 1
    }

    fun takeRemainingDice() {
        hand = rolledDice
    }

    fun takeAllDiceOfValue(value: Int) {
        while (rolledDice.contains(value)) {
            rolledDice.remove(value)
            hand.add(value)
        }
    }
}
