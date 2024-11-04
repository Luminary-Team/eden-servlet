package Security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class VerificationInfomation {
    // Método para validar o Nome Completo
    // Nome completo
    // Nome completo
    public static boolean validarNome(String name) {
        return Pattern.matches("^[A-Za-zÀ-ÿ\\s]+$", name);
    }

    // Email
    public static boolean validarEmail(String email) {
        return Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", email);
    }

    // Senha
    public static boolean validarSenha(String password) {
        return Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,}$", password);
    }



    public static String hashSenha(String password) {
        try {
            // Inicializar o algoritmo SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Converter a senha para bytes e gerar o hash
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            // Retornar o hash já convertido para hexadecimal
            return bytesToHex(encodedHash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);  // Em caso de erro
        }
    }

    // Método simplificado para converter os bytes para hexadecimal
    public static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();

        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static String validation(String name, String email, String senha) {
        if (!validarNome(name)) {
            return "Nome inválido! Deve começar com maiúscula e ter pelo menos um sobrenome.";
        }
        if (!validarEmail(email)) {
            return "Email inválido! Deve seguir o padrão com @ e .com ou .org.";
        }
        if (!validarSenha(senha)) {
            return "Senha inválida! Deve ter no mínimo 8 caracteres e pelo menos um caractere especial.";
        }

        // Codificação dos dados
        return hashSenha(senha);  // Retorna o hash da senha
    }
}