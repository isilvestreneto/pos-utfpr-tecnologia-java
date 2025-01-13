package org.example;

/**
 * Hello world!
 */
public class Calculator {
    Integer a;
    Integer b;
    int c;
    Boolean isDivisible;

    Calculator(Integer a, Integer b) {
        if (Integer.valueOf(b) == 0) {
            throw new IllegalArgumentException("Impossível dividir por 0");
        }
        this.a = a;
        this.b = b
        this.isDivisible = Integer.valueOf(a) % Integer.valueOf(b) == 0;
    }

    public String printResult() {
        if (Boolean.TRUE.equals(isDivisible)) return String.format("%s é divisível por %s", this.a, this.b);
        else return String.format("%s não é divisível por %s", this.a, this.b);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator(10, 0);
        System.out.println(calculator.printResult());
    }
}
