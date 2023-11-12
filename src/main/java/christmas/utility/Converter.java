package christmas.utility;



public class Converter {


    public static Integer convertToNumber(String userInput, String exceptionMessage) {
        checkNumber(userInput, exceptionMessage);
        return Integer.parseInt(userInput);
    }

    private static void checkNumber(String userInput, String exceptionMessage) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
