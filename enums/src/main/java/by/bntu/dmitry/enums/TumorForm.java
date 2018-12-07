package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum TumorForm {

    FLAT(1, "Плоская"),
    TUBEROUS(2, "Бугристая"),
    NODULAR(3, "Узловая"),
    HEMISPHERICAL(4, "Полусферическая"),
    MUSHROOM_SHAPED(5, "Грибовидная");

    private int id;
    private String name;

    private TumorForm(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    
    public String getName(){
        return name;
    }

    public static TumorForm setTumorForm(int id){
        switch(id){
            case 1:
                return FLAT;
            case 2:
                return TUBEROUS;
            case 3:
                return NODULAR;
            case 4:
                return HEMISPHERICAL;
            case 5:
                return MUSHROOM_SHAPED;
        }        
        return null;
    }
        
}
