package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum DurationIllness {

    NO_INFO_ABOUT_CHANGES(1),
    CHANGES_IN_CLINICAL_PICTURE(2),
    NO_CHANGES_DURING_3_MONTH(3);

    private int id;

    private DurationIllness(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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
