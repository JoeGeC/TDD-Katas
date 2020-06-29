import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FooBarQixShould {
    private FooBarQix fooBarQix;

    @BeforeEach
    void setUp(){
        fooBarQix = new FooBarQix();
    }

    @Test
    void returnEmptyString_GivenZero() {
        assertEquals("", fooBarQix.print(0));
    }

    @ParameterizedTest
    @CsvSource({"1, 1", "2, 2", "FooFoo, 3", "BarBar, 5", "Foo, 6", "QixQix, 7", "Bar, 10"})
    void return1_GivenOne(String expected, int value) {
        assertEquals(expected, fooBarQix.print(value));
    }
}
