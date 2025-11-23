import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger;

public class FuncaoHash {

    public static void main(String[] args) throws Exception {

        String mensagemOriginal = "Dados confidenciais para o Bradesco.";

        System.out.println("Mensagem Original: " + mensagemOriginal);
        System.out.println("HASH SHA-256: " + calcularHash(mensagemOriginal));

        String mensagemAlterada = "Dados confidenciais para o Bradesco";
        System.out.println("\n--- Teste de Integridade ---");
        System.out.println("Mensagem Alterada: " + mensagemAlterada);
        System.out.println("NOVO HASH:  " + calcularHash(mensagemAlterada));
    }

    public static String calcularHash(String data) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));

        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));

        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }
}