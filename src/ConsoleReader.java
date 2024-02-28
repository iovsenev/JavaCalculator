import java.util.Scanner;

class ConsoleReader {
    String[] operands = {"+", "-", "*", "/"};
    String operand = null;
    ConverterRoman romanianNumber = new ConverterRoman();
    boolean isRomain = false;

    public void run() throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите выражение которое надо посчитать:");
        String input = in.nextLine();

        System.out.printf(getResult(chackCorrectEnter(input)));
    }

    int[] chackCorrectEnter(String input) throws Exception {

        String[] numbers = input.split("[+\\-*/]");
        if (numbers.length != 2)
            throw new Exception("Не верный формат выражения: " +
                    "должно быть 2 числа.");

        for (var operand : operands) {
            if (input.contains(operand)) {
                this.operand = operand;
                break;
            }
        }
        return convertToArrayInt(numbers);
    }

    int[] convertToArrayInt(String[] numbers) throws Exception {
        int[] result = new int[2];

        if (romanianNumber.isRomain(numbers[0]) !=
                romanianNumber.isRomain(numbers[1]))
            throw new Exception("Не верный формат выражения: " +
                    "необходимо использовать только однотипные числа!");
        for (int i = 0; i < 2; i++) {
            result[i] = convertToNumber(numbers[i]);
        }
        return result;
    }

    int convertToNumber(String number) throws Exception {
        int num;
        if (romanianNumber.isRomain(number)) {
            num = romanianNumber.convertToInt(number);
            isRomain = true;
        } else {
            try {
                num = Integer.parseInt(number);
                isRomain = false;
            } catch (Exception ex) {
                throw new Exception("Не верный формат выражения: " +
                        "ввод не является числом");
            }
        }
        return num;
    }

    int calculate(int[] numbers) throws Exception {
        if (numbers[1] < 1 || numbers[1] > 10 || numbers[0] < 1 || numbers[0] > 10)
            throw new Exception("числа должны быть от 1 до 10");

        Calculator calc = new Calculator(numbers[0], numbers[1]);

        return switch (operand) {
            case "+" -> calc.add();
            case "-" -> calc.subtraction();
            case "*" -> calc.multiplication();
            case "/" -> calc.division();
            default -> throw new Exception("Не возможно посчитать!");
        };
    }

    String getResult(int[] numbers) throws Exception {
        int result = calculate(numbers);

        if (result == 0)
            return "0";

        if (isRomain) {
            if (result < 0)
                throw new Exception("Римские цифры не могут быть меньше нуля!");
            return romanianNumber.convertToRomain(result);
        } else {
            return String.valueOf(result);
        }
    }
}
