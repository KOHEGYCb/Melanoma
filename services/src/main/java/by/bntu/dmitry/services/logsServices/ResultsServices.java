package by.bntu.dmitry.services.logsServices;

import by.bntu.dmitry.enums.ABCDE;
import by.bntu.dmitry.enums.Probability;
import by.bntu.dmitry.enums.Similarity;

/**
 *
 * @author user
 */
public class ResultsServices {
    
    public static ABCDE getABCDE(double abcde){
        if (abcde <= 4.75){
            return ABCDE._4_75;
        }
        if (abcde > 4.75 && abcde <= 5.45){
            return ABCDE._4_75_5_45;
        }
        if (abcde > 5.45){
            return ABCDE._5_45;
        }
        return ABCDE.NONE;
    }
    
    public static Probability getProbability(int probobility){
        if (probobility <= 15){
            return Probability._0_15;
        }
        if (probobility > 15 && probobility <= 25){
            return Probability._15_25;
        }
        if (probobility > 25){
            return Probability._25_100;
        }
        return Probability.NONE;
    }
    
    public static Similarity getSimilarity(int similarity){
        if (similarity == 1){
            return Similarity._0_1;
        }
        if (similarity == 2){
            return Similarity._2;
        }
        if (similarity > 2){
            return Similarity._3_4;
        }
        return Similarity.NONE;
    }
    
}
