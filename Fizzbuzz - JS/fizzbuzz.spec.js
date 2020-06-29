const { fizzBuzz } = require("./translateNumberToFizzBuzzValue");

describe("Fizz Buzz", () => {


    // Arrange

    // Act

    // Assert

   it("should return a number when not divisible", () => {
       // Arrange - Given
       let number = 1;

       // Act - When
       let fizzBuzz1 = fizzBuzz(number);

       // Assert - Then
       expect(fizzBuzz1).toEqual("1");
       // expect(fizzBuzz(2)).toEqual("2");

       // Single Assert Rule
   });

   it("should return fizz when divisible by 3", () => {
       expect(fizzBuzz(3)).toEqual("Fizz");
       expect(fizzBuzz(6)).toEqual("Fizz");
   });

    it("should return Buzz when 5", () => {
        expect(fizzBuzz(5)).toEqual("Buzz");
        expect(fizzBuzz(10)).toEqual("Buzz");
    });

    it("should return FizzBuzz when divisible by 3 and 5", () =>{
        expect(fizzBuzz(15)).toEqual("FizzBuzz");
        expect(fizzBuzz(30)).toEqual("FizzBuzz");
    });
});
