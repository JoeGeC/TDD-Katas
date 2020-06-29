import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanNumeralConverterShould {
    private RomanNumeralConverter romanNumeralConverter;

    @BeforeEach
    void setUp(){
        romanNumeralConverter = new RomanNumeralConverter();
    }

    @Test
    void returnZero_GivenEmptyString() { assertEquals(0, romanNumeralConverter.convert("")); }

    @ParameterizedTest
    @CsvSource({"1, I", "2, II", "3, III", "4, IV", "5, V", "6, VI", "7, VII", "8, VIII", "9, IX", "10, X",
                "11, XI", "14, XIV", "15, XV", "16, XVI", "18, XVIII", "19, XIX", "20, XX", "39, XXXIX",
                "40, XL", "50, L", "60, LX", "80, LXXX", "75, LXXV", "89, LXXXIX", "90, XC", "100, C",
                "1000, M", "3948, MMMCMXLVIII"})
    void returnNumber_GivenRomanNumeral(int expectedNumber, String romanNumeral){
        assertEquals(expectedNumber, romanNumeralConverter.convert(romanNumeral));
    }
}
