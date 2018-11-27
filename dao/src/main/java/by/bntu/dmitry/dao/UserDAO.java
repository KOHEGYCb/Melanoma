package by.bntu.dmitry.dao;

import by.bntu.dmitry.connectionpool.ConnectionPool;
import by.bntu.dmitry.constants.SQLColumns;
import by.bntu.dmitry.constants.SQLRequests;
import by.bntu.dmitry.entities.Pacient;
import by.bntu.dmitry.entities.User;
import by.bntu.dmitry.enums.Role;
import by.bntu.dmitry.secure.Aes256Class;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;

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
                users.add(getUser(resultSet));
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
                user = getUser(resultSet);
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
        Aes256Class ac = new Aes256Class();
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.GET_USER_BY_LOGIN);
            statement.setString(1, new String(ac.makeAes(login.getBytes(), Cipher.ENCRYPT_MODE)));
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = getUser(resultSet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement, resultSet);
        }
        return user;
    }

    public ArrayList<User> getEntitiesByDoctor(User user) {
        ArrayList<User> docPacients = new ArrayList<>();
        if (user.getRole() == Role.DOCTOR) {
            ArrayList<Pacient> pacients = PacientDAO.INSTANCE.findAll();
            for (int i = 0; i < pacients.size(); i++) {
                if (pacients.get(i).getDoctor().getId() == user.getId()) {
                    docPacients.add(pacients.get(i).getPacient());
                }
            }
        }
        return docPacients;
    }

    public ArrayList<User> getAllPacients() {
        ArrayList<User> users = UserDAO.INSTANCE.findAll();
        ArrayList<User> pacients = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getRole() == Role.USER) {
                pacients.add(users.get(i));
            }
        }
        return pacients;
    }

    public ArrayList<User> getEntitiesWithoutDoctor() {
        ArrayList<User> users = UserDAO.INSTANCE.findAll();
        ArrayList<User> noPacient = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if (PacientDAO.INSTANCE.GetPacientByUser(users.get(i)) == null) {
                if (users.get(i).getRole() == Role.USER) {
                    noPacient.add(users.get(i));
                }
            }
        }
        return noPacient;
    }

    public int getAmountFakeUserByDoctor(User doctor) {
        int amount = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.GET_AMOUNT_FAKE_USER_BY_DOCTOR);
            statement.setString(1, "-" + doctor.getId());
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                amount = resultSet.getInt(SQLColumns.AMOUNT);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement, resultSet);
        }
        return amount;
    }

    public User getFakeUser(User user) {
        User user_ = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.GET_FAKE_USER);
            System.out.println("Login" + user.getLogin());
            System.out.println("Password" + user.getPassword());
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user_ = getUser(resultSet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement, resultSet);
        }
        return user_;
    }
    
    @Override
    public void createEntity(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        Aes256Class ac = new Aes256Class();
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.CREATE_USER);
            statement.setString(1, new String(ac.makeAes(user.getLogin().getBytes(), Cipher.ENCRYPT_MODE)));
            statement.setString(2, new String(ac.makeAes(user.getPassword().getBytes(), Cipher.ENCRYPT_MODE)));
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
        Aes256Class ac = new Aes256Class();
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.UPDATE_USER);
            statement.setString(1, new String(ac.makeAes(user.getLogin().getBytes(), Cipher.ENCRYPT_MODE)));
            statement.setString(2, new String(ac.makeAes(user.getPassword().getBytes(), Cipher.ENCRYPT_MODE)));
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
        Aes256Class ac = new Aes256Class();
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.UPDATE_USER);
            statement.setString(1, new String(ac.makeAes(user.getLogin().getBytes(), Cipher.ENCRYPT_MODE)));
            statement.setString(2, new String(ac.makeAes(user.getPassword().getBytes(), Cipher.ENCRYPT_MODE)));
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

    private User getUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        Aes256Class ac = new Aes256Class();
        user.setId(resultSet.getInt(SQLColumns.USER_ID));
        user.setLogin(new String(ac.makeAes(resultSet.getString(SQLColumns.USER_LOGIN).getBytes(), Cipher.DECRYPT_MODE)));
        user.setPassword(new String(ac.makeAes(resultSet.getString(SQLColumns.USER_PASSWORD).getBytes(), Cipher.DECRYPT_MODE)));
        user.setRole(resultSet.getInt(SQLColumns.USER_ROLE));
        user.setActive(resultSet.getInt(SQLColumns.USER_ACTIVE));
        user.setAuthorizate(resultSet.getInt(SQLColumns.USER_AUTHORIZE));

        return user;
    }
}
