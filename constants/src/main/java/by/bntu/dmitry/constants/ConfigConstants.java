package by.bntu.dmitry.constants;

/**
 *
 * @author dmitry
 */
public class ConfigConstants {
    public static final String DATABASE_SOURCE = "java:/comp/env/jdbc/melanoma";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/melanoma?useSSL=false";
    
    /*
        User DB constants
    */
    
    //work PC
    public static final String DATABASE_USERNAME = "dmitry";
    public static final String DATABASE_PASSWORD = "154789";
    
    //notebook
    
    //server
//    public static final String DATABASE_USERNAME = "udsmm";
//    public static final String DATABASE_PASSWORD = "Ai7Pee";
    
    /*
        Folders and Paths
    */
    
    //work PC
    public static final String IMAGE_FOLDER = "C:/Users/user/Documents/NetBeansProjects/Melanoma/web/src/main/webapp/images/dir/";
    public static final String IMAGE_OUTPUT_FOLDER = "";
    public static final String SERIAL_FOLDER = "C:/Users/user/Documents/NetBeansProjects/Melanoma/serial";
    
    //notebook
    
    //server
//    public static final String IMAGE_FOLDER = "/opt/tomcat/apache-tomcat/webapps/melanoma/images/dir/";
//    public static final String IMAGE_OUTPUT_FOLDER = "/opt/tomcat/apache-tomcat/webapps/melanoma/images_out/dir/";    
}