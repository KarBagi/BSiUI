package decoding;

import IO.TxtReader;

import java.util.HashMap;
import java.util.Map;

public class HuffmanDecoder {
    private String codedString, binary, decodedString = "", addedBits, binaryChars, oneChar = "";

    private int addedInt;
    private HashMap<Character, String> codes = new HashMap<>();

    public void decoder() {
        codedFileReader();

        int charactersInSet = Integer.parseInt(String.valueOf(codedString.charAt(0)));;

        for (int i = 0; i < charactersInSet; i++) {
            if(i < 2) {
                codes.put(codedString.charAt(i + 1), "0" + Integer.toBinaryString(i));
            }
            else {
                codes.put(codedString.charAt(i + 1), Integer.toBinaryString(i));
            }
        }

        StringBuilder builder = new StringBuilder(codedString);

        int start = 0;
        int end = charactersInSet;

        builder.delete(start, end + 1);
        String codedTextWHDictionary = builder.toString();



        StringBuilder builder1 = new StringBuilder();

        for (char c : codedTextWHDictionary.toCharArray()) {
            int AsciiCode = (int) c;
            binary = Integer.toBinaryString(AsciiCode);

            while (binary.length() < 8) {
                binary = "0" + binary;
            }

            if(binary.equals("00001010"))    break;

            builder1.append(binary);
        }

        start = 0; // Indeks początku podłańcucha
        end = 2; // Indeks końca podłańcucha
        addedBits = builder1.substring(start, end + 1);

        addedInt = Integer.parseInt(addedBits, 2);

        start = 0;
        end = builder1.length() - addedInt;

        binaryChars = builder1.substring(start, end);

        System.out.println(binaryChars);

        for (int i = 0; i < binaryChars.length() - 1; i = i +2) {

            oneChar = oneChar + binaryChars.charAt(i) + binaryChars.charAt(i+1);

            /*for(int j = 0; j < codes.size(); j++){

            }

            for(Map.Entry<Character, String> code : codes.entrySet()){
                if(oneChar.equals(code.getValue())){
                    decodedString = decodedString + code.getKey().toString();
                }
                else {System.out.println("dupa");}
            }
            oneChar = "";*/

        }
        System.out.println(oneChar);
    }

    private void codedFileReader() {
        codedString = TxtReader.readFile("C:\\Users\\karol\\GitHub\\BSiUI\\Huffman_coding\\src\\IO\\Examples\\codedExample.txt");
    }

}
