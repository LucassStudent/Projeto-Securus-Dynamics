# Etapa 8 - Projeto Final: Sistema Securus Dynamics

**Disciplina:** Projeto de Software - UML com Controle de Acesso
**Instituicao:** Mackenzie
**Entrega:** 27/05

---

## Sobre o Projeto

O **Sistema Securus Dynamics** e uma plataforma de controle de drones militares autonomos desenvolvida em **Java**, com foco em seguranca de acesso, rastreabilidade de operacoes e monitoramento de telemetria em tempo real.

O sistema gerencia frotas de drones em missoes taticas, coletando dados de sensores (GPS, camera, LIDAR), autenticando operadores com MFA e biometria, e registrando cada acao em logs imutaveis de auditoria.

---

## Equipe

| Integrante | RA | GitHub |
|---|---|---|
| Lucas Franco do Carmo | 10439830 | @LucassStudent |
| Artur Campi | 10436740 | @Artur-Campi |

---

## Estrutura do Codigo

etapa8/
Main.java - Ponto de entrada
Drone.java - Entidade principal da frota
Missao.java - Representa uma missao tatica
Operador.java - Operador com autenticacao MFA
SistemaControle.java - Controller central
Sensor.java - Classe abstrata base
SensorGPS.java - Sensor GPS concreto
SensorCamera.java - Sensor de camera
Sensor-concreto.java - Sensor LIDAR
LogAuditoria.java - Log imutavel

---

## Funcionalidades

### Gerenciamento de Drones
- Cadastro de drones com modelo, coordenadas e nivel de bateria
- Verificacao automatica de bateria minima antes de missao
- Ciclo de vida: PRONTO -> EM_MISSAO -> RECARREGANDO

### Planejamento de Missoes
- Criacao de missoes com titulo, objetivos e data de inicio
- Alocacao de multiplos drones por missao (relacao N:M)
- Execucao controlada pelo SistemaControle

### Controle de Acesso e Seguranca
- Autenticacao com senha + MFA
- Suporte a credencial biometrica
- Token de sessao com invalidacao

### Monitoramento de Telemetria
- Loop agendado a cada 5 segundos
- Coleta de dados de todos os sensores
- Registro com timestamp

### Sensores com Polimorfismo
- Sensor e uma classe abstrata com metodo coletar()
- SensorGPS, SensorCamera, SensorLIDAR implementam o contrato

### Log de Auditoria
- Registro imutavel de todas as acoes
- Campos: operadorId, missaoId, acao, timestamp, ipOrigem, hashIntegridade

---

## Como Executar

Pre-requisitos: Java 17+ e IntelliJ IDEA, Eclipse ou VS Code

Passos:
1. Clone o repositorio
git clone https://github.com/LucassStudent/Projeto-Securus-Dynamics.git

2. Entre na pasta da etapa 8
cd Projeto-Securus-Dynamics/etapa8

3. Compile todos os arquivos Java
javac *.java

4. Execute o sistema
java Main

Saida esperada:
Drone 101 adicionado a frota.
=== PLANEJAMENTO DE MISSAO ===
Missao: Patrulha Noturna - Zona Alfa
-> Drone 101 (Falcao MK4) alocado
Missao planejada com sucesso!
Iniciando monitoramento...
Drone 101 | Status: EM_MISSAO
  -> SensorGPS: {lat: -23.55, lng: -46.63, alt: 120.0}
  -> SensorCamera: {resolucao: 4K}
Monitoramento finalizado.

---

## VIDEO DE APRESENTACAO

Adicione aqui o link do video demo apos a gravacao:

LINK DO VIDEO: [Clique aqui para assistir](#)

O video deve demonstrar o sistema em execucao, explicar a arquitetura e os diagramas UML.
Todos os integrantes do grupo devem aparecer na apresentacao.

---

## Artefatos das Etapas Anteriores

| Etapa | Descricao | Link |
|-------|-----------|------|
| Etapa 1 | Proposta de Projeto | ../etapa1/README.md |
| Etapa 2 | Diagrama de Classes | ../etapa2/README.md |
| Etapa 3 | Diagrama de Sequencia | ../etapa3/README.md |
| Etapa 4 | Integracao Classes + Banco de Dados | ../etapa4/README.md |
| Etapa 5 | Diagrama de Projeto | ../etapa5/README.md |
| Etapa 6 | Integracao Sequencia + Colaboracao | ../etapa6/README.md |
| Etapa 7 | Diagrama de Estados | ../etapa7/README.md |

---

Securus Dynamics - Projeto de Software - Mackenzie - 2026
