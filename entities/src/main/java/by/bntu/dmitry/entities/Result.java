package by.bntu.dmitry.entities;

import by.bntu.dmitry.enums.ABCDE;
import by.bntu.dmitry.enums.Probability;
import by.bntu.dmitry.enums.Similarity;
import java.util.ArrayList;

/**
 *
 * @author dmitry
 */
public class Result {
    
    private Probability probability;
    private ABCDE abcde;
    private Similarity similarity;
    private ArrayList<String> sim = new ArrayList<>();
    private int arg;
    private int menz;
    private String directory;

    public Result() {
        this.abcde = ABCDE.NONE;
        this.arg = -1;
        this.menz = -1;
        this.probability = Probability.NONE;
        this.similarity = Similarity.NONE;
    }

    public Result(Probability probability, ABCDE abcde, Similarity similarity, int arg, int menz) {
        this.probability = probability;
        this.abcde = abcde;
        this.similarity = similarity;
        this.arg = arg;
        this.menz = menz;
    }

    public Probability getProbability() {
        return probability;
    }

    public void setProbability(Probability probability) {
        this.probability = probability;
    }

    public ABCDE getAbcde() {
        return abcde;
    }

    public void setAbcde(ABCDE abcde) {
        this.abcde = abcde;
    }

    public Similarity getSimilarity() {
        return similarity;
    }

    public void setSimilarity(Similarity similarity) {
        this.similarity = similarity;
    }

    public ArrayList<String> getSim() {
        return sim;
    }

    public void setSim(ArrayList<String> sim) {
        this.sim = sim;
    }

    public int getArg() {
        return arg;
    }

    public void setArg(int arg) {
        this.arg = arg;
    }

    public int getMenz() {
        return menz;
    }

    public void setMenz(int menz) {
        this.menz = menz;
    }

    @Override
    public String toString() {
        return "Result{" + "probability=" + probability + ", abcde=" + abcde + ", similarity=" + similarity + ", sim=" + sim + ", arg=" + arg + ", menz=" + menz + ", directory=" + directory + '}';
    }

    

    /**
     * @return the directory
     */
    public String getDirectory() {
        return directory;
    }

    /**
     * @param directory the directory to set
     */
    public void setDirectory(String directory) {
        this.directory = directory;
    }
    
}
