import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberConverterShould {
    private NumberConverter numberConverter;

    @BeforeEach
    void setUp(){
        numberConverter = new NumberConverter();
    }

    @Test
    void returnEmptyString_GivenZero() {
        assertEquals("", numberConverter.convert(0));
    }

    @ParameterizedTest
    @CsvSource({"I, 1", "II, 2", "III, 3", "IV, 4", "V, 5", "VI, 6", "VII, 7", "VIII, 8", "IX, 9", "X, 10",
                "XI, 11", "XII, 12", "XIII, 13", "XIV, 14", "XV, 15", "XVI, 16", "XVII, 17", "XVIII, 18", "XIX, 19",
                "XX, 20", "XXI, 21", "XXIV, 24", "XXVII, 27", "XXIX, 29", "XXX, 30", "XXXIX, 39", "XL, 40", "L, 50",
                "LX, 60", "LXXV, 75", "LXXX, 80", "LXXXIX, 89", "XC, 90", "XCIX, 99", "C, 100", "CC, 200", "CCC, 300",
                "CD, 400", "D, 500", "DC, 600", "CM, 900", "CMXCIX, 999", "M, 1000"})
    void returnRomanNumeral_GivenNumber(String expected, int number){
        assertEquals(expected, numberConverter.convert(number));
    }
}
