package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum TumorOutline {

    clear(1),
    fuzzy(2);

    private int id;

    private TumorOutline(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public  static TumorOutline setTumorOutline(int id) {
        switch (id) {
            case 1:
                return clear;
            case 2:
                return fuzzy;
        }
        return null;
    }
}
