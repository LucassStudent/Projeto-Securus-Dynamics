# 🛡️ Projeto Securus Dynamics
### Sistema Falcão Sombrio — Controle de Drones Militares Autônomos

---

## 📋 Contextualização

A **Securus Dynamics** é uma empresa multinacional fictícia especializada no desenvolvimento de drones bélicos autônomos. Seu principal produto, o **Aquila-X**, é uma frota de drones equipados com inteligência artificial e sensores avançados, capazes de realizar missões táticas, reconhecimento em território hostil e ataques de precisão.

O novo sistema **Falcão Sombrio** permite a operação remota e autônoma dos drones através de uma rede de servidores distribuídos e uma interface operacional avançada. O projeto envolve desafios de sistemas operacionais (tempo real, segurança e concorrência), além de banco de dados (armazenamento distribuído, replicação e logs de auditoria).

A consultoria fictícia **Cyber Bullet System** foi contratada para reformular toda a arquitetura de software e definir um novo modelo de banco de dados para suportar as operações críticas dos drones.

---

## 🎯 Requisitos e Funcionalidades

### 1. Central de Controle
- Interface para gerenciamento de frotas de drones
- Controle remoto e autônomo dos drones
- Dashboard em tempo real com telemetria

### 2. Sistema de Navegação Inteligente
- Sensoriamento do ambiente via LIDAR, câmeras e GPS
- Detecção e evasão de ameaças em tempo real
- Operação autônoma baseada em redes neurais

### 3. Gerenciamento de Comunicação
- Protocolos para comunicação segura e em tempo real com os drones
- Mecanismos de fallback para evitar perda de conexão

### 4. Banco de Dados e Auditoria
- Logs de missões realizadas e eventos críticos
- Criptografia de ponta e assinaturas digitais
- Banco de dados NoSQL distribuído para dados em tempo real

### 5. Sistemas Embarcados e Segurança
- Autenticação de operadores via biometria e autenticação multifator (MFA)
- Monitoramento de processos do SO embarcado para evitar falhas

---

## 🔍 Problemas a Resolver

| # | Problema | Descrição |
|---|----------|-----------|
| 1 | **Arquitetura Deficiente** | Latência elevada, interrupções durante missões críticas e ausência de failover automático |
| 2 | **Segurança** | Necessidade de autenticação robusta, criptografia e logs de auditoria imutáveis |
| 3 | **Banco de Dados** | Sincronização em tempo real, histórico de missões e replicação distribuída |
| 4 | **SO e Concorrência** | Gerenciamento de múltiplas threads (sensores, navegação, IA) com priorização por criticidade |

---

## 📂 Estrutura do Repositório

O repositório está organizado por etapas de desenvolvimento do projeto. Cada etapa contém os artefatos produzidos, como diagramas UML, documentação e código-fonte.

```
Projeto-Securus-Dynamics/
├── etapa1/   → Proposta de Projeto
├── etapa2/   → Diagrama de Classes
├── etapa3/   → Diagrama de Sequência
├── etapa4/   → Integração Classes + Banco de Dados
├── etapa5/   → Diagrama de Projeto (abstrações e interfaces)
├── etapa6/   → Integração Sequência + Colaboração
├── etapa7/   → Diagrama de Estados
└── etapa8/   → Projeto Final (código Java, documentação e vídeo demo)
```

---

## 🗓️ Sprints e Etapas

### 🔵 SPRINT 1

| Etapa | Descrição | Entrega | Status |
|-------|-----------|---------|--------|
| [Etapa 1](./etapa1) | Proposta de Projeto — tema, equipes e repositório | 04/03 | ✅ Concluído |
| [Etapa 2](./etapa2) | Diagrama de Classes inicial | 11/03 | ✅ Concluído |
| [Etapa 3](./etapa3) | Diagrama de Sequência inicial | 18/03 | ✅ Concluído |
| [Etapa 4](./etapa4) | Integração de modelos — Classes + Banco de Dados | 25/03 | ✅ Concluído |

### 🟣 SPRINT 2

| Etapa | Descrição | Entrega | Status |
|-------|-----------|---------|--------|
| [Etapa 5](./etapa5) | Diagrama de Projeto — abstrações e interfaces | 29/04 | ✅ Concluído |
| [Etapa 6](./etapa6) | Integração Sequência + Colaboração | 06/05 | ✅ Concluído |
| [Etapa 7](./etapa7) | Diagrama de Estados | 13/05 | ✅ Concluído |
| [Etapa 8](./etapa8) | Projeto Final — código Java, documentação e vídeo demo | 27/05 | ✅ Concluído |

---

