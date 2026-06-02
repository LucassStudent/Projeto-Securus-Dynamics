package model;

import java.util.HashMap;
import java.util.Map;

public class SensorLIDAR extends Sensor {
    private double alcanceMetros;
    private double resolucaoCM;

    @Override
    public Map<String, Object> coletar() {
        Map<String, Object> dados = new HashMap<>();
        dados.put("distancia", 45.3);
        dados.put("tipo", "LIDAR");
        return dados;
    }

    @Override
    public void calibrar() {
        this.calibradoEm = LocalDateTime.now();
    }

    @Override
    public boolean getStatus() { return ativo; }
}

// SensorGPS.java e SensorCamera.java seguem padrão similar...
