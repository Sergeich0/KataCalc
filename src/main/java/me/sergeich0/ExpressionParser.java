package me.sergeich0;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParser {
    public static ExpressionContainer parse(String inputString) throws Exception {

        Pattern[] patterns = new Pattern[]{
                Pattern.compile("\\A([1-9]|10)\\b ?([-+*/]) ?\\b([1-9]|10)\\Z"),
                Pattern.compile("\\A(v?i{1,3}|i?[vx])\\b ?([-+*/]) ?\\b(v?i{1,3}|i?[vx])\\Z", Pattern.CASE_INSENSITIVE)
        };
        int first, second;
        Action action;
        boolean isRoman = false;
        for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(inputString);
            if (matcher.find()) {
                first = parseNumber(matcher.group(1));
                action = Action.fromString(matcher.group(2));
                second = parseNumber(matcher.group(3));
                return new ExpressionContainer(first, second, action, isRoman);
            }
            isRoman = true;
        }
        throw new Exception("Expression can contain only two arabian or roman numbers from 1 to 10 separated by simple operators: +, -, *, /.");
    }

    private static int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (java.lang.NumberFormatException e) {
            return RomanArabicConverter.convertRomanArabic(number);
        }
    }
}
