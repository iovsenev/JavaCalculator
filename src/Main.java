// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        var reader = new ConsoleReader();
        System.out.println("""
                Приветствуем в калькуляторе!
                Калькулятор считает только целые арабские цифры и римские.
                Числа должны быть в от 1 до 10 включительно.
                В одном выражении могут быть только цифры одного типа!
                Операторы которые могут быть использованы: +, -, *, /.

                """
        );
        reader.run();
    }
}
