package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum TumorLocalization {

    SCALP(1),
    FACE(2),
    ORGAN_OF_VISION(3),
    ORAL_MUCOSA(4),
    NASAL_MUCOSA(5),
    MUCOSA_OF_THE_PARANASAL_SINUSES(6),
    NECK(7),
    SHOULDER_GIRDLE(8),
    AXILLARY_REGION(9),
    UPPER_EXTREMITY(10),
    PALM(11),
    FINGER_NALL_PLATE_OF_THE_UPPER_LIMB(12),
    ANTERIOR_THORAX(13),
    BACK(14),
    ANTERIOR_SURFACE_OF_THE_ABDOMINAL_WALL(15),
    LUMBAR_REGION(16),
    GROIN(17),
    VULVA(18),
    GLUTEAL_REGION(19),
    PERINEUM(20),
    LOWER_LIMB(21),
    THIGH_AREA(22),
    SHIN(23),
    PLANTAR_SURFACE_OF_THE_FOOT(24),
    FINGER_NAIL_PLATE_OF_THE_LOWER_LIMB(25);

    private int id;

    private TumorLocalization(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static TumorLocalization setTumorLocalization(int id) {
        switch (id) {
            case 1:
                return SCALP;
            case 2:
                return FACE;
            case 3:
                return ORGAN_OF_VISION;
            case 4:
                return ORAL_MUCOSA;
            case 5:
                return NASAL_MUCOSA;
            case 6:
                return MUCOSA_OF_THE_PARANASAL_SINUSES;
            case 7:
                return NECK;
            case 8:
                return SHOULDER_GIRDLE;
            case 9:
                return AXILLARY_REGION;
            case 10:
                return UPPER_EXTREMITY;
            case 11:
                return PALM;
            case 12:
                return FINGER_NALL_PLATE_OF_THE_UPPER_LIMB;
            case 13:
                return ANTERIOR_THORAX;
            case 14:
                return BACK;
            case 15:
                return ANTERIOR_SURFACE_OF_THE_ABDOMINAL_WALL;
            case 16:
                return LUMBAR_REGION;
            case 17:
                return GROIN;
            case 18:
                return VULVA;
            case 19:
                return GLUTEAL_REGION;
            case 20:
                return PERINEUM;
            case 21:
                return LOWER_LIMB;
            case 22:
                return THIGH_AREA;
            case 23:
                return SHIN;
            case 24:
                return PLANTAR_SURFACE_OF_THE_FOOT;
            case 25:
                return FINGER_NAIL_PLATE_OF_THE_LOWER_LIMB;
        }
        return null;
    }

}
