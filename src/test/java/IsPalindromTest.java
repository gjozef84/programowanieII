import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;

public class IsPalindromTest {

    private IsPalindrom isPalindrom;
    private String str1 = "iwi";
    private String str2 = "kiwi";

    @Before
    public void setup() {
        isPalindrom = new IsPalindrom();
    }

    @Test
    public void checkIsPalindrom() {
        assertEquals(true, IsPalindrom.isPalindrom(str1));
    }

    @Test
    public void forNotPalindromReturnFalse() {
        assertEquals(false, IsPalindrom.isPalindrom(str2));
    }

    @Test(expected = InvalidParameterException.class)
    public void forPalindromReturnInvalidParameterException() {
        IsPalindrom.isPalindrom(null);
    }

    @Test(expected = InvalidParameterException.class)
    public void forEmptyStringReturnInvalidParameterException() {
        IsPalindrom.isPalindrom("");
    }

}
