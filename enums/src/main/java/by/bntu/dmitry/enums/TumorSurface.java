package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum TumorSurface {

    SMOOTH(1, "Гладкая"),
    TUBEROSITY(2, "Бугристая"),
    FINE_GRAINED(3, "Мелкозернистая"),
    WITH_KERATOSIS(4, "С кератозом"),
    MOIST(5, "Мокнущая");

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
