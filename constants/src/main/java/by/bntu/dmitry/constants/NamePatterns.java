package by.bntu.dmitry.constants;

/**
 *
 * @author dmitry
 */
public class NamePatterns {
    public static final String NAMES = "^([A-Za-zа-яА-Я]{1})([a-zа-я]{1,})"; //regular expression for name/surname/patronymic
    public static final String LOGIN = "^([A-Za-z0-9_]{6,})$"; //regular expression for login
    public static final String PASSWORD = "^([A-Za-z0-9_]{6,})$"; //regular expression for password
}
