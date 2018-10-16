package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum DiagnosisPreliminary {
    
    PIGMENTAL_NEVUS(1),
    ATYPICAL_NEVUS(2),
    MELANOMA_IS_SUSPECTED(3),
    KERATOS(4);
    
    private int id;

    private DiagnosisPreliminary(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public static DiagnosisPreliminary setDiagnosisPreliminary(int id){
        switch(id){
            case 1:
                return PIGMENTAL_NEVUS;
            case 2:
                return ATYPICAL_NEVUS;
            case 3:
                return MELANOMA_IS_SUSPECTED;
            case 4:
                return KERATOS;
        }
        return null;
    }
    
}
