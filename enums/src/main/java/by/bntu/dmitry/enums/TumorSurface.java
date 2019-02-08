package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum TumorSurface {

    SMOOTH(0, "Smooth"),
    TUBEROSITY(1, "Tuberosity"),
    FINE_GRAINED(2, "Fine grained"),
    WITH_KERATOSIS(3, "With keratosis"),
    MOIST(4, "Moist");

    private int id;
    private String name;

    private TumorSurface(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    
    public String getName(){
        return name;
    }

    public static TumorSurface setTumorSurface(int id) {
        switch (id) {
            case 0:
                return SMOOTH;
            case 1:
                return TUBEROSITY;
            case 2:
                return FINE_GRAINED;
            case 3:
                return WITH_KERATOSIS;
            case 4:
                return MOIST;
        }
        return null;
    }

}
