package by.bntu.dmitry.enums;

/**
 *
 * @author user
 */
public enum Similarity {
    
//    _0_1("the probability of melanoma is small"),
//    _2("there is a risk of melanoma"),
//    _3_4("high risk of melanoma"),
//    NONE("undefined");
    _0_1("вероятность меланомы небольшая"),
    _2("есть риск меланомы"),
    _3_4("высокий риск меланомы"),
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
