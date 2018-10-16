package by.bntu.dmitry.dao;

import by.bntu.dmitry.connectionpool.ConnectionPool;
import by.bntu.dmitry.constants.SQLColumns;
import by.bntu.dmitry.constants.SQLRequests;
import by.bntu.dmitry.entities.Pacient;
import by.bntu.dmitry.entities.User;
import by.bntu.dmitry.enums.Role;
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
public enum UserDAO implements AbstractDAO<User> {

    INSTANCE;

    @Override
    public ArrayList<User> findAll() {
        ArrayList<User> users = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.GET_ALL_USERS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(SQLColumns.USER_ID));
                user.setLogin(resultSet.getString(SQLColumns.USER_LOGIN));
                user.setPassword(resultSet.getString(SQLColumns.USER_PASSWORD));
                user.setRole(resultSet.getInt(SQLColumns.USER_ROLE));
                user.setActive(resultSet.getInt(SQLColumns.USER_ACTIVE));
                user.setAuthorizate(resultSet.getInt(SQLColumns.USER_AUTHORIZE));
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement, resultSet);
        }
        return users;
    }

    @Override
    public User getEntityById(int id) {
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.GET_USER_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(SQLColumns.USER_ID));
                user.setLogin(resultSet.getString(SQLColumns.USER_LOGIN));
                user.setPassword(resultSet.getString(SQLColumns.USER_PASSWORD));
                user.setRole(resultSet.getInt(SQLColumns.USER_ROLE));
                user.setActive(resultSet.getInt(SQLColumns.USER_ACTIVE));
                user.setAuthorizate(resultSet.getInt(SQLColumns.USER_AUTHORIZE));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement, resultSet);
        }
        return user;
    }

    public User getEntityByLogin(String login) {
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.GET_USER_BY_LOGIN);
            statement.setString(1, login);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(SQLColumns.USER_ID));
                user.setLogin(resultSet.getString(SQLColumns.USER_LOGIN));
                user.setPassword(resultSet.getString(SQLColumns.USER_PASSWORD));
                user.setRole(resultSet.getInt(SQLColumns.USER_ROLE));
                user.setActive(resultSet.getInt(SQLColumns.USER_ACTIVE));
                user.setAuthorizate(resultSet.getInt(SQLColumns.USER_AUTHORIZE));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement, resultSet);
        }
        return user;
    }

    public ArrayList<User> getEntitiesByDoctor (User user) {
        ArrayList<User> docPacients = new ArrayList<>();
        if (user.getRole() == Role.DOCTOR){
            ArrayList<Pacient> pacients = PacientDAO.INSTANCE.findAll();
            for (int i = 0; i < pacients.size(); i++){
                if (pacients.get(i).getDoctor().getId() == user.getId()){
                    docPacients.add(pacients.get(i).getPacient());
                }
            }
        }
        return docPacients;
    }
    
    public ArrayList<User> getEntitiesWithoutDoctor () {
        ArrayList<User> users = UserDAO.INSTANCE.findAll();
        for (int i = 0; i < users.size(); i++){
            if (PacientDAO.INSTANCE.GetPacientByUser(users.get(i)) != null)
        }
        
        return users;
    }
    
    @Override
    public void createEntity(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.CREATE_USER);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole().getId());
            statement.setInt(4, user.getActive());
            statement.setInt(5, user.getAuthorizate());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement);
        }
    }

    @Override
    public void updateEntity(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.UPDATE_USER);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole().getId());
            statement.setInt(4, user.getActive());
            statement.setInt(5, user.getAuthorizate());
            statement.setInt(6, user.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement);
        }
    }

    @Override
    public void deleteEntity(User user) {
        user.setActive(false);
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.UPDATE_USER);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole().getId());
            statement.setInt(4, user.getActive());
            statement.setInt(5, user.getAuthorizate());
            statement.setInt(6, user.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement);
        }
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
}
