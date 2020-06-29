import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AcceptanceTest {
    @Test
    void numberToRomanAcceptance() {
        NumberConverter numberConverter = new NumberConverter();
        assertEquals("I", numberConverter.convert(1));
        assertEquals("X", numberConverter.convert(10));
        assertEquals("VII", numberConverter.convert(7));
    }

    @ParameterizedTest
    @CsvSource({"1, I", "10, X", "7, VII"})
    void romanToNumberAcceptance(int expectedNumber, String romanNumeral) {
        RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter();
        assertEquals(expectedNumber, romanNumeralConverter.convert(romanNumeral));
    }
}
