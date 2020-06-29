import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

   @Test
   void returnsZeroGivenEmptyString() {
        assertStringCalculatorAdd("", "0");
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2"}, delimiter = ':')
    void returnsInputGivenOneNumber(String numbers, String expectedSum){
        assertStringCalculatorAdd(numbers, expectedSum);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1:2", "1,2:3"}, delimiter = ':')
    void addsTwoNumbers(String numbers, String expectedSum){
        assertStringCalculatorAdd(numbers, expectedSum);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1,1:3", "1,2,3:6", "1,1,1,1:4", "1,1,1,1,1,1:6"}, delimiter = ':')
    void addsManyNumbers(String numbers, String expected) {
        assertStringCalculatorAdd(numbers, expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1.1,2.2:3.3", "2.2,3.3,4.4:9.9"}, delimiter = ':')
    void addsFloats(String number, String expected) {
        assertStringCalculatorAdd(number, expected);
    }

    @Test
    void takesNewLineAsSeparator(){
        assertStringCalculatorAdd("1\n2", "3");
    }

    @Test
    void returnErrorGivenDoubleSeparator() {
        assertStringCalculatorAdd("175.2,\n35", "Number expected but '\\n' found at position 6.");
    }

    @Test
    void returnErrorGivenDoubleSeparatorAtDifferentPosition() {
        assertStringCalculatorAdd("175,\n35", "Number expected but '\\n' found at position 4.");
    }

    private void assertStringCalculatorAdd(String numbers, String expectedSum) {
        String sum = stringCalculator.add(numbers);
        assertEquals(expectedSum, sum);
    }
}