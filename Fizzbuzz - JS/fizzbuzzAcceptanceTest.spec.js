const { fizzBuzzUpTo } = require("./translateNumberToFizzBuzzValue");

describe("Fizz Buzz Acceptance", () => {
    it("should return numbers up to 20", () => {
        const expected = "1\n" +
            "2\n" +
            "Fizz\n" +
            "4\n" +
            "Buzz\n" +
            "Fizz\n" +
            "7\n" +
            "8\n" +
            "Fizz\n" +
            "Buzz\n" +
            "11\n" +
            "Fizz\n" +
            "13\n" +
            "14\n" +
            "FizzBuzz\n" +
            "16\n" +
            "17\n" +
            "Fizz\n" +
            "19\n" +
            "Buzz\n";

        expect(fizzBuzzUpTo(20)).toEqual(expected);
    });

});
