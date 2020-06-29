import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NameInverterTest {
    private NameInverter nameInverter;

    @Before
    public void setup(){
        nameInverter = new NameInverter();
    }

    private void assertInverted(String originalName, String invertedName) {
        assertEquals(invertedName, nameInverter.invertName(originalName));
    }

    @Test
    public void givenNull_returnsEmptyString() {
        assertInverted(null, "");
    }

    @Test
    public void givenEmptyString_returnsEmptyString() {
        assertInverted("", "");
    }

    @Test
    public void givenSimpleName_returnSimpleName() {
        assertInverted("Name", "Name");
    }

    @Test
    public void givenSimpleNameWithSpaces_returnSimpleNameWithoutSpaces() {
        assertInverted(" Name ", "Name");
    }

    @Test
    public void givenFirstLast_returnLastFirst() {
        assertInverted("First Last", "Last, First");
    }

    @Test
    public void givenFirstLastWithExtraSpaces_returnLastFirst() {
        assertInverted("  First  Last   ", "Last, First");
    }

    @Test
    public void ignoreHonorific() {
        assertInverted("Mr. First Last", "Last, First");
        assertInverted("Mrs. First Last", "Last, First");
    }

    @Test
    public void postNominals_stayAtEnd() {
        assertInverted("First Last Sr.", "Last, First Sr.");
        assertInverted("First Last BS. Phd.", "Last, First BS. Phd.");
    }

    @Test
    public void integration() {
        assertInverted("   Robert Martin III esq.    ", "Martin, Robert III esq.");
    }
}
