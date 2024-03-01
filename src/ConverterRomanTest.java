import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.*;

public class ConverterRomanTest {
    ConverterRoman converter = new ConverterRoman();

    @ParameterizedTest
    @CsvSource({
            "X,10",
            "I,1",
            "V,5",
            "IX,9",
            "II,2",
            "VIII,8",
            "IV,4",
    })
    public void convertToIntTest(String value, int expected) {
        int actual = converter.convertToInt(value);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "10,X",
            "123,CXXIII",
            "100,C",
            "99,XCIX",
            "89,LXXXIX"
    })
    public void convertToRomain(int value, String expected) {
        String actual = converter.convertToRomain(value);
        assertEquals(expected, actual);
    }
}