## 📌 Detalhamento das Etapas

### Etapa 1 — Proposta de Projeto
Definição do tema, formação da equipe e criação do repositório no GitHub. O projeto escolhido é o **Sistema Falcão Sombrio**, plataforma de controle de drones militares autônomos com foco em segurança, telemetria e operação distribuída.

📄 [Ver artefato](./etapa1/README.md)

### Etapa 2 — Diagrama de Classes
Elaboração do diagrama de classes UML representando a arquitetura de controle, segurança e operação do sistema. Inclui as entidades principais: `Drone`, `Missao`, `Operador`, `SistemaControle`, `Sensor` e `LogAuditoria`.

📄 [Ver artefato](./etapa2/README.md)

### Etapa 3 — Diagrama de Sequência
Modelagem do fluxo de interação entre os objetos do sistema, representando os cenários de autenticação do operador, planejamento de missão, coleta de telemetria e registro de auditoria.

📄 [Ver artefato](./etapa3/README.md)

### Etapa 4 — Integração de Modelos (Classes + Banco de Dados)
Mapeamento das classes UML para o modelo relacional/NoSQL. Definição de tabelas, chaves primárias e estrangeiras, além da estratégia de replicação e sincronização dos dados dos drones em tempo real.

📄 [Ver artefato](./etapa4/README.md)

### Etapa 5 — Diagrama de Projeto (Abstrações e Interfaces)
Refinamento da arquitetura com a definição de interfaces (`ISensor`, `IAutenticavel`, `ILogavel`) e classes abstratas. Aplicação de padrões de projeto (Strategy, Observer, Singleton) para garantir extensibilidade e manutenibilidade do sistema.

📄 [Ver artefato](./etapa5/README.md)

### Etapa 6 — Integração Sequência + Colaboração
Elaboração do diagrama de colaboração UML integrado ao diagrama de sequência, evidenciando as responsabilidades e os vínculos entre os objetos durante a execução de uma missão tática.

📄 [Ver artefato](./etapa6/README.md)

### Etapa 7 — Diagrama de Estados
Modelagem do ciclo de vida dos principais elementos do sistema, como o `Drone` (estados: `PRONTO → EM_MISSAO → RECARREGANDO → INOPERANTE`) e a `Missao` (estados: `PLANEJADA → EM_EXECUCAO → CONCLUIDA / ABORTADA`).

📄 [Ver artefato](./etapa7/README.md)

### Etapa 8 — Projeto Final
Implementação do sistema em **Java**, integrando todos os artefatos UML produzidos ao longo das sprints. O projeto inclui gerenciamento de frota, autenticação MFA/biométrica, monitoramento de telemetria por sensores polimórficos e log de auditoria imutável.

📄 [Ver artefato e instruções de execução](./etapa8/README.md)

---

## 💻 Tecnologias Utilizadas

| Tecnologia | Finalidade |
|------------|------------|
| **Java 17+** | Linguagem principal do sistema embarcado e backend |
| **UML (draw.io)** | Modelagem dos diagramas de classes, sequência, estados e colaboração |
| **NoSQL (conceitual)** | Banco de dados distribuído para dados de telemetria em tempo real |
| **MFA / Biometria** | Autenticação segura de operadores |
| **Criptografia / Hash** | Integridade dos logs de auditoria |
| **GitHub** | Controle de versão e colaboração |

---

## 🚀 Como Executar o Projeto Final

**Pré-requisitos:** Java 17+ e uma IDE (IntelliJ IDEA, Eclipse ou VS Code)

```bash
# 1. Clone o repositório
git clone https://github.com/LucassStudent/Projeto-Securus-Dynamics.git

# 2. Acesse a pasta da etapa final
cd Projeto-Securus-Dynamics/etapa8

# 3. Compile todos os arquivos Java
javac *.java

# 4. Execute o sistema
java Main
```

**Saída esperada:**
```
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
```

---

## 🎬 Vídeo de Apresentação

> O vídeo deve demonstrar o sistema em execução, explicar a arquitetura e os diagramas UML produzidos.
> **Todos os integrantes do grupo devem aparecer na apresentação.**

📹 **[Clique aqui para assistir ao vídeo demo]()**

---

## 👨‍💻 Equipe — Cyber Bullet System

| Integrante | RA | GitHub |
|------------|----|--------|
| Lucas Franco do Carmo | 10439830 | [@LucassStudent](https://github.com/LucassStudent) |
| Artur Campi | 10436740 | [@Artur-Campi](https://github.com/Artur-Campi) |

---

*Securus Dynamics — Projeto de Software — Universidade Mackenzie — 2026*
