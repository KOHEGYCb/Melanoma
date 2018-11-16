package by.bntu.dmitry.enums;

/**
 *
 * @author user
 */
public enum ABCDE {
    
    _4_75("benign neoplasm"),
    _4_75_5_45("there is a risk of melanoma"),
    _5_45("high risk of melanoma"),
    NONE("undefined");
    
    String desc;
    
    private ABCDE(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
}
