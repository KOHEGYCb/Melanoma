package by.bntu.dmitry.dao;

import by.bntu.dmitry.connectionpool.ConnectionPool;
import by.bntu.dmitry.constants.SQLColumns;
import by.bntu.dmitry.constants.SQLRequests;
import by.bntu.dmitry.entities.User;
import by.bntu.dmitry.entities.UserForm;
//import by.bntu.dmitry.secure.Aes256Class;
//import by.bntu.dmitry.secure.Aes256Class;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.crypto.Cipher;

/**
 *
 * @author dmitry
 */
public enum UserFormDAO implements AbstractDAO<UserForm> {

    INSTANCE;

    @Override
    public ArrayList<UserForm> findAll() {
        ArrayList<UserForm> userForms = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.GET_ALL_USER_FORMS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                userForms.add(getUserForm(resultSet));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement, resultSet);
        }
        return userForms;
    }

    @Override
    public UserForm getEntityById(int id) {
        UserForm userForm = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.GET_USER_FORM_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                userForm = getUserForm(resultSet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement, resultSet);
        }
        return userForm;
    }

    public UserForm getEntityByUser(User user) {
        UserForm userForm = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.GET_USER_FORM_BY_USER);
            statement.setInt(1, user.getId());
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                userForm = getUserForm(resultSet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement, resultSet);
        }
        return userForm;
    }

    @Override
    public void createEntity(UserForm userForm) {
        Connection connection = null;
        PreparedStatement statement = null;
//        Aes256Class ac = new Aes256Class();
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.CREATE_USER_FORM);
            statement.setInt(1, userForm.getUser().getId());
//            statement.setString(2, new String(ac.makeAes(userForm.getName().getBytes(), Cipher.ENCRYPT_MODE)));
//            statement.setString(3, new String(ac.makeAes(userForm.getSurname().getBytes(), Cipher.ENCRYPT_MODE)));
//            statement.setString(4, new String(ac.makeAes(userForm.getPatronymic().getBytes(), Cipher.ENCRYPT_MODE)));
            statement.setString(2, userForm.getName());
            statement.setString(3, userForm.getSurname());
            statement.setString(4, userForm.getPatronymic());
            statement.setDate(5, userForm.getBirthday());
            statement.setInt(6, userForm.getSex().getId());
            statement.setInt(7, userForm.getRelativeMelanoma());
            statement.setInt(8, userForm.getAnamnesisMelanoma());
            statement.setInt(9, userForm.getDyspasticNevusSyndrome());
            statement.setInt(10, userForm.getDyspasticNevusSyndromeRelatives());
            statement.setInt(11, userForm.getImmunosuppressiveTherapy());
            statement.setInt(12, userForm.getPresenceUlceration());
            statement.setString(13, userForm.getHospital());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement);
        }
    }

    public void createStartEntity(UserForm userForm) {
        Connection connection = null;
        PreparedStatement statement = null;
//        Aes256Class ac = new Aes256Class();
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.CREATE_START_USER_FORM);
            statement.setInt(1, userForm.getUser().getId());
//            statement.setString(2, new String(ac.makeAes(userForm.getName().getBytes(), Cipher.ENCRYPT_MODE)));
//            statement.setString(3, new String(ac.makeAes(userForm.getSurname().getBytes(), Cipher.ENCRYPT_MODE)));
//            statement.setString(4, new String(ac.makeAes(userForm.getPatronymic().getBytes(), Cipher.ENCRYPT_MODE)));
            statement.setString(2, userForm.getName());
            statement.setString(3, userForm.getSurname());
            statement.setString(4, userForm.getPatronymic());
            statement.setDate(5, userForm.getBirthday());
            statement.setInt(6, userForm.getSex().getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement);
        }
    }

    @Override
    public void updateEntity(UserForm userForm) {
        Connection connection = null;
        PreparedStatement statement = null;
//        Aes256Class ac = new Aes256Class();
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.UPDATE_USER_FORM);
            statement.setInt(1, userForm.getUser().getId());
