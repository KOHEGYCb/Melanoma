package charsets;

/**
 *
 * @author dmitry
 */
public class CyrillicMethods {

    public static String setToCyrillic (String str) {
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            if (((int) str.charAt(i) >= 65) && ((int) str.charAt(i) <= 90) || ((int) str.charAt(i) >= 97) && ((int) str.charAt(i) <= 122)) {
                newStr = newStr + str.charAt(i);
            } else {
                if ((int) str.charAt(i) == 208) {
                    int ch = (int) str.charAt(i + 1) + 896;
                    newStr = newStr + (char) ch;
                }
                if ((int) str.charAt(i) == 209) {
                    int ch = (int) str.charAt(i + 1) + 960;
                    newStr = newStr + (char) ch;
                }
            }
        }
        return newStr;
    }
        
}
