import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccpetanceTest {
    @Test
    @Disabled
    void acceptanceTest() {
        FooBarQix fooBarQix = new FooBarQix();
        assertEquals("1, 2, FooFoo, 4, BarBar, Foo, QixQix, 8, Foo, Bar, 11, Foo, Foo, Qix, FooBarBar, 16, Qix, Foo, 19, Bar",
                fooBarQix.printMany(10));
    }
}
