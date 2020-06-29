public class NumberConverter {
    private int digit = 0;
    private int tenDigit = 0;
    private int hundredDigit = 0;
    private int thousandDigit = 0;

    public String convert(int number) {
        setUpDigits(number);
        return  append(thousandDigit, "M", "", "")
                + append(hundredDigit, "C", "D", "M")
                + append(tenDigit, "X", "L", "C")
                + append(digit, "I", "V", "X");
    }

    private void setUpDigits(int number){
        digit = getDigit(number, 1);
        tenDigit = getDigit(number, 10);
        hundredDigit = getDigit(number, 100);
        thousandDigit = getDigit(number, 1000);
    }

    private int getDigit(int number, int digitToGet) {
        return (number / digitToGet) % 10;
    }

    private String append(int number, String numeral, String midNumeral, String lateMidNumeral){
        return appendPreNumeral(number, numeral) + appendMidNumeral(number, midNumeral)
                + appendLateMidNumeral(number, lateMidNumeral) + appendOneNumeral(number, numeral);
    }

    private String appendPreNumeral(int number, String toAppend) {
        if(number == 4 || number == 9) return toAppend;
        return "";
    }

    private String appendMidNumeral(int number, String toAppend) {
        if(number >= 4 && number <= 8) return toAppend;
        return "";
    }

    private String appendLateMidNumeral(int number, String toAppend) {
        if (number == 9) return toAppend;
        return "";
    }

    private String appendOneNumeral(int number, String toAppend) {
        String result = "";
        if(number == 9) return result;
        if (number > 3) number -= 5;
        for (int i = 0; i < number; i++)
            result += toAppend;
        return result;
    }
}
