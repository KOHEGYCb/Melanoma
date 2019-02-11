package by.bntu.dmitry.constants;

/**
 *
 * @author dmitry
 */
public class ConfigConstants {

    public static final String DATABASE_SOURCE = "java:/comp/env/jdbc/melanoma";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/melanoma?useSSL=false";
    
    public static String DATABASE_USERNAME;
    public static String DATABASE_PASSWORD;
    
    public static String IMAGE_FOLDER;
    public static String IMAGE_OUTPUT_FOLDER;
    public static String SERIAL_FOLDER;
    
    public static String SETTINGS_LANG;

    static {
        switch (DeviceType.DEVICE_TYPE) {
            case 0:
                DATABASE_USERNAME = "udsmm";
                DATABASE_PASSWORD = "Ai7Pee";
                
                IMAGE_FOLDER = "/opt/tomcat/apache-tomcat/webapps/melanoma/images/dir/";
                IMAGE_OUTPUT_FOLDER = "/opt/tomcat/apache-tomcat/webapps/melanoma/images_out/dir/";
                SERIAL_FOLDER = "C:/Users/user/Documents/NetBeansProjects/Melanoma/serial";
                
                SETTINGS_LANG = "";
                break;
            case 1:
//                DATABASE_USERNAME = "dmitry";
//                DATABASE_PASSWORD = "154789";

//                IMAGE_FOLDER = "C:/Users/user/Documents/NetBeansProjects/Melanoma/web/src/main/webapp/images/dir/";
//                IMAGE_OUTPUT_FOLDER = "";
//                SERIAL_FOLDER = "C:/Users/user/Documents/NetBeansProjects/Melanoma/serial";
                
                SETTINGS_LANG = "";
                break;
            case 2:
                DATABASE_USERNAME = "dmitry";
                DATABASE_PASSWORD = "154789";

                IMAGE_FOLDER = "C:/Users/user/Documents/NetBeansProjects/Melanoma/web/src/main/webapp/images/dir/";
                IMAGE_OUTPUT_FOLDER = "C:/Users/user/Documents/NetBeansProjects/Melanoma/web/src/main/webapp/images_out/dir/";
                SERIAL_FOLDER = "C:/Users/user/Documents/NetBeansProjects/Melanoma/serial";
                
                SETTINGS_LANG = "C:/Users/user/Documents/NetBeansProjects/Melanoma/settings/lang.set";
                break;
        }
    }
}
