import java.util.Scanner;

class ConsoleReader {
    String[] operands = {"+", "-", "*", "/"};
    String[] actionOperands = {"\\+", "-", "\\*", "/"};
    int actionIndex = -1;
    ConverterRoman romanianNumber = new ConverterRoman();
    boolean isRomain = false;
    public void run() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите выражение которое надо посчитать");
        String input = in.nextLine();
        int[] numbers = checkOperatorAvailability(input);

        if (numbers[1]<1||numbers[1]>10||numbers[0]<1||numbers[0]>10)
            throw new Exception("числа должны быть от 1 до 10");
        int result = calculate(numbers);
        if (result == 0) {
            System.out.println("Ответ: 0");
            return;
        }

        if (isRomain){
            if(result < 0)
                throw new Exception("Римские цифры не могут быть меньше нуля!");
            System.out.printf("Ответ: %s", romanianNumber.convertToRomain(result));
        }

    }
    int[] checkOperatorAvailability(String input) throws Exception {
        for (int i=0; i<operands.length; i++){
            if (input.contains(operands[i])){
                actionIndex = i;
                break;
            }
        }
        if (actionIndex == -1) {
            throw new Exception("Не верный формат выражения: " +
                    "не верный оператор можно использовать (+, -, *, /)");
        }
        String[] numbers = input.split(actionOperands[actionIndex]);
        if (numbers.length != 2)
            throw  new Exception("Не верный формат выражения: " +
                    "должно быть 2 числа.");
        return checkToCorrectInput(numbers);
    }

    int[] checkToCorrectInput(String[] numbers) throws Exception{
        int[] result = new int[2];
        if (romanianNumber.isRomain(numbers[0]) !=
                romanianNumber.isRomain(numbers[1]))
            throw new Exception("Не верный формат выражения: " +
                    "необходимо использовать только однотипные числа!");
        for (int i = 0; i< 2; i++){
            result[i] = checkToNumbers(numbers[i]);
        }
        return result;
    }

    int checkToNumbers(String number)throws Exception{
        int num;
        if ( romanianNumber.isRomain(number)){
        num = romanianNumber.convertToInt(number);
        isRomain = true;
        }else {
            try {
                num = Integer.parseInt(number);
                isRomain = false;
            }
            catch (Exception ex){
                throw  new Exception("Не верный формат выражения: " +
                        "ввод не является числом");
            }
        }
        return num;
    }

    int calculate(int[] numbers) throws Exception {
        Calculator calc = new Calculator(numbers[0],numbers[1]);
        switch (operands[actionIndex]){
            case "+":
                return calc.add();
            case "-":
                return calc.subtraction();
            case "*":
                return calc.multiplication();
            case"/":
                return calc.division();
            default:
                throw new Exception("Не возможно посчитать!");
        }
    }
}
