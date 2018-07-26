package isPalindrom;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class IsPalindromTest {

    private IsPalindrom isPalindrom;
    //private String str1 = "iwi";
    //private String str2 = "kiwi";

    @Before
    public void setup() {
        isPalindrom = new IsPalindrom();
    }

    @Test
    public void when_IsPalindrom_return_True() {
        Assert.assertTrue(IsPalindrom.isPalindrom("aba"));
    }

    @Test
    public void when_IsPalindrom_Return_False() {
        assertFalse(IsPalindrom.isPalindrom("abc"));
    }

    @Test
    public void when_4_letters_IsPalindrom_Return_True() {
        Assert.assertTrue(IsPalindrom.isPalindrom("abba"));
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
