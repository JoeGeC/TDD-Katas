public class RomanNumeralConverter {
    private char previousChar = 'I';
    private char currentChar = 'I';

    public int convert(String romanNumeral) {
        int result = 0;
        for (int i = romanNumeral.length() - 1; i >= 0; i--) {
            currentChar = romanNumeral.charAt(i);
            result += numeralValue();
            previousChar = currentChar;
        }
        return result;
    }

    private int numeralValue() {
        for(Numeral numeral : Numeral.values()){
            if(currentCharIs(numeral.name())) return valueToAdd(numeral);
        }
        return 0;
    }

    private boolean currentCharIs(String numeral) {
        return currentChar == numeral.charAt(0);
    }

    private int valueToAdd(Numeral numeral) {
        if(previousCharIsNextTwoNumerals(numeral)) return -numeral.value;
        return numeral.value;
    }

    private boolean previousCharIsNextTwoNumerals(Numeral numeral) {
        return previousChar == numeral.getNextChar(1) || previousChar == numeral.getNextChar(2);
    }
}