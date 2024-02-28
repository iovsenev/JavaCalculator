import java.util.*;

class ConverterRoman {
    Map <String,Integer> romans = new TreeMap<>();
    public ConverterRoman(){
        romans.put("I", 1);
        romans.put("V", 5);
        romans.put("X", 10);
        romans.put("L", 50);
        romans.put("C", 100);
        romans.put("D", 500);
        romans.put("M", 1000);
    }

    public boolean isRomain (String string){
        String ch = String.valueOf(string.charAt(0));
        return romans.containsKey(ch);
    }

    public int convertToInt (String string) throws Exception {
        var charArr = string.toCharArray();
        int convertedNumber = 0;
        for(int i=0; i< charArr.length; i++){
            String ch = String.valueOf(charArr[i]);
            if (!romans.containsKey(ch))
                throw new Exception("Не верный формат выражения: " +
                        "одно из чисел не является числом");
            convertedNumber += romans.get(ch);
        }
        return convertedNumber;
    }

    public String convertToRomain(int number){

        return null;
    }
}
