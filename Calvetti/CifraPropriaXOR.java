import java.io.*;


public class CifraPropriaXOR {


    private static final int CHAVE_SECRETA = 85;

    public static void main(String[] args) {
        String textoClaro = "O segredo do projeto eh manter o sigilo.";

        System.out.println("Texto Original: " + textoClaro);

        try {

            byte[] cifrado = cifrarXOR(textoClaro.getBytes(), CHAVE_SECRETA);
            System.out.println("Texto Cifrado (Bytes): " + new String(cifrado));


            byte[] decifrado = decifrarXOR(cifrado, CHAVE_SECRETA);
            System.out.println("Texto Decifrado: " + new String(decifrado));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static byte[] cifrarXOR(byte[] texto, int chave) {
        byte[] resultado = new byte[texto.length];
        for (int i = 0; i < texto.length; i++) {

            resultado[i] = (byte) (texto[i] ^ chave);
        }
        return resultado;
    }

    public static byte[] decifrarXOR(byte[] textoCifrado, int chave) {
        byte[] resultado = new byte[textoCifrado.length];
        for (int i = 0; i < textoCifrado.length; i++) {
            // Aplica a mesma operação XOR
            resultado[i] = (byte) (textoCifrado[i] ^ chave);
        }
        return resultado;
    }
}