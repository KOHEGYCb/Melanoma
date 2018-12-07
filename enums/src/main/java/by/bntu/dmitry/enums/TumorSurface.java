package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum TumorSurface {

    SMOOTH(0, "Гладкая"),
    TUBEROSITY(1, "Бугристая"),
    FINE_GRAINED(2, "Мелкозернистая"),
    WITH_KERATOSIS(3, "С кератозом"),
    MOIST(4, "Мокнущая");

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
