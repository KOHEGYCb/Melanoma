package by.bntu.dmitry.services.charsets;

/**
 *
 * @author dmitry
 */
public class WorkWithStrings {

    public static String setUpperFirstLeter(String str) {
        if (Character.isLowerCase(str.charAt(0))) {
            str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
        }
        return str;
    }
    
}
