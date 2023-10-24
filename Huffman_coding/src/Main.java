import decoding.HuffmanDecoder;
import encoding.HuffmanEncoder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*String fileName;
        Scanner scanner = new Scanner(System.in);

        fileName = scanner.nextLine();*/

        HuffmanEncoder h = new HuffmanEncoder();
        h.setFileName("ex1.txt");
        h.encodeString();

    }
}
