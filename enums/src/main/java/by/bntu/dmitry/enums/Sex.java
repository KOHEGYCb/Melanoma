package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum Sex {
    
    MALE(1, "Мужской"),
    FEMALE(2, "Женский");
    
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
            case 1:
                return MALE;
            case 2:
                return FEMALE;
        }
        return null;
    }
            
    
}
