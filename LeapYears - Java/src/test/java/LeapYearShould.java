import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LeapYearShould {

    @Test
    public void not_be_leap_year_for_2019() {
        assertNotLeapYear(2019);
    }

    @Test
    public void be_leap_year_for_2000() {
        assertIsLeapYear(2000);
    }

    @Test
    public void be_leap_year_for_1600() {
        assertIsLeapYear(1600);
    }

    @Test
    public void be_leap_year_for_2400() {
        assertIsLeapYear(2400);
    }

    @Test
    public void be_leap_year_for_2016() {
        assertIsLeapYear(2016);
    }

    @Test
    public void be_leap_year_for_2012() {
        assertIsLeapYear(2012);
    }

    @Test
    public void be_leap_year_for_2008() {
        assertIsLeapYear(2008);
    }

    @Test
    public void not_be_leap_year_for_1900() {
        assertNotLeapYear(1900);
    }

    @Test
    public void not_be_leap_year_for_2100() {
        assertNotLeapYear(2100);
    }

    private void assertIsLeapYear(int year) {
        assertThat(new LeapYear().isLeapYear(year), is(true));
    }

    private void assertNotLeapYear(int year) {
        assertThat(new LeapYear().isLeapYear(year), is(false));
    }
}