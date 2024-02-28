import java.util.*;

class ConverterRoman {
    Map<Character, Integer> romans = new TreeMap<>();

    public ConverterRoman() {
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);
    }

    public boolean isRomain(String string) {
        var charArr = string.toCharArray();
        for (char c : charArr)
            if (!romans.containsKey(c))
                return false;
        return true;
    }

    public int convertToInt(String string) {
        var charArr = string.toCharArray();
        int index = charArr.length - 1;
        var end = romans.get(charArr[index]);
        int convertedNumber = end;

        for (int i = index - 1; i >= 0; i--) {
            int current = romans.get(charArr[i]);
            if (end > current)
                convertedNumber -= current;
            else
                convertedNumber += current;
            end = current;
        }
        return convertedNumber;
    }

    public String convertToRomain(int number) {
        StringBuilder sb = new StringBuilder();
        String[] keys = {
                "M", "CM", "D", "CD", "C", "XC",
                "L", "XL", "X", "IX", "V", "IV", "I"
        };
        int[] values = {
                1000, 900, 500, 400, 100, 90,
                50, 40, 10, 9, 5, 4, 1
        };

        int index = 0;
        while (index < keys.length) {
            while (number > values[index]) {
                int d = number / values[index];
                number = number % values[index];
                for (int i = 0; i < d; i++)
                    sb.append(keys[index]);
            }
            index++;
        }
        return sb.toString();
    }
}
