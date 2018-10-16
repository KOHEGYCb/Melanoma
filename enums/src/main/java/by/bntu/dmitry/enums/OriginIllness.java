package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum OriginIllness {

    INNATE(1),
    OBTAINED(2);

    private int id;

    private OriginIllness(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static OriginIllness setOriginIllness(int id) {
        switch (id) {
            case 1:
                return INNATE;
            case 2:
                return OBTAINED;
            default:
                return null;
        }
    }

}
