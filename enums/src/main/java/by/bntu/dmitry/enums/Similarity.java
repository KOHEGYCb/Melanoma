package by.bntu.dmitry.enums;

/**
 *
 * @author dmitry
 */
public enum Similarity {
    
//    _0_1("the probability of melanoma is small"),
//    _2("there is a risk of melanoma"),
//    _3_4("high risk of melanoma"),
//    NONE("undefined");
    _0_1("The probability of melanoma is small"),
    _2("There is a risk of melanoma"),
    _3_4("High risk of melanoma"),
    NONE("undefined");
    
    String desc;
    
    private Similarity(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
}
