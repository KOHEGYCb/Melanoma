package by.bntu.dmitry.services.settings;

import by.bntu.dmitry.constants.ConfigConstants;
import by.bntu.dmitry.entities.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Lang implements Serializable {

    private static Map <Integer, Integer> LANG = getAll();

    private static void ser() {
        File file = new File(ConfigConstants.SETTINGS_LANG);
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(LANG);
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Lang.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void deser() {
        File file = new File(ConfigConstants.SETTINGS_LANG);
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            LANG = (Map) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Lang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Lang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Map<Integer, Integer> getAll() {
        File file = new File(ConfigConstants.SETTINGS_LANG);
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            LANG = (Map) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Lang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Lang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return LANG;
    }


    public static void addUser(User user, int lang) {
        deser();
        LANG.put(user.getId(), lang);
        ser();
    }

    public static int GetLangAsInt(User user) {
        return LANG.get(user.getId());
    }

    public static String GetLangAsString(User user) {
        deser();
        switch (LANG.get(user.getId())) {
            case 0:
                return "en";
            case 1:
                return "ru";
            default:
                return "en";
        }
    }
}
