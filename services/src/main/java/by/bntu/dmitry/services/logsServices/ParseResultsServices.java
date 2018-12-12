package by.bntu.dmitry.services.logsServices;

import by.bntu.dmitry.constants.ConfigConstants;
import by.bntu.dmitry.dao.FotoDAO;
import by.bntu.dmitry.entities.Foto;
import by.bntu.dmitry.entities.Result;
import by.bntu.dmitry.entities.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author user
 */
public class ParseResultsServices {

    public static Result getResult(Foto foto) throws IOException {
//        System.out.println("\n\nStart Parse File");
        Result result = null;

        String fileName = "";
        boolean isDotFind = false;
        for (int i = foto.getDirectory().length() - 1; i >= 0; i--) {
            if (isDotFind) {
                fileName = foto.getDirectory().charAt(i) + fileName;
            } else {
                if (foto.getDirectory().charAt(i) == '.') {
                    isDotFind = true;
                }
            }
        }
        String path = ConfigConstants.IMAGE_OUTPUT_FOLDER + fileName + ".txt";

        File file = new File(path);
        if (file.isFile()) {
            FileInputStream fis = null;
//            System.out.println("file is found");
            result = new Result();
            try {
                fis = new FileInputStream(file);
                boolean eof = false;
                Map<String, String> map = new HashMap<>();
                String param = "";
                String key = "";
                while (!eof) {
                    int ch = fis.read();
//                    System.out.println(ch + " : "+ (char)ch);
                    switch (ch) {
                        case 10:
                            map.replace(key, param);
                            param = "";
//                            fis.read();
                            break;
                        case -1:
                            eof = true;
                            break;
                        case 61:
                            map.put(param, "");
                            key = param;
                            param = "";
                            break;
                        default:
//                            System.out.println(ch + " : " + (char) ch);
                            param = param + (char) ch;
                            break;
                    }
                }
//                System.out.println(map);
                result.setAbcde(ResultsServices.getABCDE(Double.valueOf(map.get("abcde"))));
//                result.setArg(Integer.valueOf(map.get("arg")));
//                result.setMenz(Integer.valueOf(map.get("menz")));
                result.setProbability(ResultsServices.getProbability(Integer.valueOf(map.get("Probability"))));
                result.setSimilarity(ResultsServices.getSimilarity(Integer.valueOf(map.get("Similarity"))));
                ArrayList<String> sim = new ArrayList<>();
                sim.add(map.get("Sim1"));
                sim.add(map.get("Sim2"));
                sim.add(map.get("Sim3"));
                sim.add(map.get("Sim4"));
                result.setSim(sim);
                
                String directory = "";
                for (int i = 0; i < foto.getDirectory().length(); i++) {
                    directory = directory + foto.getDirectory().charAt(i);
                    if (foto.getDirectory().charAt(i) == '/'){
                        directory = directory + '_';
                    }
                }
                result.setDirectory(directory);
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ParseResultsServices.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (fis != null) {
                    fis.close();
                }
            }
        } else {
//            System.out.println("file is not found");
        }

//        System.out.println("end.\n\n");
        return result;
    }

}
