package IO;

import java.io.FileWriter;
import java.io.IOException;

public class TxtWriter {
    public static void codeWriter(String codedStringToString, String codedString) {
        String oneChar = "";
        int intValue;
        char character;

        for (int i = 0; i <= codedStringToString.length() - 1; i = i + 8) {
            for (int j = 0; j < 8; j++){
                oneChar = oneChar + codedStringToString.charAt(i + j);
            }

            intValue = Integer.parseInt(oneChar, 2);
            character = (char) intValue;

            codedString = codedString + character;

            oneChar = "";
        }



        try {
            FileWriter writer = new FileWriter("C:\\Users\\karol\\GitHub\\BSiUI\\Huffman_coding\\src\\IO\\Examples\\codedExample.txt");
            writer.write(codedString);
            writer.close();

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
