package by.bntu.dmitry.enums;

/**
 *
 * @author user
 */
public enum Probability {

    _0_15("the probability of melanoma is small"),
    _15_25("there is a risk of melanoma"),
    _25_100("high risk of melanoma"),
    NONE("undefined");
    
    String desc;
    
    private Probability(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
