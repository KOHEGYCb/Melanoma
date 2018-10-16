package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum TumorSurface {

    SMOOTH(1),
    TUBEROSITY(2),
    FINE_GRAINED(3),
    WITH_KERATOSIS(4),
    MOIST(5);

    private int id;

    private TumorSurface(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static TumorSurface setTumorSurface(int id) {
        switch (id) {
            case 1:
                return SMOOTH;
            case 2:
                return TUBEROSITY;
            case 3:
                return FINE_GRAINED;
            case 4:
                return WITH_KERATOSIS;
            case 5:
                return MOIST;
        }
        return null;
    }

}
