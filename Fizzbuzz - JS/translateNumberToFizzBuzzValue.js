function fizzBuzzUpTo(number) {
    let result = "";
    for (let i = 1; i <= number; i++)
        result += `${translateNumberToFizzBuzzValue(i)}\n`;
    return result;
}

function translateNumberToFizzBuzzValue(number) {
    if (number % 15 === 0)
        return "FizzBuzz";
    if (number % 3 === 0)
        return "Fizz";
    if (number % 5 === 0)
        return "Buzz";
    return `${number}`;
}

module.exports = { fizzBuzz: translateNumberToFizzBuzzValue, fizzBuzzUpTo };
