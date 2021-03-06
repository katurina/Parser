import exception.ReadException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Bird on 04.03.2017.
 */
public class Parser implements ReadSource{
    private final String fileName;
    private List<String> list = new ArrayList<>();


    public Parser(String filename) {
        this.fileName = filename;
    }

    public void readUsingBufferedReader() throws IOException {
        File file = new File(fileName);
        try {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            parseLine(line);
        }

            close(br, fr);
        } catch (IOException e) {
        }
        for (String k : list) {
            System.out.println(k);
        }

    }

    public void close(BufferedReader br, FileReader fr) throws IOException{
        br.close();
        fr.close();
    }

    private boolean iterator = false;
    private String helpLine;
    private static final Pattern TAG_PATTERN = Pattern.compile("<.*[^>^<]>");
    private static final Pattern TAG2_PATTERN = Pattern.compile("\\s*<.*>.*</.*>");

    public void parseLine(String line) {

        if (TAG_PATTERN.matcher(line).matches()) {
            if (iterator) {
                list.add(helpLine);
                helpLine = "";
                iterator = false;
            }
            line = line.substring(line.indexOf('<'), line.length());
            list.add(line);

        } else if (TAG2_PATTERN.matcher(line).matches()) {
            if (iterator) {
                list.add(helpLine);
                helpLine = "";
                iterator = false;
            }

            list.add(line.substring(line.indexOf('<'), line.indexOf('>') + 1));
            line = line.substring((line.indexOf('>') + 1), line.length());
            list.add(line.substring(0, line.indexOf('<')));
            line = line.substring(line.indexOf('<'), line.length());
            list.add(line);

        } else {
            iterator = true;
            if (helpLine == null) {
                helpLine = line;
            } else {
                helpLine += line;
            }
        }
    }
}