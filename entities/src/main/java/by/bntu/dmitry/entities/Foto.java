package by.bntu.dmitry.entities;

import by.bntu.dmitry.constants.OptionNames;
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
    private String directory;
    private double rsa;

    public double getRsa() {
        return rsa;
    }

    public void setRsa(double rsa) {
        this.rsa = rsa;
    }

    public int getTumorDiameter() {
        return tumorDiameter;
    }

    public void setTumorDiameter(int tumorDiameter) {
        this.tumorDiameter = tumorDiameter;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

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

    public void setOriginIllness(String originIllness) {
        if (originIllness.equals(OptionNames.ORIGIN_ILLNESS_NONE)) {
            this.originIllness = OriginIllness.DO_NOT_KNOW;
        }
        if (originIllness.equals(OptionNames.ORIGIN_ILLNESS_INNATE)) {
            this.originIllness = OriginIllness.INNATE;
        }
        if (originIllness.equals(OptionNames.ORIGIN_ILLNESS_OBTAINED)) {
            this.originIllness = OriginIllness.OBTAINED;
        }
    }

    public DurationIllness getDurationIllness() {
        return durationIllness;
    }

    public void setDurationIllness(DurationIllness durationIllness) {
        this.durationIllness = durationIllness;
    }

    public void setDurationIllness(String durationIllness) {
        if (durationIllness.equals(OptionNames.NO_INFO_ABOUT_CHANGES)) {
            this.durationIllness = DurationIllness.NO_INFO_ABOUT_CHANGES;
        }
        if (durationIllness.equals(OptionNames.CHANGES_IN_CLINICAL_PICTURE)) {
            this.durationIllness = DurationIllness.CHANGES_IN_CLINICAL_PICTURE;
        }
        if (durationIllness.equals(OptionNames.NO_CHANGES_DURING_3_MONTH)) {
            this.durationIllness = DurationIllness.NO_CHANGES_DURING_3_MONTH;
        }
    }

    public int getChangeForm() {
        return changeForm;
    }
    
    public String getChangeFormName() {
        switch (changeForm){
            case 1:
                return "Да";
            case 2:
                return "Нет";
            case 0:
                return "Нет данных";
            default :
                return "null";
        }
    }

    public void setChangeForm(int changeForm) {
        this.changeForm = changeForm;
    }

    public void setChangeForm(String changeForm) {
        if (changeForm.equals(OptionNames.CHANGE_FORM_NONE)) {
            this.changeForm = 0;
        }
        if (changeForm.equals(OptionNames.CHANGE_FORM_YES)) {
            this.changeForm = 1;
        }
        if (changeForm.equals(OptionNames.CHANGE_FORM_NO)) {
            this.changeForm = 2;
        }
    }

    public int getChangeSize() {
        return changeSize;
    }
    
    public String getChangeSizeName() {
        switch (changeSize){
            case 1:
                return "Да";
            case 2:
                return "Нет";
            case 0:
                return "Нет данных";
            default :
                return "null";
        }
    }

    public void setChangeSize(int changeSize) {
        this.changeSize = changeSize;
    }

    public void setChangeSize(String changeSize) {
        if (changeSize.equals(OptionNames.CHANGE_SIZE_NONE)) {
            this.changeSize = 0;
        }
        if (changeSize.equals(OptionNames.CHANGE_SIZE_YES)) {
            this.changeSize = 1;
        }
        if (changeSize.equals(OptionNames.CHANGE_SIZE_NO)) {
            this.changeSize = 2;
        }
    }

    public int getChangeColor() {
        return changeColor;
    }
    
    public String getChangeColorName() {
        switch (changeColor){
            case 1:
                return "Да";
            case 2:
                return "Нет";
            case 0:
                return "Нет данных";
            default :
                return "null";
        }
    }

    public void setChangeColor(int changeColor) {
        this.changeColor = changeColor;
    }

    public void setChangeColor(String changeColor) {
        if (changeColor.equals(OptionNames.CHANGE_COLOR_NONE)) {
            this.changeColor = 0;
        }
        if (changeColor.equals(OptionNames.CHANGE_COLOR_YES)) {
            this.changeColor = 1;
        }
        if (changeColor.equals(OptionNames.CHANGE_COLOR_NO)) {
            this.changeColor = 2;
        }
    }

    public int getChangeSensivity() {
        return changeSensivity;
    }

    public String getChangeSensivityName() {
        switch (changeSensivity){
            case 1:
                return "Да";
            case 2:
                return "Нет";
            case 0:
                return "Нет данных";
            default :
                return "null";
        }
    }
    
    public void setChangeSensivity(int changeSensivity) {
        this.changeSensivity = changeSensivity;
    }

    public void setChangeSensivity(String changeSensivity) {
        if (changeSensivity.equals(OptionNames.CHANGE_SENSITIVITY_NONE)) {
            this.changeSensivity = 0;
        }
        if (changeSensivity.equals(OptionNames.CHANGE_SENSITIVITY_YES)) {
            this.changeSensivity = 1;
        }
        if (changeSensivity.equals(OptionNames.CHANGE_SENSITIVITY_NO)) {
            this.changeSensivity = 2;
        }
    }

    public int getCrustsAndBleeding() {
        return crustsAndBleeding;
    }

    public String getCrustsAndBleedingName() {
        switch (crustsAndBleeding){
            case 1:
                return "Да";
            case 2:
                return "Нет";
            case 0:
                return "Нет данных";
            default :
                return "null";
        }
    }
    
    public void setCrustsAndBleeding(int crustsAndBleeding) {
        this.crustsAndBleeding = crustsAndBleeding;
    }

    public void setCrustsAndBleeding(String crustsAndBleeding) {
        if (crustsAndBleeding.equals(OptionNames.CRUSTS_AND_BLEEDING_NONE)) {
            this.crustsAndBleeding = 0;
        }
        if (crustsAndBleeding.equals(OptionNames.CRUSTS_AND_BLEEDING_YES)) {
            this.crustsAndBleeding = 1;
        }
        if (crustsAndBleeding.equals(OptionNames.CRUSTS_AND_BLEEDING_NO)) {
            this.crustsAndBleeding = 2;
        }
    }

    public int getTumorPain() {
        return tumorPain;
    }
    
    public String getTumorPainName() {
        switch (tumorPain){
            case 1:
                return "Да";
            case 2:
                return "Нет";
            case 0:
                return "Нет данных";
            default :
                return "null";
        }
    }

    public void setTumorPain(int tumorPain) {
        this.tumorPain = tumorPain;
    }

    public void setTumorPain(String tumorPain) {
        if (tumorPain.equals(OptionNames.TUMOR_PAIN_NONE)) {
            this.tumorPain = 0;
        }
        if (tumorPain.equals(OptionNames.TUMOR_PAIN_YES)) {
            this.tumorPain = 1;
        }
        if (tumorPain.equals(OptionNames.TUMOR_PAIN_NO)) {
            this.tumorPain = 2;
        }
    }

    public int getSatellite() {
        return satellite;
    }

    public String getSatelliteName() {
        switch (satellite){
            case 1:
                return "Да";
            case 2:
                return "Нет";
            case 0:
                return "Нет данных";
            default :
                return "null";
        }
    }
    
    public void setSatellite(int satellite) {
        this.satellite = satellite;
    }

    public void setSatellite(String satellite) {
        if (satellite.equals(OptionNames.SATELLITE_NONE)) {
            this.satellite = 0;
        }
        if (satellite.equals(OptionNames.SATELLITE_YES)) {
            this.satellite = 1;
        }
        if (satellite.equals(OptionNames.SATELLITE_NO)) {
            this.satellite = 2;
        }
    }

    public int getInflammations() {
        return inflammations;
    }
    
    public String getInflammationsName() {
        switch (inflammations){
            case 1:
                return "Да";
            case 2:
                return "Нет";
            case 0:
                return "Нет данных";
            default :
                return "null";
        }
    }

    public void setInflammations(int inflammations) {
        this.inflammations = inflammations;
    }

    public void setInflammations(String inflammations) {
        if (inflammations.equals(OptionNames.INFLAMMATIONS_NONE)) {
            this.inflammations = 0;
        }
        if (inflammations.equals(OptionNames.INFLAMMATIONS_YES)) {
            this.inflammations = 1;
        }
        if (inflammations.equals(OptionNames.INFLAMMATIONS_NO)) {
            this.inflammations = 2;
        }
    }

    public int getUniformColoring() {
        return uniformColoring;
    }
    
    public String getUniformColoringName() {
        switch (uniformColoring){
            case 1:
                return "Да";
            case 2:
                return "Нет";
            case 0:
                return "Нет данных";
            default :
                return "null";
        }
    }

    public void setUniformColoring(int uniformColoring) {
        this.uniformColoring = uniformColoring;
    }

    public void setUniformColoring(String uniformColoring) {
        if (uniformColoring.equals(OptionNames.UNIFORM_COLORING_NONE)) {
            this.uniformColoring = 0;
        }
        if (uniformColoring.equals(OptionNames.UNIFORM_COLORING_YES)) {
            this.uniformColoring = 1;
        }
        if (uniformColoring.equals(OptionNames.UNIFORM_COLORING_NO)) {
            this.uniformColoring = 2;
        }
    }

    public int getSkinType() {
        return skinType;
    }

    public void setSkinType(int skinType) {
        this.skinType = skinType;
    }

    public void setSkinType(String skinType) {
        if (skinType.equals(OptionNames.SKIN_TYPE_NONE)) {
            this.skinType = 0;
        }
        if (skinType.equals(OptionNames.SKIN_TYPE_1)) {
            this.skinType = 1;
        }
        if (skinType.equals(OptionNames.SKIN_TYPE_2)) {
            this.skinType = 2;
        }
        if (skinType.equals(OptionNames.SKIN_TYPE_3)) {
            this.skinType = 3;
        }
        if (skinType.equals(OptionNames.SKIN_TYPE_4)) {
            this.skinType = 4;
        }
        if (skinType.equals(OptionNames.SKIN_TYPE_5)) {
            this.skinType = 5;
        }
        if (skinType.equals(OptionNames.SKIN_TYPE_6)) {
            this.skinType = 6;
        }
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

    public void setTumorForm(String tumorForm) {
        if (tumorForm.equals(OptionNames.FLAT)) {
            this.tumorForm = TumorForm.FLAT;
        }
        if (tumorForm.equals(OptionNames.TUBEROUS)) {
            this.tumorForm = TumorForm.TUBEROUS;
        }
        if (tumorForm.equals(OptionNames.NODULAR)) {
            this.tumorForm = TumorForm.NODULAR;
        }
        if (tumorForm.equals(OptionNames.HEMISPHERICAL)) {
            this.tumorForm = TumorForm.HEMISPHERICAL;
        }
        if (tumorForm.equals(OptionNames.MUSHROOM_SHAPED)) {
            this.tumorForm = TumorForm.MUSHROOM_SHAPED;
        }
    }

    public TumorSurface getTumorSurface() {
        return tumorSurface;
    }

    public void setTumorSurface(TumorSurface tumorSurface) {
        this.tumorSurface = tumorSurface;
    }

    public void setTumorSurface(String tumorSurface) {
        if (tumorSurface.equals(OptionNames.SMOOTH)) {
            this.tumorSurface = TumorSurface.SMOOTH;
        }
        if (tumorSurface.equals(OptionNames.TUBEROSITY)) {
            this.tumorSurface = TumorSurface.TUBEROSITY;
        }
        if (tumorSurface.equals(OptionNames.FINE_GRAINED)) {
            this.tumorSurface = TumorSurface.FINE_GRAINED;
        }
        if (tumorSurface.equals(OptionNames.WITH_KERATOSIS)) {
            this.tumorSurface = TumorSurface.WITH_KERATOSIS;
        }
        if (tumorSurface.equals(OptionNames.MOIST)) {
            this.tumorSurface = TumorSurface.MOIST;
        }
    }

    public TumorOutline getTumorOutline() {
        return tumorOutline;
    }

    public void setTumorOutline(TumorOutline tumorOutline) {
        this.tumorOutline = tumorOutline;
    }

    public void setTumorOutline(String tumorOutline) {
        if (tumorOutline.equals(OptionNames.CLEAR)) {
            this.tumorOutline = TumorOutline.CLEAR;
        }
        if (tumorOutline.equals(OptionNames.FUZZY)) {
            this.tumorOutline = TumorOutline.FUZZY;
        }
    }

    public TumorLocalization getTumorLocalization() {
        return tumorLocalization;
    }

    public void setTumorLocalization(TumorLocalization tumorLocalization) {
        this.tumorLocalization = tumorLocalization;
    }

    public void setTumorLocalization(String tumorLocalization) {
        if (tumorLocalization.equals(OptionNames.SCALP)) {
            this.tumorLocalization = TumorLocalization.SCALP;
        }
        if (tumorLocalization.equals(OptionNames.FACE)) {
            this.tumorLocalization = TumorLocalization.FACE;
        }
        if (tumorLocalization.equals(OptionNames.ORGAN_OF_VISION)) {
            this.tumorLocalization = TumorLocalization.ORGAN_OF_VISION;
        }
        if (tumorLocalization.equals(OptionNames.ORAL_MUCOSA)) {
            this.tumorLocalization = TumorLocalization.ORAL_MUCOSA;
        }
        if (tumorLocalization.equals(OptionNames.NASAL_MUCOSA)) {
            this.tumorLocalization = TumorLocalization.NASAL_MUCOSA;
        }
        if (tumorLocalization.equals(OptionNames.MUCOSA_OF_THE_PARANASAL_SINUSES)) {
            this.tumorLocalization = TumorLocalization.MUCOSA_OF_THE_PARANASAL_SINUSES;
        }
        if (tumorLocalization.equals(OptionNames.NECK)) {
            this.tumorLocalization = TumorLocalization.NECK;
        }
        if (tumorLocalization.equals(OptionNames.SHOULDER_GIRDLE)) {
            this.tumorLocalization = TumorLocalization.SHOULDER_GIRDLE;
        }
        if (tumorLocalization.equals(OptionNames.AXILLARY_REGION)) {
            this.tumorLocalization = TumorLocalization.AXILLARY_REGION;
        }
        if (tumorLocalization.equals(OptionNames.UPPER_EXTREMITY)) {
            this.tumorLocalization = TumorLocalization.UPPER_EXTREMITY;
        }
        if (tumorLocalization.equals(OptionNames.PALM)) {
            this.tumorLocalization = TumorLocalization.PALM;
        }
        if (tumorLocalization.equals(OptionNames.FINGER_NALL_PLATE_OF_THE_UPPER_LIMB)) {
            this.tumorLocalization = TumorLocalization.FINGER_NALL_PLATE_OF_THE_UPPER_LIMB;
        }
        if (tumorLocalization.equals(OptionNames.ANTERIOR_THORAX)) {
            this.tumorLocalization = TumorLocalization.ANTERIOR_THORAX;
        }
        if (tumorLocalization.equals(OptionNames.BACK)) {
            this.tumorLocalization = TumorLocalization.BACK;
        }
        if (tumorLocalization.equals(OptionNames.ANTERIOR_SURFACE_OF_THE_ABDOMINAL_WALL)) {
            this.tumorLocalization = TumorLocalization.ANTERIOR_SURFACE_OF_THE_ABDOMINAL_WALL;
        }
        if (tumorLocalization.equals(OptionNames.LUMBAR_REGION)) {
            this.tumorLocalization = TumorLocalization.LUMBAR_REGION;
        }
        if (tumorLocalization.equals(OptionNames.GROIN)) {
            this.tumorLocalization = TumorLocalization.GROIN;
        }
        if (tumorLocalization.equals(OptionNames.VULVA)) {
            this.tumorLocalization = TumorLocalization.VULVA;
        }
        if (tumorLocalization.equals(OptionNames.GLUTEAL_REGION)) {
            this.tumorLocalization = TumorLocalization.GLUTEAL_REGION;
        }
        if (tumorLocalization.equals(OptionNames.PERINEUM)) {
            this.tumorLocalization = TumorLocalization.PERINEUM;
        }
        if (tumorLocalization.equals(OptionNames.LOWER_LIMB)) {
            this.tumorLocalization = TumorLocalization.LOWER_LIMB;
        }
        if (tumorLocalization.equals(OptionNames.THIGH_AREA)) {
            this.tumorLocalization = TumorLocalization.THIGH_AREA;
        }
        if (tumorLocalization.equals(OptionNames.SHIN)) {
            this.tumorLocalization = TumorLocalization.SHIN;
        }
        if (tumorLocalization.equals(OptionNames.PLANTAR_SURFACE_OF_THE_FOOT)) {
            this.tumorLocalization = TumorLocalization.PLANTAR_SURFACE_OF_THE_FOOT;
        }
        if (tumorLocalization.equals(OptionNames.FINGER_NAIL_PLATE_OF_THE_LOWER_LIMB)) {
            this.tumorLocalization = TumorLocalization.FINGER_NAIL_PLATE_OF_THE_LOWER_LIMB;
        }
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public void setDevice(String device) {
        if (device.equals(OptionNames.CAMERA)) {
            this.device = Device.CAMERA;
        }
        if (device.equals(OptionNames.DERMATOSCOP)) {
            this.device = Device.DERMATOSCOP;
        }
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
        return this.diagnosisFinal == other.diagnosisFinal;
    }

    @Override
    public String toString() {
        return "Foto{" + "user=" + user + ", id_tumor=" + id_tumor + ", originIllness=" + originIllness + ", durationIllness=" + durationIllness + ", changeForm=" + changeForm + ", changeSize=" + changeSize + ", changeColor=" + changeColor + ", changeSensivity=" + changeSensivity + ", crustsAndBleeding=" + crustsAndBleeding + ", tumorPain=" + tumorPain + ", satellite=" + satellite + ", inflammations=" + inflammations + ", uniformColoring=" + uniformColoring + ", skinType=" + skinType + ", tumor_diameter=" + tumorDiameter + ", tumorForm=" + tumorForm + ", tumorSurface=" + tumorSurface + ", tumorOutline=" + tumorOutline + ", tumorLocalization=" + tumorLocalization + ", device=" + device + ", date=" + date + ", comments=" + comments + ", diagnosisPreliminary=" + diagnosisPreliminary + ", diagnosisFinal=" + diagnosisFinal + ", resultComputerAnalysisProbability=" + resultComputerAnalysisProbability + ", resultComputerAnalysisSimilar=" + resultComputerAnalysisSimilar + ", placedInDatabase=" + placedInDatabase + '}';
    }





}
