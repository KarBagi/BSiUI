package encoding;

import java.util.*;

import static IO.TxtReader.readFile;

public class HuffmanEncoder {
    private String stringToCode, sortedUniqueChar, fileName;

    public System encodedCode;

    //public List<String> encodedString = new ArrayList<>();

    private void crateCode() {
        
    }

    private void encodeDictionary(){
        fileRead("C:\\Users\\karol\\GitHub\\BSiUI\\Huffman_coding\\src\\IO\\" + fileName);
        sortUniqueCharacters(stringToCode);

        Map<Character, String> letterToBinaryMap = new HashMap<>();
        String binary = "00";

        for (int i = 1; i <= sortedUniqueChar.length()-1; i++) {
            char letter = sortedUniqueChar.charAt(i);
            letterToBinaryMap.put(letter, binary);
            binary = incrementBinary(binary);
        }
    }

    public static String incrementBinary(String binary) {
        int value = Integer.parseInt(binary, 2); // Konwertuj na liczbę całkowitą
        value++; // Inkrementuj
        binary = Integer.toBinaryString(value); // Konwertuj z powrotem na wartość binarną
        while (binary.length() < 2) {
            binary = "0" + binary; // Dodaj wiodące zera, jeśli to konieczne
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
