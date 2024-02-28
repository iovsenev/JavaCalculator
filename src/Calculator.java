class Calculator {
    int num1;
    int num2;

    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int add() {
        return num1 + num2;
    }

    public int subtraction() {
        return num1 - num2;
    }

    public int multiplication() {
        return num1 * num2;
    }

    public int division() throws Exception {
        if (num2 == 0)
            throw new Exception("На ноль делить нельзя!");
        return num1 / num2;
    }
}
