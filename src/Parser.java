import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by Bird on 04.03.2017.
 */
public class Parser {
    private final String fileName;
    private ArrayList<String> list = new ArrayList<>();
    private String helpLine;

    public Parser(String filename) {
        this.fileName = filename;
    }

    public void readUsingBufferedReader() throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            parseLine(line);
        }
        br.close();
        fr.close();
        for (String k : list) {
            System.out.println(k);
        }

    }

    public void parseLine(String line) {
        if (Pattern.matches("<.*[a-zA-Z0-9\"/\\.\\?]>", line)) {
            list.add(line);
        }
        if (Pattern.matches("<.*>.*</.*>",line)){
            list.add(line);
        }
        helpLine += line;
    }
}
