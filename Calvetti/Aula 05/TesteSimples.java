
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


public class TesteSimples {

    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey chaveAES = keyGen.generateKey();
        Cipher cipherAES = Cipher.getInstance("AES");

        cipherAES.init(Cipher.ENCRYPT_MODE, chaveAES);
        byte[] cifrado = cipherAES.doFinal("Mensagem de teste AES".getBytes());

        cipherAES.init(Cipher.DECRYPT_MODE, chaveAES);
        byte[] decifrado = cipherAES.doFinal(cifrado);

        System.out.println("AES Decifrado: " + new String(decifrado));

    }
}