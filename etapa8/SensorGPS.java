package model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class SensorGPS extends Sensor {

    private double latitude;
    private double longitude;
    private double altitude;
    private float precisaoMetros; // Ex: 2.5 metros de precisão

    public SensorGPS() {
        this.tipo = "GPS";
        this.ativo = true;
        this.calibradoEm = LocalDateTime.now();
    }

    @Override
    public Map<String, Object> coletar() {
        Map<String, Object> dados = new HashMap<>();
        dados.put("tipo", "GPS");
        dados.put("latitude", latitude);
        dados.put("longitude", longitude);
        dados.put("altitude", altitude);
        dados.put("precisao", precisaoMetros);
        dados.put("timestamp", LocalDateTime.now());

        // Simulação de leitura
        this.latitude = -23.55 + (Math.random() * 0.01);
        this.longitude = -46.63 + (Math.random() * 0.01);

        this.ultimaLeitura = LocalDateTime.now();

        return dados;
    }

    @Override
    public void calibrar() {
        this.precisaoMetros = 2.5f;
        this.calibradoEm = LocalDateTime.now();
        System.out.println("✅ Sensor GPS calibrado com precisão de " + precisaoMetros + "m");
    }

    @Override
    public boolean getStatus() {
        return ativo && precisaoMetros > 0;
    }

    // Getters e Setters
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public double getAltitude() { return altitude; }
}
