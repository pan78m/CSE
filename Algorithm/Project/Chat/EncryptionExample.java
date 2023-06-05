 
 import javax.crypto.Cipher;
 import javax.crypto.spec.SecretKeySpec;
 import java.util.Base64;
 import java.util.Scanner;
 
 public class EncryptionExample {
     private static final String SECRET_KEY = "1234567891234567"; // Replace with your secret key
 
     public static String encrypt(String message) throws Exception {
         SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
         Cipher cipher = Cipher.getInstance("AES");
         cipher.init(Cipher.ENCRYPT_MODE, secretKey);
         byte[] encryptedBytes = cipher.doFinal(message.getBytes());
         return Base64.getEncoder().encodeToString(encryptedBytes);
     }
 
     public static String decrypt(String encryptedMessage) throws Exception {
         SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
         Cipher cipher = Cipher.getInstance("AES");
         cipher.init(Cipher.DECRYPT_MODE, secretKey);
         byte[] encryptedBytes = Base64.getDecoder().decode(encryptedMessage);
         byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
         return new String(decryptedBytes);
     }
 
     public static void main(String[] args) {
         try {
             Scanner scanner = new Scanner(System.in);
 
             System.out.print("Enter a message to encrypt: ");
             String message = scanner.nextLine();
             scanner.close();
             String encryptedMessage = encrypt(message);
             System.out.println("Encrypted message: " + encryptedMessage);
 
             System.out.print("Enter the encrypted message to decrypt: ");
             String encryptedInput = scanner.nextLine();
 
             String decryptedMessage = decrypt(encryptedInput);
             System.out.println("Decrypted message: " + decryptedMessage);
         } catch (Exception e) {
             e.printStackTrace();
         }
     }//09uZPhdw/K1EXaXXWPCocUERYoE4fabDpnpgkAYVu9M=
 }
 