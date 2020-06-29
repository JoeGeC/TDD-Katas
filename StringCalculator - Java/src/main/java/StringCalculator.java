import java.text.DecimalFormat;

public class StringCalculator {
    private DecimalFormat outputNumberFormat = new DecimalFormat("#.#");

    public String add(String number) {
        if (number.equals("")) return "0";
        else return processNumbers(number);
    }

    private String processNumbers(String numbers) {
        String commaSeparatedNumbers = numbers.replace("\n", ",");
        if(commaSeparatedNumbers.contains(",,")) return doubleSeparatorErrorMessage(commaSeparatedNumbers);
        else return sumOfNumbers(commaSeparatedNumbers);
    }

    private String doubleSeparatorErrorMessage(String commaSeparators) {
        int positionOfCommas = commaSeparators.indexOf(",,") + 1;
        return String.format("Number expected but '\\n' found at position %s.", positionOfCommas);
    }

    private String sumOfNumbers(String commaSeparatedNumbers){
        String[] numbersToAdd = commaSeparatedNumbers.split(",");
        if (moreThanOneNumberToAdd(numbersToAdd)) return calculateSumOfNumbers(numbersToAdd);
        return commaSeparatedNumbers;
    }

    private boolean moreThanOneNumberToAdd(String[] input) {
        return input.length > 1;
    }

    private String calculateSumOfNumbers(String[] numbers) {
        double sum = 0;
        for (String number : numbers) sum += Double.parseDouble(number);
        return outputNumberFormat.format(sum);
    }
}
