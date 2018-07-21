import org.junit.Before;
import org.junit.Test;

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
    public void checkIsPalindrom(){
        assertEquals(true, IsPalindrom.isPalindrom(str1));
    }

    @Test
    public void forPalindromReturnFalse(){
        assertEquals(false, IsPalindrom.isPalindrom(str2));
    }


}
