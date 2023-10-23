package decoding;
import static IO.TxtReader.readFile;

public class HuffmanDecoder {
    public static void ex(String filename){
        String fileContent = readFile(filename);

        System.out.println("File Content:");
        System.out.println(fileContent);
    }
}
