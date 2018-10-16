package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum Role {
    
    USER(0),
    DOCTOR(1),
    ADMIN(2);
    
    private final int id;

    private Role(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public static Role setRole(int id){
        switch(id){
            case 0:
                return USER;
            case 1:
                return DOCTOR;
            case 2:
                return ADMIN;
        }
        return null;
    }
    
}
