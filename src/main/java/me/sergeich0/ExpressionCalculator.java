package me.sergeich0;

public class ExpressionCalculator {
    public String calculate(ExpressionContainer container) throws Exception {
        int calculated = this.calculateInt(container);
        if (!container.isRoman()) {
            return String.valueOf(calculated);
        } else if (calculated > 0){
            return RomanArabicConverter.convertArabicRoman(calculated);
        } else {
            throw new Exception("Result can't be less than 1 in case of roman numbers");
        }
    }


    public int calculateInt(ExpressionContainer container) {
        int first = container.getFirstNumber();
        int second = container.getSecondNumber();
        Action action = container.getAction();
        return switch (action) {
            case SUM -> first + second;
            case SUB -> first - second;
            case DIV -> first / second;
            case MUL -> first * second;
        };
    }
}
