package by.bntu.dmitry.services.logsServices;

/**
 *
 * @author user
 */
public class Test {
    public static void main(String[] args) {
        
        String qwerty = "abcdefghijklmnopqrstuvwxyz";
        String QWERTY = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String rusQwerty = "абвгдеёжзийклмнопрстуфхцчшщьыъэюя";
        String rusQWERTY = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЫЪЭЮЯ";
        
        for (int i = 0; i < rusQwerty.length(); i++){
            System.out.println((int)rusQwerty.charAt(i) + " | " + (int)rusQWERTY.charAt(i));
        }
    }
}
