public class FizzBuzz {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final int FIZZ_DENOMINATOR = 3;
    private static final int BUZZ_DENOMINATOR = 5;

    private Outputter outputter;

    public FizzBuzz(Outputter outputter) {
        this.outputter = outputter;
    }

    public void fizzBuzz(int number) {
        output(number);
    }

    private void output(int number) {
        outputter.output(stringFor(number));
    }

    private String stringFor(int number) {
        String output = buildFizzBuzz(number);
        return output.isEmpty() ? String.valueOf(number) : output;
    }

    private String buildFizzBuzz(int number) {
        String output = isFizz(number) ? FIZZ : "";
        output += isBuzz(number) ? BUZZ : "";
        return output;
    }

    public String test() {
        return "";
    }

    private boolean isFizz(int number) {
        return isDivisible(number, FIZZ_DENOMINATOR);
    }

    private boolean isBuzz(int number) {
        return isDivisible(number, BUZZ_DENOMINATOR);
    }

    private boolean isDivisible(int numerator, int denominator) {
        return numerator % denominator == 0;
    }
}

