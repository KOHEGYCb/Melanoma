package by.bntu.dmitry.dao;

import by.bntu.dmitry.connectionpool.ConnectionPool;
import by.bntu.dmitry.constants.SQLColumns;
import by.bntu.dmitry.constants.SQLRequests;
import by.bntu.dmitry.entities.Pacient;
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
public enum PacientDAO implements AbstractDAO<Pacient> {

    INSTANCE;

    @Override
    public ArrayList<Pacient> findAll() {
        ArrayList<Pacient> pacients = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.GET_ALL_PACIENTS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                pacients.add(getPacient(resultSet));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement, resultSet);
        }
        return pacients;
    }

    @Override
    public Pacient getEntityById(int id) {
        Pacient pacient = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.GET_PACIENT_BY_ID);
            statement.setInt(0, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                pacient = getPacient(resultSet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement, resultSet);
        }
        return pacient;
    }

    public Pacient GetPacientByUser(User user) {    //возврвщает пользователей-пациентов
        Pacient pacient = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.GET_ALL_PACIENTS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                pacient = getPacient(resultSet);
                if (pacient.getPacient().equals(user)) {
                    return pacient;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement, resultSet);
        }
        return pacient;
    }

    @Override
    public void createEntity(Pacient pacient) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.CREATE_PACIENT);
            statement.setInt(1, pacient.getPacient().getId());
            statement.setInt(2, pacient.getDoctor().getId());
            statement.setInt(3, pacient.getDirectionHistology());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement);
        }
    }

    @Override
    public void updateEntity(Pacient pacient) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.UPDATE_PACIENT);
            statement.setInt(1, pacient.getPacient().getId());
            statement.setInt(2, pacient.getDoctor().getId());
            statement.setInt(3, pacient.getDirectionHistology());
            statement.setInt(4, pacient.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement);
        }
    }

    @Override
    public void deleteEntity(Pacient t) {
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

    private Pacient getPacient(ResultSet resultSet) throws SQLException {
        Pacient pacient = new Pacient();
        
        pacient.setId(resultSet.getInt(SQLColumns.PACIENT_ID));
        pacient.setPacient(UserDAO.INSTANCE.getEntityById(resultSet.getInt(SQLColumns.PACIENT_ID_PACIENT)));
        pacient.setDoctor(UserDAO.INSTANCE.getEntityById(resultSet.getInt(SQLColumns.PACIENT_ID_DOCTOR)));
        pacient.setDirectionHistology(resultSet.getInt(SQLColumns.PACIENT_DIRECTION_HISTOLOGY));
        
        return pacient;
    }

}
