package control;

import model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SistemaControle {

    private List<Drone> dronesFrota = new ArrayList<>();
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void planejarMissao(Missao missao) {
        System.out.println("\n=== PLANEJAMENTO DE MISSÃO ===");
        System.out.println("Missão: " + missao.getTitulo());
        System.out.println("Objetivos: " + missao.getObjetivos());
        System.out.println("Data de Início: " + LocalDateTime.now());

        // Lógica fictícia de planejamento
        for (Drone drone : missao.getDrones()) {
            System.out.println("→ Drone " + drone.getId() + " (" + drone.getModelo() + ") alocado");

            // Verificar bateria mínima
            if (drone.getNivelBateria() < 25) {
                System.out.println("⚠️ Drone " + drone.getId() + " em recarga. Aguardando...");
                drone.retornarBase();
                continue;
            }

            drone.executarMissao(missao);
        }

        System.out.println("✅ Missão planejada e drones alocados com sucesso!\n");
    }

    public void iniciarMonitoramentoEmTempoReal() {
        System.out.println("🚁 Iniciando monitoramento contínuo de telemetria...");

        scheduler.scheduleAtFixedRate(() -> {
            monitorarTelemetria();
        }, 0, 5, TimeUnit.SECONDS); // A cada 5 segundos
    }

    public void monitorarTelemetria() {
        System.out.println("\n--- Telemetria em Tempo Real (" + LocalDateTime.now() + ") ---");

        for (Drone drone : dronesFrota) {
            if ("EM_MISSÃO".equals(drone.getStatus())) {
                System.out.println("Drone " + drone.getId() + " | Status: " + drone.getStatus());

                // Coletar dados de todos os sensores
                for (Sensor sensor : drone.getSensores()) {
                    Map<String, Object> dados = sensor.coletar();
                    System.out.println("   → " + sensor.getClass().getSimpleName() + ": " + dados);
                }

                // Simulação de transmissão
                Telemetria telemetria = new Telemetria(drone.getId(), LocalDateTime.now());
                telemetria.transmitir();
            }
        }
    }

    public void pararMonitoramento() {
        scheduler.shutdown();
        System.out.println("⛔ Monitoramento finalizado.");
    }

    // Adicionar drone à frota
    public void adicionarDrone(Drone drone) {
        dronesFrota.add(drone);
        System.out.println("Drone " + drone.getId() + " adicionado à frota.");
    }
}
