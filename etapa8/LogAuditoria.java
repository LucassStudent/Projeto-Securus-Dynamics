package service;

import java.time.LocalDateTime;
import java.security.MessageDigest;

public class LogAuditoria {
    private static final String ALGORITMO = "SHA-256";

    public static void registrar(String acao, int operadorId, String detalhes) {
        String hash = gerarHash(acao + operadorId + detalhes + LocalDateTime.now());
        System.out.println("[AUDITORIA] " + acao + " | Operador: " + operadorId + " | Hash: " + hash);
        // Persistir em BD imutável
    }

    private static String gerarHash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance(ALGORITMO);
            byte[] hash = digest.digest(input.getBytes());
            StringBuilder hex = new StringBuilder();
            for (byte b : hash) hex.append(String.format("%02x", b));
            return hex.toString();
        } catch (Exception e) {
            return "ERRO_HASH";
        }
    }
}
