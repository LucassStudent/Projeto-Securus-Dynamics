package model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class SensorCamera extends Sensor {

    private int resolucaoHorizontal;
    private int resolucaoVertical;
    private boolean modoNoturno;
    private boolean gravando;

    public SensorCamera() {
        this.tipo = "CAMERA";
        this.ativo = true;
        this.modoNoturno = false;
        this.gravando = false;
    }

    @Override
    public Map<String, Object> coletar() {
        Map<String, Object> dados = new HashMap<>();
        dados.put("tipo", "CAMERA");
        dados.put("resolucao", resolucaoHorizontal + "x" + resolucaoVertical);
        dados.put("modoNoturno", modoNoturno);
        dados.put("gravando", gravando);
        dados.put("timestamp", LocalDateTime.now());

        this.ultimaLeitura = LocalDateTime.now();

        return dados;
    }

    @Override
    public void calibrar() {
        this.resolucaoHorizontal = 1920;
        this.resolucaoVertical = 1080;
        this.calibradoEm = LocalDateTime.now();
        System.out.println("✅ Sensor Camera calibrado - Resolução: 1920x1080");
    }

    public void ativarModoNoturno() {
        this.modoNoturno = true;
        System.out.println("🌙 Modo noturno da câmera ativado");
    }

    public void iniciarGravacao() {
        this.gravando = true;
        System.out.println("🎥 Gravação iniciada");
    }

    public void pararGravacao() {
        this.gravando = false;
        System.out.println("⏹️ Gravação finalizada");
    }

    @Override
    public boolean getStatus() {
        return ativo;
    }

    // Getters e Setters
    public boolean isModoNoturno() { return modoNoturno; }
    public boolean isGravando() { return gravando; }
}
