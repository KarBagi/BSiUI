package IO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TxtReader {

    public static String readFile(String fileName) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)) ) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }

}
