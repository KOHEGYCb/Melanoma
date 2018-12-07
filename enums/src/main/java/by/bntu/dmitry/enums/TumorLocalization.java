package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum TumorLocalization {
   
    SCALP(0, "Волосистая часть головы"),
    FACE(1, "Лицо"),
    ORGAN_OF_VISION(2, "Орган зрения "),
    ORAL_MUCOSA(3, "Слизистая оболочка полости рта"),
    NASAL_MUCOSA(4, "Слизистая оболочка полости носа"),
    MUCOSA_OF_THE_PARANASAL_SINUSES(5, "Слизистая оболочка околоносовых пазух"),
    NECK(6, "Neck"),
    SHOULDER_GIRDLE(7, "Плечевой пояс"),
    AXILLARY_REGION(8, "Подмышечная область"),
    UPPER_EXTREMITY(9, "Верхняя конечность"),
    PALM(10, "Ладони"),
    FINGER_NALL_PLATE_OF_THE_UPPER_LIMB(11, "Ногтевые пластинки пальцев верхней конечности"),
    ANTERIOR_THORAX(12, "Передняя поверхность грудной клетки"),
    BACK(13, "Спина"),
    ANTERIOR_SURFACE_OF_THE_ABDOMINAL_WALL(14, "Передняя поверхность брюшной стенки"),
    LUMBAR_REGION(15, "Поясничная область"),
    GROIN(16, "Паховая область"),
    VULVA(17, "Наружные половые органы"),
    GLUTEAL_REGION(18, "Ягодичная область"),
    PERINEUM(19, "Промежность"),
    LOWER_LIMB(20, "Нижняя конечность"),
    THIGH_AREA(21, "Область бедра"),
    SHIN(22, "Голень"),
    PLANTAR_SURFACE_OF_THE_FOOT(23, "Подошвенная поверхность стопы"),
    FINGER_NAIL_PLATE_OF_THE_LOWER_LIMB(24, "Ногтевые пластинки нижней конечности");

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
