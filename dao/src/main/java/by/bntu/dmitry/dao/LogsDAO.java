package by.bntu.dmitry.dao;

import by.bntu.dmitry.connectionpool.ConnectionPool;
import by.bntu.dmitry.constants.SQLColumns;
import by.bntu.dmitry.constants.SQLRequests;
import by.bntu.dmitry.entities.Logs;
import by.bntu.dmitry.entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmitry
 */
public enum LogsDAO implements AbstractDAO<Logs> {

    INSTANCE;

    @Override
    public ArrayList<Logs> findAll() {
        ArrayList<Logs> logs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.GET_ALL_LOGS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                logs.add(getLog(resultSet));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement, resultSet);
        }
        return logs;
    }

    @Override
    public Logs getEntityById(int id) {
        Logs log = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.GET_LOG_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                log = getLog(resultSet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement, resultSet);
        }
        return log;
    }

    public ArrayList<Logs> getEntityByUser(User user) {
        ArrayList<Logs> logs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.GET_LOG_BY_USER);
            statement.setInt(1, user.getId());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                logs.add(getLog(resultSet));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement, resultSet);
        }
        return logs;
    }

    @Override
    public void createEntity(Logs log) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.CREATE_LOG);
            statement.setString(1, log.getAction());
//            statement.setDate(2, log.getDate());      //дата задается в sql-запросе now()
            statement.setInt(2, log.getUser().getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement);
        }
    }

    @Override
    public void updateEntity(Logs log) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.UPDATE_LOG);
            statement.setString(1, log.getAction());
            statement.setDate(2, log.getDate());
            statement.setInt(3, log.getUser().getId());
            statement.setInt(4, log.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement);
        }
    }

    @Override
    public void deleteEntity(Logs t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void releaseConnection(Connection connection, PreparedStatement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void releaseConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private Logs getLog(ResultSet resultSet) throws SQLException {
        Logs log = new Logs();
        
        log.setId(resultSet.getInt(SQLColumns.LOGS_ID));
        log.setUser(UserDAO.INSTANCE.getEntityById(resultSet.getInt(SQLColumns.LOGS_USER_ID)));
        log.setDate(resultSet.getDate(SQLColumns.LOGS_DATE));
        log.setAction(resultSet.getString(SQLColumns.LOGS_ACTION));
        
        return log;
    }
}
