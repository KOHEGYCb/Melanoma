package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum TumorForm {

    FLAT(1),
    TUBEROUS(2),
    NODULAR(3),
    HEMISPHERICAL(4),
    MUSHROOM_SHAPED(5);

    private int id;

    private TumorForm(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static TumorForm setTumorForm(int id){
        switch(id){
            case 1:
                return FLAT;
            case 2:
                return TUBEROUS;
            case 3:
                return NODULAR;
            case 4:
                return HEMISPHERICAL;
            case 5:
                return MUSHROOM_SHAPED;
        }        
        return null;
    }
        
}
