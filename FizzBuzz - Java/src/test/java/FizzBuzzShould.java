import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FizzBuzzShould {

    FizzBuzz fizzBuzz;
    Outputter outputter;

    @Before
    public void setUp() throws Exception {
        outputter = mock(Outputter.class);
        fizzBuzz = new FizzBuzz(outputter);
    }

    @Test
    public void outputOneGivenFizzBuzzOfOne() {
        assertOutput(1, "1");
    }

    @Test
    public void outputTwoGivenFizzBuzzOfTwo() {
        assertOutput(2, "2");
    }

    @Test
    public void outputFourGivenFizzBuzzOfFour() {
        assertOutput(4, "4");
    }

    @Test
    public void outputFizzGivenFizzBuzzOfThree() {
        assertOutput(3, "Fizz");
    }

    @Test
    public void outputBuzzGivenFizzBuzzOfFive() {
        assertOutput(5, "Buzz");
    }

    @Test
    public void outputFizzGivenFizzBuzzOfSix() {
        assertOutput(6, "Fizz");
    }

    @Test
    public void outputBuzzGivenFizzBuzzOfTen() {
        assertOutput(10, "Buzz");
    }

    @Test
    public void outputFizzBuzzGivenFizzBuzzOfFifteen() {
        assertOutput(15, "FizzBuzz");
    }

    @Test
    public void outputFizzBuzzGivenFizzBuzzOfThirty() {
        assertOutput(30, "FizzBuzz");
    }

    @Test
    public void outputOneToOneHundred() {
        fizzBuzz = new FizzBuzz(new Console());
        for (int i = 1; i <= 100; i++) {
            fizzBuzz.fizzBuzz(i);
        }
    }

    private void assertOutput(int number, String output) {
        fizzBuzz.fizzBuzz(number);
        verify(outputter).output(output);
    }
}