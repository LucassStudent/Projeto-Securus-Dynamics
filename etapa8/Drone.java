package model;

import java.util.ArrayList;
import java.util.List;

public class Drone {
    private int id;
    private String modelo;
    private double latitude;
    private double longitude;
    private double altitude;
    private float nivelBateria;
    private String status; // PRONTO, EM_MISSÃO, RECARREGANDO
    private String versaoFirmware;
    private List<Sensor> sensores = new ArrayList<>();

    public void executarMissao(Missao missao) {
        this.status = "EM_MISSÃO";
        System.out.println("Drone " + id + " iniciando missão: " + missao.getTitulo());
    }

    public void retornarBase() {
        this.status = "RECARREGANDO";
        this.nivelBateria = 100.0f;
    }

    // Getters e Setters...
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<Sensor> getSensores() { return sensores; }
}
