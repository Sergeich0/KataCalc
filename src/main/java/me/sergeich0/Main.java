package me.sergeich0;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter expression and hit Enter: ");
        String inputString = scanner.nextLine();

        ExpressionContainer container = ExpressionParser.parse(inputString);

        ExpressionCalculator calculator = new ExpressionCalculator();
        System.out.println("Result is: " + calculator.calculate(container));
    }
}