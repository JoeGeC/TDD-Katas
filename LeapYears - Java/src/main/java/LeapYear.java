public class LeapYear {


    public boolean isLeapYear(int year) {
        return isDivisibleByFourHundred(year) || (isDivisibleByFour(year) && isNotDivisibleByOneHundred(year));
    }

    private boolean isDivisibleByFourHundred(int year) {
        return isDivisible(year, 400);
    }

    private boolean isDivisibleByFour(int year) {
        return isDivisible(year, 4);
    }

    private boolean isNotDivisibleByOneHundred(int year) {
        return !isDivisible(year, 100);
    }

    private boolean isDivisible(int numerator, int denominator) {
        return numerator % denominator == 0;
    }
}
