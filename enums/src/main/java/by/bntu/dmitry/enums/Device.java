package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum Device {
    DERMATOSCOP(1),
    CAMERA(2);

    private int id;

    private Device(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Device setDevice(int id) {
        switch (id) {
            case 1:
                return DERMATOSCOP;
            case 2:
                return CAMERA;
        }
        return null;
    }

}
