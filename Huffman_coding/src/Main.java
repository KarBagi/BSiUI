import decoding.HuffmanDecoder;
import encoding.HuffmanEncoder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HuffmanEncoder e = new HuffmanEncoder();
        HuffmanDecoder d = new HuffmanDecoder();
        /*String fileName;
        Scanner scanner = new Scanner(System.in);

        fileName = scanner.nextLine();*/

        e.setFileName("ex1.txt");
        e.encodeString();

        d.decoder();

    }
}
