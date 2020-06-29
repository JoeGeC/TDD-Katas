import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class YahtzeeShould {
    private val player = PlayerMock()

    @ParameterizedTest
    @CsvSource ( "1", "2", "3", "4", "5", "6")
    internal fun `score all the same number`(diceValue: Int) {
        player.diceRollToReturn = mutableListOf(diceValue,diceValue, diceValue, diceValue, diceValue, diceValue)
        val playerRoll = player.rollDice(6)
        val yahtzee = Yahtzee()
        assertEquals(diceValue * 6, yahtzee.score(playerRoll))
    }


}

class PlayerMock: YahtzeePlayer {

    var diceRollToReturn = mutableListOf<Int>()

    override fun rollDice(numberOfDice: Int): List<Int> {
        return diceRollToReturn
    }
}