package by.bntu.dmitry.dao;

import by.bntu.dmitry.connectionpool.ConnectionPool;
import by.bntu.dmitry.constants.SQLColumns;
import by.bntu.dmitry.constants.SQLRequests;
import by.bntu.dmitry.entities.Foto;
import by.bntu.dmitry.entities.Pacient;
import by.bntu.dmitry.entities.User;
import by.bntu.dmitry.enums.Device;
import by.bntu.dmitry.enums.DiagnosisFinal;
import by.bntu.dmitry.enums.DiagnosisPreliminary;
import by.bntu.dmitry.enums.DurationIllness;
import by.bntu.dmitry.enums.OriginIllness;
import by.bntu.dmitry.enums.TumorForm;
import by.bntu.dmitry.enums.TumorLocalization;
import by.bntu.dmitry.enums.TumorOutline;
import by.bntu.dmitry.enums.TumorSurface;
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
public enum FotoDAO implements AbstractDAO<Foto> {

    INSTANCE;

    @Override
    public ArrayList<Foto> findAll() {
        ArrayList<Foto> fotos = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.GET_ALL_FOTOS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Foto foto = new Foto();
                foto.setId(resultSet.getInt(SQLColumns.FOTO_ID));
                foto.setUser(UserDAO.INSTANCE.getEntityById(resultSet.getInt(SQLColumns.FOTO_USER_ID)));
                foto.setId_tumor(resultSet.getInt(SQLColumns.FOTO_ID_TUMOR));
                foto.setOriginIllness(OriginIllness.setOriginIllness(resultSet.getInt(SQLColumns.FOTO_ORIGIN_ILLNESS)));
                foto.setDurationIllness(DurationIllness.setDurationIllness(resultSet.getInt(SQLColumns.FOTO_DURATION_ILLNESS)));
                foto.setChangeForm(resultSet.getInt(SQLColumns.FOTO_CHANGE_FORM));
                foto.setChangeSize(resultSet.getInt(SQLColumns.FOTO_CHANGE_SIZE));
                foto.setChangeColor(resultSet.getInt(SQLColumns.FOTO_CHANGE_COLOR));
                foto.setChangeSensivity(resultSet.getInt(SQLColumns.FOTO_CHANGE_SENSIVITY));
                foto.setCrustsAndBleeding(resultSet.getInt(SQLColumns.FOTO_CRUSTS_AND_BLEEDING));
                foto.setTumorPain(resultSet.getInt(SQLColumns.FOTO_TUMOR_PAIN));
                foto.setSatellite(resultSet.getInt(SQLColumns.FOTO_SATELLITE));
                foto.setInflammations(resultSet.getInt(SQLColumns.FOTO_INFLAMMATIONS));
                foto.setUniformColoring(resultSet.getInt(SQLColumns.FOTO_UNIFORM_COLORING));
                foto.setSkinType(resultSet.getInt(SQLColumns.FOTO_SKIN_TYPE));
                foto.setTumor_diameter(resultSet.getInt(SQLColumns.FOTO_TUMOR_DIAMETER));
                foto.setTumorForm(TumorForm.setTumorForm(resultSet.getInt(SQLColumns.FOTO_TUMOR_FORM)));
                foto.setTumorSurface(TumorSurface.setTumorSurface(resultSet.getInt(SQLColumns.FOTO_TUMOR_SURFACE)));
                foto.setTumorOutline(TumorOutline.setTumorOutline(resultSet.getInt(SQLColumns.FOTO_TUMOR_OUTLINE)));
                foto.setTumorLocalization(TumorLocalization.setTumorLocalization(resultSet.getInt(SQLColumns.FOTO_TUMOR_LOCALIZATION)));
                foto.setDevice(Device.setDevice(resultSet.getInt(SQLColumns.FOTO_DEVICE)));
                foto.setDate(resultSet.getDate(SQLColumns.FOTO_DATE));
                foto.setComments(resultSet.getString(SQLColumns.FOTO_COMMENTS));
                foto.setDiagnosisPreliminary(DiagnosisPreliminary.setDiagnosisPreliminary(resultSet.getInt(SQLColumns.FOTO_DIAGNOSIS_PRELIMINARY)));
                foto.setDiagnosisFinal(DiagnosisFinal.setDiagnosisFinal(resultSet.getInt(SQLColumns.FOTO_DIAGNOSIS_FINAL)));
                foto.setResultComputerAnalysisProbability(resultSet.getInt(SQLColumns.FOTO_RESULT_COMPUTER_ANALYSIS_PROBABILITY));
                foto.setResultComputerAnalysisSimilar(resultSet.getInt(SQLColumns.FOTO_RESULT_COMPUTER_ANALYSIS_SIMILAR));
                foto.setPlacedInDatabase(resultSet.getInt(SQLColumns.FOTO_PLACED_IN_DATABASE));
                fotos.add(foto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement, resultSet);
        }
        return fotos;
    }

    @Override
    public Foto getEntityById(int id) {
        Foto foto = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.GET_FOTO_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                foto = new Foto();
                foto.setId(resultSet.getInt(SQLColumns.FOTO_ID));
                foto.setUser(UserDAO.INSTANCE.getEntityById(resultSet.getInt(SQLColumns.FOTO_USER_ID)));
                foto.setId_tumor(resultSet.getInt(SQLColumns.FOTO_ID_TUMOR));
                foto.setOriginIllness(OriginIllness.setOriginIllness(resultSet.getInt(SQLColumns.FOTO_ORIGIN_ILLNESS)));
                foto.setDurationIllness(DurationIllness.setDurationIllness(resultSet.getInt(SQLColumns.FOTO_DURATION_ILLNESS)));
                foto.setChangeForm(resultSet.getInt(SQLColumns.FOTO_CHANGE_FORM));
                foto.setChangeSize(resultSet.getInt(SQLColumns.FOTO_CHANGE_SIZE));
                foto.setChangeColor(resultSet.getInt(SQLColumns.FOTO_CHANGE_COLOR));
                foto.setChangeSensivity(resultSet.getInt(SQLColumns.FOTO_CHANGE_SENSIVITY));
                foto.setCrustsAndBleeding(resultSet.getInt(SQLColumns.FOTO_CRUSTS_AND_BLEEDING));
                foto.setTumorPain(resultSet.getInt(SQLColumns.FOTO_TUMOR_PAIN));
                foto.setSatellite(resultSet.getInt(SQLColumns.FOTO_SATELLITE));
                foto.setInflammations(resultSet.getInt(SQLColumns.FOTO_INFLAMMATIONS));
                foto.setUniformColoring(resultSet.getInt(SQLColumns.FOTO_UNIFORM_COLORING));
                foto.setSkinType(resultSet.getInt(SQLColumns.FOTO_SKIN_TYPE));
                foto.setTumor_diameter(resultSet.getInt(SQLColumns.FOTO_TUMOR_DIAMETER));
                foto.setTumorForm(TumorForm.setTumorForm(resultSet.getInt(SQLColumns.FOTO_TUMOR_FORM)));
                foto.setTumorSurface(TumorSurface.setTumorSurface(resultSet.getInt(SQLColumns.FOTO_TUMOR_SURFACE)));
                foto.setTumorOutline(TumorOutline.setTumorOutline(resultSet.getInt(SQLColumns.FOTO_TUMOR_OUTLINE)));
                foto.setTumorLocalization(TumorLocalization.setTumorLocalization(resultSet.getInt(SQLColumns.FOTO_TUMOR_LOCALIZATION)));
                foto.setDevice(Device.setDevice(resultSet.getInt(SQLColumns.FOTO_DEVICE)));
                foto.setDate(resultSet.getDate(SQLColumns.FOTO_DATE));
                foto.setComments(resultSet.getString(SQLColumns.FOTO_COMMENTS));
                foto.setDiagnosisPreliminary(DiagnosisPreliminary.setDiagnosisPreliminary(resultSet.getInt(SQLColumns.FOTO_DIAGNOSIS_PRELIMINARY)));
                foto.setDiagnosisFinal(DiagnosisFinal.setDiagnosisFinal(resultSet.getInt(SQLColumns.FOTO_DIAGNOSIS_FINAL)));
                foto.setResultComputerAnalysisProbability(resultSet.getInt(SQLColumns.FOTO_RESULT_COMPUTER_ANALYSIS_PROBABILITY));
                foto.setResultComputerAnalysisSimilar(resultSet.getInt(SQLColumns.FOTO_RESULT_COMPUTER_ANALYSIS_SIMILAR));
                foto.setPlacedInDatabase(resultSet.getInt(SQLColumns.FOTO_PLACED_IN_DATABASE));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement, resultSet);
        }
        return foto;
    }

    public ArrayList<Foto> getEntityByUser(User user) {
        ArrayList<Foto> fotos = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.GET_FOTOS_BY_USER);
            statement.setInt(1, user.getId());
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Foto foto = new Foto();
                foto.setId(resultSet.getInt(SQLColumns.FOTO_ID));
                foto.setUser(UserDAO.INSTANCE.getEntityById(resultSet.getInt(SQLColumns.FOTO_USER_ID)));
                foto.setId_tumor(resultSet.getInt(SQLColumns.FOTO_ID_TUMOR));
                foto.setOriginIllness(OriginIllness.setOriginIllness(resultSet.getInt(SQLColumns.FOTO_ORIGIN_ILLNESS)));
                foto.setDurationIllness(DurationIllness.setDurationIllness(resultSet.getInt(SQLColumns.FOTO_DURATION_ILLNESS)));
                foto.setChangeForm(resultSet.getInt(SQLColumns.FOTO_CHANGE_FORM));
                foto.setChangeSize(resultSet.getInt(SQLColumns.FOTO_CHANGE_SIZE));
                foto.setChangeColor(resultSet.getInt(SQLColumns.FOTO_CHANGE_COLOR));
                foto.setChangeSensivity(resultSet.getInt(SQLColumns.FOTO_CHANGE_SENSIVITY));
                foto.setCrustsAndBleeding(resultSet.getInt(SQLColumns.FOTO_CRUSTS_AND_BLEEDING));
                foto.setTumorPain(resultSet.getInt(SQLColumns.FOTO_TUMOR_PAIN));
                foto.setSatellite(resultSet.getInt(SQLColumns.FOTO_SATELLITE));
                foto.setInflammations(resultSet.getInt(SQLColumns.FOTO_INFLAMMATIONS));
                foto.setUniformColoring(resultSet.getInt(SQLColumns.FOTO_UNIFORM_COLORING));
                foto.setSkinType(resultSet.getInt(SQLColumns.FOTO_SKIN_TYPE));
                foto.setTumor_diameter(resultSet.getInt(SQLColumns.FOTO_TUMOR_DIAMETER));
                foto.setTumorForm(TumorForm.setTumorForm(resultSet.getInt(SQLColumns.FOTO_TUMOR_FORM)));
                foto.setTumorSurface(TumorSurface.setTumorSurface(resultSet.getInt(SQLColumns.FOTO_TUMOR_SURFACE)));
                foto.setTumorOutline(TumorOutline.setTumorOutline(resultSet.getInt(SQLColumns.FOTO_TUMOR_OUTLINE)));
                foto.setTumorLocalization(TumorLocalization.setTumorLocalization(resultSet.getInt(SQLColumns.FOTO_TUMOR_LOCALIZATION)));
                foto.setDevice(Device.setDevice(resultSet.getInt(SQLColumns.FOTO_DEVICE)));
                foto.setDate(resultSet.getDate(SQLColumns.FOTO_DATE));
                foto.setComments(resultSet.getString(SQLColumns.FOTO_COMMENTS));
                foto.setDiagnosisPreliminary(DiagnosisPreliminary.setDiagnosisPreliminary(resultSet.getInt(SQLColumns.FOTO_DIAGNOSIS_PRELIMINARY)));
                foto.setDiagnosisFinal(DiagnosisFinal.setDiagnosisFinal(resultSet.getInt(SQLColumns.FOTO_DIAGNOSIS_FINAL)));
                foto.setResultComputerAnalysisProbability(resultSet.getInt(SQLColumns.FOTO_RESULT_COMPUTER_ANALYSIS_PROBABILITY));
                foto.setResultComputerAnalysisSimilar(resultSet.getInt(SQLColumns.FOTO_RESULT_COMPUTER_ANALYSIS_SIMILAR));
                foto.setPlacedInDatabase(resultSet.getInt(SQLColumns.FOTO_PLACED_IN_DATABASE));
                fotos.add(foto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement, resultSet);
        }
        return fotos;
    }

    @Override
    public void createEntity(Foto foto) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.CREATE_FOTO);
            statement.setInt(1, foto.getUser().getId());
            statement.setInt(2, foto.getId_tumor());
            statement.setInt(3, foto.getOriginIllness().getId());
            statement.setInt(4, foto.getDurationIllness().getId());
            statement.setInt(5, foto.getChangeForm());
            statement.setInt(6, foto.getChangeSize());
            statement.setInt(7, foto.getChangeColor());
            statement.setInt(8, foto.getChangeSensivity());
            statement.setInt(9, foto.getCrustsAndBleeding());
            statement.setInt(10, foto.getTumorPain());
            statement.setInt(11, foto.getSatellite());
            statement.setInt(12, foto.getInflammations());
            statement.setInt(13, foto.getUniformColoring());
            statement.setInt(14, foto.getSkinType());
            statement.setInt(15, foto.getTumor_diameter());
            statement.setInt(16, foto.getTumorForm().getId());
            statement.setInt(17, foto.getTumorSurface().getId());
            statement.setInt(18, foto.getTumorOutline().getId());
            statement.setInt(19, foto.getTumorLocalization().getId());
            statement.setInt(20, foto.getDevice().getId());
            statement.setDate(21, foto.getDate());
            statement.setString(22, foto.getComments());
            statement.setInt(23, foto.getDiagnosisPreliminary().getId());
            statement.setInt(24, foto.getDiagnosisFinal().getId());
            statement.setInt(25, foto.getResultComputerAnalysisProbability());
            statement.setInt(26, foto.getResultComputerAnalysisSimilar());
            statement.setInt(27, foto.getPlacedInDatabase());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FotoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement);
        }
    }

    @Override
    public void updateEntity(Foto foto) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQLRequests.UPDATE_FOTO);
            statement.setInt(1, foto.getUser().getId());
            statement.setInt(2, foto.getId_tumor());
            statement.setInt(3, foto.getOriginIllness().getId());
            statement.setInt(4, foto.getDurationIllness().getId());
            statement.setInt(5, foto.getChangeForm());
            statement.setInt(6, foto.getChangeSize());
            statement.setInt(7, foto.getChangeColor());
            statement.setInt(8, foto.getChangeSensivity());
            statement.setInt(9, foto.getCrustsAndBleeding());
            statement.setInt(10, foto.getTumorPain());
            statement.setInt(11, foto.getSatellite());
            statement.setInt(12, foto.getInflammations());
            statement.setInt(13, foto.getUniformColoring());
            statement.setInt(14, foto.getSkinType());
            statement.setInt(15, foto.getTumor_diameter());
            statement.setInt(16, foto.getTumorForm().getId());
            statement.setInt(17, foto.getTumorSurface().getId());
            statement.setInt(18, foto.getTumorOutline().getId());
            statement.setInt(19, foto.getTumorLocalization().getId());
            statement.setInt(20, foto.getDevice().getId());
            statement.setDate(21, foto.getDate());
            statement.setString(22, foto.getComments());
            statement.setInt(23, foto.getDiagnosisPreliminary().getId());
            statement.setInt(24, foto.getDiagnosisFinal().getId());
            statement.setInt(25, foto.getResultComputerAnalysisProbability());
            statement.setInt(26, foto.getResultComputerAnalysisSimilar());
            statement.setInt(27, foto.getPlacedInDatabase());
            statement.setInt(28, foto.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FotoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseConnection(connection, statement);
        }
    }

    @Override
    public void deleteEntity(Foto foto) {
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
}
