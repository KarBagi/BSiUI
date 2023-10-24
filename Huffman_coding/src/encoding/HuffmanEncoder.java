package encoding;

import java.util.*;

import static IO.TxtReader.readFile;

public class HuffmanEncoder {
    private String stringToCode, sortedUniqueChar, fileName, codedString, codedStringToCode = "", binaryModulo;
    private int modulo;
    private BitSet bitSets = new BitSet();
    private Map<Character, String> letterToBinaryMap = new HashMap<>();

    public void encodeString() {
        encodeDictionary();

        codedString = Integer.toString(sortedUniqueChar.length()) + sortedUniqueChar;

        for (int i = 0; i < stringToCode.length() - 1; i++) {
            codedStringToCode = codedStringToCode + letterToBinaryMap.get(stringToCode.charAt(i));
        }

        modulo = codedStringToCode.length() % 8;

        if (modulo != 0){
            modulo = 8 - modulo - 3;

            binaryModulo = Integer.toBinaryString(modulo);

            while (binaryModulo.length() < 3) {
                binaryModulo = "0" + binaryModulo;
            }

            StringBuilder builder = new StringBuilder(binaryModulo);
            builder.append(codedStringToCode);
            codedStringToCode = builder.toString();

            while (modulo != 0) {
                codedStringToCode = codedStringToCode + "0";
                modulo--;
            }
        }

        System.out.println(codedStringToCode.length());
    }

    private void encodeDictionary(){
        fileRead("C:\\Users\\karol\\GitHub\\BSiUI\\Huffman_coding\\src\\IO\\" + fileName);
        sortUniqueCharacters(stringToCode);

        String binary = "00";

        for (int i = 1; i <= sortedUniqueChar.length()-1; i++) {
            char letter = sortedUniqueChar.charAt(i);
            letterToBinaryMap.put(letter, binary);
            binary = incrementBinary(binary);
        }
    }

    public static String incrementBinary(String binary) {
        int value = Integer.parseInt(binary, 2);
        value++;
        binary = Integer.toBinaryString(value);
        while (binary.length() < 2) {
            binary = "0" + binary;
        }
        return binary;
    }

    private String sortUniqueCharacters(String stringToCode) {
        TreeSet<Character> characterSet = new TreeSet<>();

        for (int i = 0; i < stringToCode.length(); i++) {
            characterSet.add(stringToCode.charAt(i));
        }

        StringBuilder sortedUniqueChars = new StringBuilder();

        for (char c : characterSet) {
            sortedUniqueChars.append(c);
        }

        sortedUniqueChar = sortedUniqueChars.toString();

        return sortedUniqueChar;
    }

    private void fileRead(String fileName){
            stringToCode = readFile(fileName);
    }

    public void setFileName(String filename) {
        fileName = filename;
    }
}
