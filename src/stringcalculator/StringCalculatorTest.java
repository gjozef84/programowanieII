package stringcalculator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import stringcalculator.StringCalculator;

import static org.junit.Assert.assertEquals;

/**
 * Created by Grzesiek on 21.07.2018.
 */
public class StringCalculatorTest {
    StringCalculator calculator = new StringCalculator();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void empty_input_returns_zero() {
        String input = "";
        int result = calculator.Sum(input);
        assertEquals(0, result);
    }

    @Test
    public void one_number_in_input_returns_number() {
        String input = "1";
        int result = calculator.Sum(input);
        assertEquals(1, result);
    }

    @Test
    public void two_number_in_input_returns_sum() {
        String input = "1,2";
        int result = calculator.Sum(input);
        assertEquals(3, result);
    }

    @Test
    public void moreThenTwo_number_in_input_returns_sumOfThem() {
        String input = "1,2,7";
        int result = calculator.Sum(input);
        assertEquals(10, result);
    }

    @Test
    public void StringContainsEOL_number_in_input_returns_sumOfThem() {
        String input = "1,2\n7";
        int result = calculator.Sum(input);
        assertEquals(10, result);
    }

    @Test
    public void String_With_Defined_Separator_As_Char_for_numbers_in_input_returns_sumOfThem() {
        String input = "//;\n1;2";
        int result = calculator.Sum(input);
        assertEquals(3, result);
    }

    @Test
    public void valuesBiggerThen9() {
        String input = "//;\n1;2;10;100";
        int result = calculator.Sum(input);
        assertEquals(113, result);
    }

    @Test
    public void String_With_Negatives_for_numbers_in_input_returns_sumOfThem() {
        String input = "//;\n1;2;-2;-5";
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("negatives not allowed: [-2, -5]");
        calculator.Sum(input);
    }

    @Test
    public void valuesBiggerThen1000Ignored() {
        String input = "//;\n1002;2";
        int result = calculator.Sum(input);
        assertEquals(2, result);
    }

    @Test
    public void String_With_Defined_Separator_As_String_for_numbers_in_input_returns_sumOfThem() {
        String input = "//[aaa]\n1aaa2aaa3";
        int result = calculator.Sum(input);
        assertEquals(6, result);
    }

    @Test
    public void String_With_Defined_Pool_Of_Separators_As_Char_for_numbers_in_input_returns_sumOfThem() {
        String input = "//[%][ ][a]\n1%2a3";
        int result = calculator.Sum(input);
        assertEquals(6, result);
    }
}
