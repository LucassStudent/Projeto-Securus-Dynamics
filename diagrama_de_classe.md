@startuml Diagrama_de_Classes_Falcao_Sombrio_V2
skinparam shadowing false
skinparam classFontSize 12
skinparam monochrome true
skinparam nodesep 70
skinparam ranksep 90
skinparam packageTitleAlignment left
skinparam packageStyle rectangle

left to right direction

title **Diagrama de Classes - Sistema Falcão Sombrio**\n(Projeto Securus Dynamics)

' ====================== PACOTES PARA ORGANIZAÇÃO VISUAL ======================

package "Operadores & Controle" as PacoteControle {
    
    class Operador {
        - id : Integer
        - nome : String
        - credencialBiometrica : String
        - tokenMFA : String
        + autenticarBiometria() : boolean
        + autenticarMFA() : boolean
        + enviarComando(c : Comando) : void
        + planejarMissao(m : Missao) : void
    }

    class SistemaControle {
        + monitorarFrota() : void
        + processarTelemetria(t : Telemetria) : void
        + gerenciarAtualizacaoFirmware() : void
        + ativarFailover() : void
    }
}

package "Drone & Sensores" as PacoteDrone {
    
    class Drone {
        - id : String
        - status : String <<enum>> {PRONTO, EM_MISSÃO, FALHA, RECARREGANDO}
        - posicaoAtual : Coordenada
        - nivelBateria : Float
        + executarMissao(m : Missao) : void
        + transmitirTelemetria(t : Telemetria) : void
        + detectarAmeaca() : boolean
        + ativarFallback() : void
    }

    abstract class Sensor {
        - tipo : String
        + lerDados() : DadosSensor
        + calibrar() : void
    }

    class LIDAR extends Sensor {
        + medirDistancia() : Float
    }

    class GPS extends Sensor {
        + obterCoordenada() : Coordenada
    }

    class Camera extends Sensor {
        + capturarImagem() : Imagem
        + detectarObjeto() : boolean
    }
}

package "Missões & Comandos" as PacoteMissao {
    
    class Missao {
        - id : Integer
        - dataInicio : Date
        - dataFim : Date
        - objetivo : String
        - rota : List<Coordenada>
        + iniciar() : void
        + registrarLog(l : LogAuditoria) : void
        + calcularRota() : void
    }

    class Comando {
        - tipo : String <<enum>> {MOVER, ATACAR, RETORNAR, ESCANEAR}
        - parametros : Map<String, String>
        + executar(d : Drone) : void
    }
}

package "Dados & Auditoria" as PacoteDados {
    
    class Telemetria {
        - timestamp : Date
        - latitude : Float
        - longitude : Float
        - altitude : Float
        - velocidade : Float
        - dadosSensores : Map<String, String>
    }

    class LogAuditoria {
        - id : Integer
        - evento : String
        - timestamp : Date
        - detalhes : String
        - imutavel : boolean
        + registrarAcesso() : void
    }

    class ServidorDados {
        - bancoNoSQL : String <<distributed>>
        + armazenarLog(l : LogAuditoria) : void
        + replicarDados() : void
        + recuperarBackup() : void
    }
}

' ====================== RELACIONAMENTOS (mantidos exatamente iguais) ======================

' Operador controla Drone e planeja Missão
Operador "1" --> "0..*" Drone : controla
Operador "1" --> "0..*" Missao : planeja

' Drone possui sensores (composição forte)
Drone "1" *-- "1..*" Sensor : possui >

' Missão executa Drone (agregação)
Missao "1" o-- "0..*" Drone : executada_por

' Drone gera Telemetria
Drone "1" --> "0..*" Telemetria : gera

' Drone recebe Comando
Drone "1" ..> "0..*" Comando : recebe

' Missão gera Log (composição)
Missao "1" *-- "0..*" LogAuditoria : gera

' SistemaControle gerencia Drone e Missão
SistemaControle "1" --> "0..*" Drone : gerencia
SistemaControle "1" --> "0..*" Missao : coordena

' Servidor armazena dados
ServidorDados "1" --> "0..*" LogAuditoria : armazena
ServidorDados "1" --> "0..*" Telemetria : persiste

' ==================== NOTAS ======================

note right of Drone
  **Herança de Sensor**: LIDAR, GPS e Camera
  **Composição**: sensores são partes essenciais do drone
end note

note right of LogAuditoria
  Logs são **imutáveis** (requisito não-funcional)
  Criptografia AES-256 aplicada
end note

note bottom of SistemaControle
  Central de Controle + Dashboard em tempo real
  Responsável por failover e monitoramento 24/7
end note

@enduml
