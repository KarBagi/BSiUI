import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.Key;
import java.util.Base64;

public class Main {

    public static void main(String[] args) {
        String key = "MySecretKey12345"; // Klucz szyfrowania (zmień na swój sekretny klucz)
        String inputFile = "C:\\Users\\karol\\GitHub\\BSiUI\\Huffman_coding\\src\\IO\\Examples\\ex1.txt";
        String encryptedFile = "encrypted.txt";
        String decryptedFile = "decrypted.txt";

        try {
            // Szyfrowanie
            encrypt(key, inputFile, encryptedFile);

            // Odszyfrowywanie
            decrypt(key, encryptedFile, decryptedFile);

            System.out.println("Szyfrowanie i odszyfrowywanie zakończone pomyślnie.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void encrypt(String key, String inputFile, String outputFile) throws Exception {
        Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        FileInputStream inputStream = new FileInputStream(inputFile);
        byte[] inputBytes = new byte[(int) new File(inputFile).length()];
        inputStream.read(inputBytes);

        byte[] outputBytes = cipher.doFinal(inputBytes);

        FileOutputStream outputStream = new FileOutputStream(outputFile);
        outputStream.write(outputBytes);

        inputStream.close();
        outputStream.close();
    }

    public static void decrypt(String key, String inputFile, String outputFile) throws Exception {
        Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        FileInputStream inputStream = new FileInputStream(inputFile);
        byte[] inputBytes = new byte[(int) new File(inputFile).length()];
        inputStream.read(inputBytes);

        byte[] outputBytes = cipher.doFinal(inputBytes);

        FileOutputStream outputStream = new FileOutputStream(outputFile);
        outputStream.write(outputBytes);

        inputStream.close();
        outputStream.close();
    }
}
