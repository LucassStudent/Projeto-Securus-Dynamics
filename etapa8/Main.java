public class Main {
    public static void main(String[] args) {
        SistemaControle controle = new SistemaControle();

        // Criando drones e sensores
        Drone drone1 = new Drone();
        drone1.setId(101);
        drone1.setModelo("Falcao MK4");
        drone1.setNivelBateria(85);

        drone1.getSensores().add(new SensorGPS());
        drone1.getSensores().add(new SensorCamera());

        controle.adicionarDrone(drone1);

        // Criando missão
        Missao missao = new Missao();
        missao.setId(1);
        missao.setTitulo("Patrulha Noturna - Zona Alfa");
        missao.setObjetivos("Monitorar perímetro e identificar alvos suspeitos");
        missao.adicionarDrone(drone1);

        // Execução
        controle.planejarMissao(missao);
        controle.iniciarMonitoramentoEmTempoReal();

        // Deixe rodando por uns 15 segundos para ver o loop
        try { Thread.sleep(15000); } catch (InterruptedException e) {}
        
        controle.pararMonitoramento();
    }
}
