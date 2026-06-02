package model;

import java.time.LocalDateTime;
import java.util.Map;

public abstract class Sensor {
    protected int id;
    protected String tipo;
    protected boolean ativo;
    protected LocalDateTime ultimaLeitura;
    protected LocalDateTime calibradoEm;

    public abstract Map<String, Object> coletar();
    public abstract void calibrar();
    public abstract boolean getStatus();

    // Getters e Setters comuns...
}