//            statement.setString(2, new String(ac.makeAes(userForm.getName().getBytes(), Cipher.ENCRYPT_MODE)));
//            statement.setString(3, new String(ac.makeAes(userForm.getSurname().getBytes(), Cipher.ENCRYPT_MODE)));
//            statement.setString(4, new String(ac.makeAes(userForm.getPatronymic().getBytes(), Cipher.ENCRYPT_MODE)));
            statement.setString(2, userForm.getName());
            statement.setString(3, userForm.getSurname());
            statement.setString(4, userForm.getPatronymic());
            statement.setDate(5, userForm.getBirthday());
            statement.setInt(6, userForm.getSex().getId());
            statement.setInt(7, userForm.getRelativeMelanoma());
            statement.setInt(8, userForm.getAnamnesisMelanoma());
            statement.setInt(9, userForm.getDyspasticNevusSyndrome());
            statement.setInt(10, userForm.getDyspasticNevusSyndromeRelatives());
            statement.setInt(11, userForm.getImmunosuppressiveTherapy());
            statement.setInt(12, userForm.getPresenceUlceration());
            statement.setString(13, userForm.getHospital());
            statement.setInt(14, userForm.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement);
        }
    }

    @Override
    public void deleteEntity(UserForm t) {
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

    private UserForm getUserForm(ResultSet resultSet) throws SQLException {
//        Aes256Class ac = new Aes256Class();
        UserForm userForm = new UserForm();
        userForm.setId(resultSet.getInt(SQLColumns.USER_FORM_ID));
        userForm.setUser(UserDAO.INSTANCE.getEntityById(resultSet.getInt(SQLColumns.USER_FORM_USER_ID)));
//        userForm.setName(new String(ac.makeAes(resultSet.getString(SQLColumns.USER_FORM_NAME).getBytes(), Cipher.DECRYPT_MODE)));
//        userForm.setSurname(new String(ac.makeAes(resultSet.getString(SQLColumns.USER_FORM_SURNAME).getBytes(), Cipher.DECRYPT_MODE)));
//        userForm.setPatronymic(new String(ac.makeAes(resultSet.getString(SQLColumns.USER_FORM_PATRONYMIC).getBytes(), Cipher.DECRYPT_MODE)));
        userForm.setName(resultSet.getString(SQLColumns.USER_FORM_NAME));
        userForm.setSurname(resultSet.getString(SQLColumns.USER_FORM_SURNAME));
        userForm.setPatronymic(resultSet.getString(SQLColumns.USER_FORM_PATRONYMIC));
        userForm.setBirthday(resultSet.getDate(SQLColumns.USER_FORM_BIRTHDAY));
        userForm.setSex(resultSet.getInt(SQLColumns.USER_FORM_SEX));
        userForm.setRelativeMelanoma(resultSet.getInt(SQLColumns.USER_FORM_RELATIVE_MELANOMA));
        userForm.setAnamnesisMelanoma(resultSet.getInt(SQLColumns.USER_FORM_ANAMNESIS_MELANOMA));
        userForm.setDyspasticNevusSyndrome(resultSet.getInt(SQLColumns.USER_FORM_DYSPASTIC_NEVUS_SYNDROME));
        userForm.setDyspasticNevusSyndromeRelatives(resultSet.getInt(SQLColumns.USER_FORM_DYSPASTIC_NEVUS_SYNDROME_RELATIVES));
        userForm.setImmunosuppressiveTherapy(resultSet.getInt(SQLColumns.USER_FORM_IMMUNOSUPPRESSIVE_THERAPY));
        userForm.setPresenceUlceration(resultSet.getInt(SQLColumns.USER_FORM_PRESENCE_ULCERATION));
        userForm.setHospital(resultSet.getString(SQLColumns.USER_FORM_HOSPITAL));
        return userForm;
    }

}
