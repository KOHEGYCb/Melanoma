package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum Sex {
    
    MALE(1),
    SHEMALE(2);
    
    private int id;
    
    private Sex (int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    public static Sex setSex(int id){
        switch(id){
            case 1:
                return MALE;
            case 2:
                return SHEMALE;
        }
        return null;
    }
            
    
}
