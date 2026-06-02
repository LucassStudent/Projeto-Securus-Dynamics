package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Missao {
    private int id;
    private String titulo;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String status;
    private String objetivos;
    private int idOperador;
    private List<Drone> drones = new ArrayList<>();

    public void adicionarDrone(Drone drone) {
        drones.add(drone);
    }

    public String gerarRelatorio() {
        return "Relatório da missão " + titulo + " - Status: " + status +
               " - Drones envolvidos: " + drones.size();
    }

    // Getters e Setters...
}
