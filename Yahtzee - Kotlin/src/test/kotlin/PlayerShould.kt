import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class PlayerShould {
    private val player = Player()

    @ParameterizedTest
    @CsvSource("1", "2", "3", "4", "5", "6")
    internal fun `roll dice`(numberOfDice: Int) {
        player.rollDice(numberOfDice)
        assertEquals(numberOfDice, player.rolledDice.size)
    }

    @Test
    internal fun `take all dice`() {
        player.rollDice(6)
        player.takeRemainingDice()
        assertEquals(6, player.hand.size)
    }

    @Test
    internal fun `given empty hand, when take all dice of value 2, then hand should be all 2s`() {
        player.rolledDice = mutableListOf(1,1,2,2,2)
        player.takeAllDiceOfValue(2)
        player.hand.forEach { dieValue ->
            assertEquals(2, dieValue)
        }
    }
}