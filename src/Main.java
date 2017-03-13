import java.io.IOException;

/**
 * Created by Bird on 04.03.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Parser parserXML=new Parser("C:\\Users\\Bird\\IdeaProjects\\Parser\\res\\food.xml");
        parserXML.readUsingBufferedReader();

    }
}

