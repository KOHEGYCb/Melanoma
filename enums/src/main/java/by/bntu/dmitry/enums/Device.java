package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum Device {
    DERMATOSCOP(1, "Дерматоскоп"),
    CAMERA(2, "Фотокамера");

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
            case 1:
                return DERMATOSCOP;
            case 2:
                return CAMERA;
        }
        return null;
    }

}
