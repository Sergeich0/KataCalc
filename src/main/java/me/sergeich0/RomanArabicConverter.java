package me.sergeich0;

// Original: http://www.cyberforum.ru/java-j2se/thread277297.html
public class RomanArabicConverter {

    private static int[] numbers = {
            1000, 900, 500, 400, 100, 90,
            50, 40, 10, 9, 5, 4, 1
    };
    private static String[] letters = {
            "M", "CM", "D", "CD", "C", "XC",
            "L", "XL", "X", "IX", "V", "IV", "I"
    };

    public static String convertArabicRoman(int arabic) {
        String roman = "";  // The roman numeral.
        //   to be converted to Roman numeral representation.
        for (int i = 0; i < numbers.length; i++) {
            while (arabic >= numbers[i]) {
                roman += letters[i];
                arabic -= numbers[i];
            }
        }
        return roman;
    }

    public static int convertRomanArabic(String roman) {
        if (roman.length() == 0)
            throw new NumberFormatException("An empty string does not define a Roman numeral.");
        roman = roman.toUpperCase();  // Convert to upper case letters.

        int i = 0;       // A position in the string, roman;
        int arabic = 0;  // Arabic numeral equivalent of the part of the string that has
        //    been converted so far.
        while (i < roman.length()) {

            char letter = roman.charAt(i);        // Letter at current position in string.
            int number = letterToNumber(letter);  // Numerical equivalent of letter.

            if (number < 0)
                throw new NumberFormatException("Illegal character \"" + letter + "\" in roman numeral.");

            i++;  // Move on to next position in the string

            if (i == roman.length()) {
                // There is no letter in the string following the one we have just processed.
                // So just add the number corresponding to the single letter to arabic.
                arabic += number;
            }
            else {
                // Look at the next letter in the string.  If it has a larger Roman numeral
                // equivalent than number, then the two letters are counted together as
                // a Roman numeral with value (nextNumber - number).
                int nextNumber = letterToNumber(roman.charAt(i));
                if (nextNumber > number) {
                    // Combine the two letters to get one value, and move on to next position in string.
                    arabic += (nextNumber - number);
                    i++;
                }
                else {
                    // Don't combine the letters.  Just add the value of the one letter onto the number.
                    arabic += number;
                }
            }

        }  // end while
        return arabic;
    }

    private static int letterToNumber(char letter) {
        // Find the integer value of letter considered as a Roman numeral.  Return
        // -1 if letter is not a legal Roman numeral.  The letter must be upper case.
        switch (letter) {
            case 'I':  return 1;
            case 'V':  return 5;
            case 'X':  return 10;
            default:   return -1;
        }
    }
}
