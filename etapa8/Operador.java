package model;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Operador {
    private int id;
    private String nome;
    private String email;
    private String hashSenha;
    private boolean nivelAcesso;
    private boolean mfaHabilitado;
    private byte[] credBiometrica;
    private String tokenSessao;
    private LocalDateTime ultimaAutenticacao;

    public Operador() {}

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getHashSenha() { return hashSenha; }
    public void setHashSenha(String hashSenha) { this.hashSenha = hashSenha; }

    public boolean isNivelAcesso() { return nivelAcesso; }
    public void setNivelAcesso(boolean nivelAcesso) { this.nivelAcesso = nivelAcesso; }

    public boolean isMfaHabilitado() { return mfaHabilitado; }
    public void setMfaHabilitado(boolean mfaHabilitado) { this.mfaHabilitado = mfaHabilitado; }

    public byte[] getCredBiometrica() { return credBiometrica; }
    public void setCredBiometrica(byte[] credBiometrica) { this.credBiometrica = credBiometrica; }

    public String getTokenSessao() { return tokenSessao; }
    public void setTokenSessao(String tokenSessao) { this.tokenSessao = tokenSessao; }

    // Métodos de segurança
    public boolean autenticar(String senha, String mfaToken) {
        // Simulação de autenticação + MFA
        boolean senhaOk = senha != null && hashSenha != null; // Em produção usar BCrypt
        boolean mfaOk = mfaHabilitado ? (mfaToken != null) : true;
        return senhaOk && mfaOk;
    }

    public void encerrarSessao() {
        this.tokenSessao = null;
    }
}
