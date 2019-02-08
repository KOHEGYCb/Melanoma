package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum Device {
    DERMATOSCOP(0, "Dermatoscop"),
    CAMERA(1, "Camera");

    private int id;
    private String name;

    private Device(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    
    public String getName(){
        return name;
    }

    public static Device setDevice(int id) {
        switch (id) {
            case 0:
                return DERMATOSCOP;
            case 1:
                return CAMERA;
        }
        return null;
    }

}
