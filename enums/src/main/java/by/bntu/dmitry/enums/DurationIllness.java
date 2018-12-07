package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum DurationIllness {

    NO_INFO_ABOUT_CHANGES(1, "Нет сведений об изменениях"),
    CHANGES_IN_CLINICAL_PICTURE(2, "Изменение клинического очага картины"),
    NO_CHANGES_DURING_3_MONTH(3, "Отсутствие изменений в течение 3-ех месяцев");

    private int id;
    private String name;

    private DurationIllness(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public static DurationIllness setDurationIllness(int id){
        switch(id){
            case 1:
                return NO_INFO_ABOUT_CHANGES;
            case 2:
                return CHANGES_IN_CLINICAL_PICTURE;
            case 3:
                return NO_CHANGES_DURING_3_MONTH;
        }
        return null;
    }
    
}
