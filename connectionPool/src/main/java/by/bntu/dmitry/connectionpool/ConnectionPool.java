package by.bntu.dmitry.connectionpool;

import by.bntu.dmitry.constants.ConfigConstants;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmitry
 */
public enum ConnectionPool {
    INSTANCE;

    private Connection connection;

    private Connection init(){
        try {
            DriverManager.registerDriver(new Driver());

            connection = DriverManager.getConnection(
                    ConfigConstants.DATABASE_URL,
                    ConfigConstants.DATABASE_USERNAME,
                    ConfigConstants.DATABASE_PASSWORD
            );

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public Connection getConnection() throws SQLException {
        return init();
    }
}
