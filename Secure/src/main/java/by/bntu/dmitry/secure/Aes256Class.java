package by.bntu.dmitry.secure;

import by.bntu.dmitry.constants.ConfigConstants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author dmitry
 */
public class Aes256Class implements Serializable{

    private SecretKey secretKey;
    
    public Aes256Class(){
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(ConfigConstants.SERIAL_FOLDER));
            this.secretKey = (SecretKey) inputStream.readObject();
//        try{
//            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//            keyGenerator.init(256);
//            
//            this.secretKey = keyGenerator.generateKey();
//            
//            try {
//                File file = new File(ConfigConstants.SERIAL_FOLDER);
//                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
//                oos.writeObject(this.secretKey);
//                oos.close();
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(Aes256Class.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex) {
//                Logger.getLogger(Aes256Class.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(Aes256Class.class.getName()).log(Level.SEVERE, null, ex);
//        }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Aes256Class.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Aes256Class.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public byte[] makeAes(byte[] rawMessage, int cipherMode){
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(cipherMode, this.secretKey);
            byte [] output = cipher.doFinal(rawMessage);
            return output;
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException ex) {
            Logger.getLogger(Aes256Class.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
