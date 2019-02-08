package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum TumorLocalization {
   
    SCALP(0, "Scalp"),
    FACE(1, "Face"),
    ORGAN_OF_VISION(2, "Organ of vision"),
    ORAL_MUCOSA(3, "Oral mucosa"),
    NASAL_MUCOSA(4, "Nasal mucosa"),
    MUCOSA_OF_THE_PARANASAL_SINUSES(5, "Mucosa of the paranasal sinuses"),
    NECK(6, "Neck"),
    SHOULDER_GIRDLE(7, "Shoulder girdle"),
    AXILLARY_REGION(8, "Axillary region"),
    UPPER_EXTREMITY(9, "Upper extremity"),
    PALM(10, "Palm"),
    FINGER_NALL_PLATE_OF_THE_UPPER_LIMB(11, "Finger nall plate of the upper limb"),
    ANTERIOR_THORAX(12, "Anterior thorax"),
    BACK(13, "Back"),
    ANTERIOR_SURFACE_OF_THE_ABDOMINAL_WALL(14, "Anterior surface of the abdominal wall"),
    LUMBAR_REGION(15, "Lumbar region"),
    GROIN(16, "Groin"),
    VULVA(17, "Vulva"),
    GLUTEAL_REGION(18, "Gluteal region"),
    PERINEUM(19, "Perineum"),
    LOWER_LIMB(20, "Lower limb"),
    THIGH_AREA(21, "Thigh area"),
    SHIN(22, "Shin"),
    PLANTAR_SURFACE_OF_THE_FOOT(23, "Plantar surface of the foot"),
    FINGER_NAIL_PLATE_OF_THE_LOWER_LIMB(24, "Finger nail plate of the lower limb");

    private int id;
    private String name;

    private TumorLocalization(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }
    
    public static TumorLocalization setTumorLocalization(int id) {
        switch (id) {
            case 0:
                return SCALP;
            case 1:
                return FACE;
            case 2:
                return ORGAN_OF_VISION;
            case 3:
                return ORAL_MUCOSA;
            case 4:
                return NASAL_MUCOSA;
            case 5:
                return MUCOSA_OF_THE_PARANASAL_SINUSES;
            case 6:
                return NECK;
            case 7:
                return SHOULDER_GIRDLE;
            case 8:
                return AXILLARY_REGION;
            case 9:
                return UPPER_EXTREMITY;
            case 10:
                return PALM;
            case 11:
                return FINGER_NALL_PLATE_OF_THE_UPPER_LIMB;
            case 12:
                return ANTERIOR_THORAX;
            case 13:
                return BACK;
            case 14:
                return ANTERIOR_SURFACE_OF_THE_ABDOMINAL_WALL;
            case 15:
                return LUMBAR_REGION;
            case 16:
                return GROIN;
            case 17:
                return VULVA;
            case 18:
                return GLUTEAL_REGION;
            case 19:
                return PERINEUM;
            case 20:
                return LOWER_LIMB;
            case 21:
                return THIGH_AREA;
            case 22:
                return SHIN;
            case 23:
                return PLANTAR_SURFACE_OF_THE_FOOT;
            case 24:
                return FINGER_NAIL_PLATE_OF_THE_LOWER_LIMB;
        }
        return null;
    }

}
