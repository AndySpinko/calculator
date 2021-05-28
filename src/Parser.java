import java.util.InputMismatchException;

public class Parser {

    private static int num1, num2;
    private static int operation;
    int result;

    public String pars1(String s){
        String n1 = s.split(" ")[0].trim();
        return n1;
    }

    public String pars2(String s){
        String n2 = s.split(" ")[2].trim();
        return n2;
    }

    public char parsSign(String s){
        String sign = s.split(" ")[1].trim();
        switch (sign){
            case "+" :
                return 1;
            case "-":
                return 2;
            case "*":
                return 3;
            case "/":
                return 4;
            default:
                return 0;
        }
    }
    //метод переводит строку в число
    public int convert (String str){
        int i = 0;
        if (str.matches("-?\\d+(\\.\\d+)?")){
            i = Integer.parseInt(str);
            return i;
        }else if (str.matches("[IVX]+")){
            i = romanToArabic(str);
            return i;
        }else {
            System.out.println("Wrong format");
            return 0;
        }
    }

    public void match(String str){
            if (pars1(str).matches("-?\\d+(\\.\\d+)?") && pars2(str).matches("-?\\d+(\\.\\d+)?")){
                num1 = convert(pars1(str));
                num2 = convert(pars2(str));
                operation = parsSign(str);
                result = calc(num1, num2, operation);
                System.out.println(result);
            }
            else if (pars1(str).matches("[IVXLCDM]+") && pars2(str).matches("[IVXLCDM]+")) {
                num1 = convert(pars1(str));
                num2 = convert(pars2(str));
                operation = parsSign(str);
                result = calc(num1, num2, operation);
                String res = convertNumToRoman(result);
                System.out.println(res);
            }
            else {
                throw new IllegalArgumentException ("используйте в выражении либо только римские, либо только арабские цифры");
            }
    }

    public int calc(int num1, int num2, int operation){
        if (num1 > 0 && num1 <= 10 && num2 > 0 && num2 <= 10) {
            switch (operation) {
                case 1:
                    result = num1 + num2;
                    break;
                case 2:
                    result = num1 - num2;
                    break;
                case 3:
                    result = num1 * num2;
                    break;
                case 4:
                    result = num1 / num2;
                    break;
                default:
                    throw new IllegalArgumentException("Неверный знак операции");
                    }
        } else {
            System.out.println("используйте числа от 1 до 10 включительно");
        }
        return result;
    }

    public int romanToArabic (String str){
        try{
            switch (str){
                case "I":
                    return 1;
                case "II":
                    return 2;
                case "III":
                    return 3;
                case "IV":
                    return 4;
                case "V":
                    return 5;
                case "VI":
                    return 6;
                case "VII":
                    return 7;
                case "VIII":
                    return 8;
                case "IX":
                    return 9;
                case "X":
                    return 10;
            }
        }catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }

    private static String convertNumToRoman (int numArabic) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        String s = roman[numArabic];
        return s;
    }
}