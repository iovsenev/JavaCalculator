import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.*;

public class ConsoleReaderTest {
    ConsoleReader reader = new ConsoleReader();

    @ParameterizedTest
    @CsvSource({
            "1+2, 1, 2",
            "1-2, 1, 2",
            "1*2, 1, 2",
            "1/2, 1, 2",
            "X+X, X, X",
            "I/I, I, I"
    })
    public void checkCorrectEnterForCorrectInputTest(String value, String num1, String num2) throws Exception {
       String[] expected = {num1,num2};
        var actual = reader.checkCorrectEnter(value);
        Assert.assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource({
            "12",
            "1%2",
            "1.2",
            "1 2"
    })
    public void checkCorrectEnterForNotCorrectInputTest(String value)
            throws Exception {
        assertThrows(Exception.class, () -> {
            reader.checkCorrectEnter(value);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,1,2",
            "10,9,10,9",
            "I,V,1,5",
            "X,C,10,100"
    })
    public void convertToArrayIntForCorrectInputTest
            (String num1, String num2, int convertedNum1, int convertedNum2)
            throws Exception {
            String[] value = {num1, num2};
            int[] expected = {convertedNum1, convertedNum2};
            int[] actual = reader.convertToArrayInt(value);
            assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "a,2",
            "X,9",
            "I,a",
            "X,3"
    })
    public void convertToArrayIntForNotCorrectInputTest
            (String num1, String num2)
            throws Exception {
        String[] value = {num1, num2};
        assertThrows(Exception.class, () -> {
            reader.convertToArrayInt(value);
        });
    }
}