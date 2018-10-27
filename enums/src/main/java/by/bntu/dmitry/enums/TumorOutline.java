package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum TumorOutline {

    CLEAR(1),
    FUZZY(2);

    private final int id;

    private TumorOutline(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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
