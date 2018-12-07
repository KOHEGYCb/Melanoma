package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum Sex {
    
    MALE(0, "Мужской"),
    FEMALE(1, "Женский");
    
    private int id;
    private String name;
    
    private Sex (int id, String name){
        this.id = id;
        this.name = name;
    }
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public static Sex setSex(int id){
        switch(id){
            case 0:
                return MALE;
            case 1:
                return FEMALE;
        }
        return null;
    }
            
    
}
