package by.bntu.dmitry.entities;

import by.bntu.dmitry.enums.Device;
import by.bntu.dmitry.enums.DiagnosisFinal;
import by.bntu.dmitry.enums.DiagnosisPreliminary;
import by.bntu.dmitry.enums.DurationIllness;
import by.bntu.dmitry.enums.OriginIllness;
import by.bntu.dmitry.enums.TumorForm;
import by.bntu.dmitry.enums.TumorLocalization;
import by.bntu.dmitry.enums.TumorOutline;
import by.bntu.dmitry.enums.TumorSurface;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author dmitry
 */
public class Foto extends AbstractEntity {

    private User user;
    private int id_tumor;
    private OriginIllness originIllness;
    private DurationIllness durationIllness;
    private int changeForm;
    private int changeSize;
    private int changeColor;
    private int changeSensivity;
    private int crustsAndBleeding;
    private int tumorPain;
    private int satellite;
    private int inflammations;
    private int uniformColoring;
    private int skinType;
    private int tumorDiameter;
    private TumorForm tumorForm;
    private TumorSurface tumorSurface;
    private TumorOutline tumorOutline;
    private TumorLocalization tumorLocalization;
    private Device device;
    private Date date;
    private String comments;
    private DiagnosisPreliminary diagnosisPreliminary;
    private DiagnosisFinal diagnosisFinal;
    private int resultComputerAnalysisProbability;
    private int resultComputerAnalysisSimilar;
    private int placedInDatabase;

    public Foto() {
    }

