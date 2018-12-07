package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum TumorLocalization {
   
    SCALP(1, "Волосистая часть головы"),
    FACE(2, "Лицо"),
    ORGAN_OF_VISION(3, "Орган зрения "),
    ORAL_MUCOSA(4, "Слизистая оболочка полости рта"),
    NASAL_MUCOSA(5, "Слизистая оболочка полости носа"),
    MUCOSA_OF_THE_PARANASAL_SINUSES(6, "Слизистая оболочка околоносовых пазух"),
    NECK(7, "Neck"),
    SHOULDER_GIRDLE(8, "Плечевой пояс"),
    AXILLARY_REGION(9, "Подмышечная область"),
    UPPER_EXTREMITY(10, "Верхняя конечность"),
    PALM(11, "Ладони"),
    FINGER_NALL_PLATE_OF_THE_UPPER_LIMB(12, "Ногтевые пластинки пальцев верхней конечности"),
    ANTERIOR_THORAX(13, "Передняя поверхность грудной клетки"),
    BACK(14, "Спина"),
    ANTERIOR_SURFACE_OF_THE_ABDOMINAL_WALL(15, "Передняя поверхность брюшной стенки"),
    LUMBAR_REGION(16, "Поясничная область"),
    GROIN(17, "Паховая область"),
    VULVA(18, "Наружные половые органы"),
    GLUTEAL_REGION(19, "Ягодичная область"),
    PERINEUM(20, "Промежность"),
    LOWER_LIMB(21, "Нижняя конечность"),
    THIGH_AREA(22, "Область бедра"),
    SHIN(23, "Голень"),
    PLANTAR_SURFACE_OF_THE_FOOT(24, "Подошвенная поверхность стопы"),
    FINGER_NAIL_PLATE_OF_THE_LOWER_LIMB(25, "Ногтевые пластинки нижней конечности");

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
