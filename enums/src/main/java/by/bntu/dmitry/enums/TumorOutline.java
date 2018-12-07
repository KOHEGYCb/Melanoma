package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum TumorOutline {

    CLEAR(1, "четкие"),
    FUZZY(2, "нечеткие");

    private final int id;
    private String name;

    private TumorOutline(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    
    public String getName(){
        return name;
    }

    public  static TumorOutline setTumorOutline(int id) {
        switch (id) {
            case 1:
                return CLEAR;
            case 2:
                return FUZZY;
        }
        return null;
    }
}