    public Foto(User user, int id_tumor, OriginIllness originIllness, 
            DurationIllness durationIllness, int changeForm, int changeSize, 
            int changeColor, int changeSensivity, int crustsAndBleeding, 
            int tumorPain, int satellite, int inflammations, 
            int uniformColoring, int skinType, int tumor_diameter, 
            TumorForm tumorForm, TumorSurface tumorSurface, 
            TumorOutline tumorOutline, TumorLocalization tumorLocalization, 
            Device device, Date date, String comments, 
            DiagnosisPreliminary diagnosisPreliminary, 
            DiagnosisFinal diagnosisFinal, 
            int resultComputerAnalysisProbability, 
            int resultComputerAnalysisSimilar, int placedInDatabase) {
        this.user = user;
        this.id_tumor = id_tumor;
        this.originIllness = originIllness;
        this.durationIllness = durationIllness;
        this.changeForm = changeForm;
        this.changeSize = changeSize;
        this.changeColor = changeColor;
        this.changeSensivity = changeSensivity;
        this.crustsAndBleeding = crustsAndBleeding;
        this.tumorPain = tumorPain;
        this.satellite = satellite;
        this.inflammations = inflammations;
        this.uniformColoring = uniformColoring;
        this.skinType = skinType;
        this.tumorDiameter = tumor_diameter;
        this.tumorForm = tumorForm;
        this.tumorSurface = tumorSurface;
        this.tumorOutline = tumorOutline;
        this.tumorLocalization = tumorLocalization;
        this.device = device;
        this.date = date;
        this.comments = comments;
        this.diagnosisPreliminary = diagnosisPreliminary;
        this.diagnosisFinal = diagnosisFinal;
        this.resultComputerAnalysisProbability = resultComputerAnalysisProbability;
        this.resultComputerAnalysisSimilar = resultComputerAnalysisSimilar;
        this.placedInDatabase = placedInDatabase;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId_tumor() {
        return id_tumor;
    }

    public void setId_tumor(int id_tumor) {
        this.id_tumor = id_tumor;
    }

    public OriginIllness getOriginIllness() {
        return originIllness;
    }

    public void setOriginIllness(OriginIllness originIllness) {
        this.originIllness = originIllness;
    }

    public DurationIllness getDurationIllness() {
        return durationIllness;
    }

    public void setDurationIllness(DurationIllness durationIllness) {
        this.durationIllness = durationIllness;
    }

    public int getChangeForm() {
        return changeForm;
    }

    public void setChangeForm(int changeForm) {
        this.changeForm = changeForm;
    }

    public int getChangeSize() {
        return changeSize;
    }

    public void setChangeSize(int changeSize) {
        this.changeSize = changeSize;
    }

    public int getChangeColor() {
        return changeColor;
    }

    public void setChangeColor(int changeColor) {
        this.changeColor = changeColor;
    }

    public int getChangeSensivity() {
        return changeSensivity;
    }

    public void setChangeSensivity(int changeSensivity) {
        this.changeSensivity = changeSensivity;
    }

    public int getCrustsAndBleeding() {
        return crustsAndBleeding;
    }

    public void setCrustsAndBleeding(int crustsAndBleeding) {
        this.crustsAndBleeding = crustsAndBleeding;
    }

    public int getTumorPain() {
        return tumorPain;
    }

    public void setTumorPain(int tumorPain) {
        this.tumorPain = tumorPain;
    }

    public int getSatellite() {
        return satellite;
    }

    public void setSatellite(int satellite) {
        this.satellite = satellite;
    }

    public int getInflammations() {
        return inflammations;
    }

    public void setInflammations(int inflammations) {
        this.inflammations = inflammations;
    }

    public int getUniformColoring() {
        return uniformColoring;
    }

    public void setUniformColoring(int uniformColoring) {
        this.uniformColoring = uniformColoring;
    }

    public int getSkinType() {
        return skinType;
    }

    public void setSkinType(int skinType) {
        this.skinType = skinType;
    }

    public int getTumor_diameter() {
        return tumorDiameter;
    }

    public void setTumor_diameter(int tumor_diameter) {
        this.tumorDiameter = tumor_diameter;
    }

    public TumorForm getTumorForm() {
        return tumorForm;
    }

    public void setTumorForm(TumorForm tumorForm) {
        this.tumorForm = tumorForm;
    }

    public TumorSurface getTumorSurface() {
        return tumorSurface;
    }

    public void setTumorSurface(TumorSurface tumorSurface) {
        this.tumorSurface = tumorSurface;
    }

    public TumorOutline getTumorOutline() {
        return tumorOutline;
    }

    public void setTumorOutline(TumorOutline tumorOutline) {
        this.tumorOutline = tumorOutline;
    }

    public TumorLocalization getTumorLocalization() {
        return tumorLocalization;
    }

    public void setTumorLocalization(TumorLocalization tumorLocalization) {
        this.tumorLocalization = tumorLocalization;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public DiagnosisPreliminary getDiagnosisPreliminary() {
        return diagnosisPreliminary;
    }

    public void setDiagnosisPreliminary(DiagnosisPreliminary diagnosisPreliminary) {
        this.diagnosisPreliminary = diagnosisPreliminary;
    }

    public DiagnosisFinal getDiagnosisFinal() {
        return diagnosisFinal;
    }

    public void setDiagnosisFinal(DiagnosisFinal diagnosisFinal) {
        this.diagnosisFinal = diagnosisFinal;
    }

    public int getResultComputerAnalysisProbability() {
        return resultComputerAnalysisProbability;
    }

    public void setResultComputerAnalysisProbability(int resultComputerAnalysisProbability) {
        this.resultComputerAnalysisProbability = resultComputerAnalysisProbability;
    }

    public int getResultComputerAnalysisSimilar() {
        return resultComputerAnalysisSimilar;
    }

    public void setResultComputerAnalysisSimilar(int resultComputerAnalysisSimilar) {
        this.resultComputerAnalysisSimilar = resultComputerAnalysisSimilar;
    }

    public int getPlacedInDatabase() {
        return placedInDatabase;
    }

    public void setPlacedInDatabase(int placedInDatabase) {
        this.placedInDatabase = placedInDatabase;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.user);
        hash = 11 * hash + this.id_tumor;
        hash = 11 * hash + Objects.hashCode(this.originIllness);
        hash = 11 * hash + Objects.hashCode(this.durationIllness);
        hash = 11 * hash + this.changeForm;
        hash = 11 * hash + this.changeSize;
        hash = 11 * hash + this.changeColor;
        hash = 11 * hash + this.changeSensivity;
        hash = 11 * hash + this.crustsAndBleeding;
        hash = 11 * hash + this.tumorPain;
        hash = 11 * hash + this.satellite;
        hash = 11 * hash + this.inflammations;
        hash = 11 * hash + this.uniformColoring;
        hash = 11 * hash + this.skinType;
        hash = 11 * hash + this.tumorDiameter;
        hash = 11 * hash + Objects.hashCode(this.tumorForm);
        hash = 11 * hash + Objects.hashCode(this.tumorSurface);
        hash = 11 * hash + Objects.hashCode(this.tumorOutline);
        hash = 11 * hash + Objects.hashCode(this.tumorLocalization);
        hash = 11 * hash + Objects.hashCode(this.device);
        hash = 11 * hash + Objects.hashCode(this.date);
        hash = 11 * hash + Objects.hashCode(this.comments);
        hash = 11 * hash + Objects.hashCode(this.diagnosisPreliminary);
        hash = 11 * hash + Objects.hashCode(this.diagnosisFinal);
        hash = 11 * hash + Float.floatToIntBits(this.resultComputerAnalysisProbability);
        hash = 11 * hash + this.resultComputerAnalysisSimilar;
        hash = 11 * hash + this.placedInDatabase;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Foto other = (Foto) obj;
        if (this.id_tumor != other.id_tumor) {
            return false;
        }
        if (this.changeForm != other.changeForm) {
            return false;
        }
        if (this.changeSize != other.changeSize) {
            return false;
        }
        if (this.changeColor != other.changeColor) {
            return false;
        }
        if (this.changeSensivity != other.changeSensivity) {
            return false;
        }
        if (this.crustsAndBleeding != other.crustsAndBleeding) {
            return false;
        }
        if (this.tumorPain != other.tumorPain) {
            return false;
        }
        if (this.satellite != other.satellite) {
            return false;
        }
        if (this.inflammations != other.inflammations) {
            return false;
        }
        if (this.uniformColoring != other.uniformColoring) {
            return false;
        }
        if (this.skinType != other.skinType) {
            return false;
        }
        if (this.tumorDiameter != other.tumorDiameter) {
            return false;
        }
        if (Float.floatToIntBits(this.resultComputerAnalysisProbability) != Float.floatToIntBits(other.resultComputerAnalysisProbability)) {
            return false;
        }
        if (this.resultComputerAnalysisSimilar != other.resultComputerAnalysisSimilar) {
            return false;
        }
        if (this.placedInDatabase != other.placedInDatabase) {
            return false;
        }
        if (!Objects.equals(this.comments, other.comments)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (this.originIllness != other.originIllness) {
            return false;
        }
        if (this.durationIllness != other.durationIllness) {
            return false;
        }
        if (this.tumorForm != other.tumorForm) {
            return false;
        }
        if (this.tumorSurface != other.tumorSurface) {
            return false;
        }
        if (this.tumorOutline != other.tumorOutline) {
            return false;
        }
        if (this.tumorLocalization != other.tumorLocalization) {
            return false;
        }
        if (this.device != other.device) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (this.diagnosisPreliminary != other.diagnosisPreliminary) {
            return false;
        }
        if (this.diagnosisFinal != other.diagnosisFinal) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Foto{" + "user=" + user + ", id_tumor=" + id_tumor + ", originIllness=" + originIllness + ", durationIllness=" + durationIllness + ", changeForm=" + changeForm + ", changeSize=" + changeSize + ", changeColor=" + changeColor + ", changeSensivity=" + changeSensivity + ", crustsAndBleeding=" + crustsAndBleeding + ", tumorPain=" + tumorPain + ", satellite=" + satellite + ", inflammations=" + inflammations + ", uniformColoring=" + uniformColoring + ", skinType=" + skinType + ", tumor_diameter=" + tumorDiameter + ", tumorForm=" + tumorForm + ", tumorSurface=" + tumorSurface + ", tumorOutline=" + tumorOutline + ", tumorLocalization=" + tumorLocalization + ", device=" + device + ", date=" + date + ", comments=" + comments + ", diagnosisPreliminary=" + diagnosisPreliminary + ", diagnosisFinal=" + diagnosisFinal + ", resultComputerAnalysisProbability=" + resultComputerAnalysisProbability + ", resultComputerAnalysisSimilar=" + resultComputerAnalysisSimilar + ", placedInDatabase=" + placedInDatabase + '}';
    }

    
    
    

}
