package control;

import model.*;

public class SistemaControle {
    private String enderecoIP;
    private String statusServidor;
    private String versao;
    private List<Drone> dronesFrota;

    public boolean autenticarOperador(Operador op, String senha, String mfa) {
        boolean autenticado = op.autenticar(senha, mfa);
        if (autenticado) {
            LogAuditoria.registrar("LOGIN", op.getId(), "Autenticação bem-sucedida");
        }
        return autenticado;
    }

    public void planejarMissao(Missao missao) {
        // Lógica de planejamento
    }

    public void enviarComando(Drone drone, String comando) {
        System.out.println("Enviando comando: " + comando + " para drone " + drone.getId());
    }

    public void monitorarTelemetria() {
        // Loop de monitoramento
    }
}
