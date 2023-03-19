package me.sergeich0;

public class ExpressionContainer {
    private final int firstNumber;
    private final int secondNumber;
    private final Action action;
    private final boolean roman;

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public Action getAction() {
        return action;
    }

    public boolean isRoman() {
        return roman;
    }

    public ExpressionContainer(int firstNumber, int secondNumber, Action action, boolean roman) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.action = action;
        this.roman = roman;
    }
}
