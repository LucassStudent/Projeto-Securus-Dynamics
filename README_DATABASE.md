## ☁️ Fase 4: Implementação do Banco de Dados (PostgreSQL / Supabase)

Nesta etapa do projeto, materializamos a arquitetura UML em um ambiente relacional na nuvem. O **Supabase** foi a plataforma escolhida para hospedar nossa infraestrutura, aproveitando os recursos nativos do PostgreSQL para garantir alta disponibilidade, integridade geoespacial e segurança.

### 🗄️ Arquitetura de Dados

As tabelas foram modeladas para traduzir fielmente as regras de negócio e as classes do sistema, agrupadas nos seguintes domínios:

* **Gestão e Controle de Acesso (`Operador`, `SistemaControle`):** Responsáveis por armazenar as credenciais da equipe, níveis de autorização (incluindo MFA e biometria) e o gerenciamento dos servidores (com suporte a *failover*).
* **Orquestração da Frota (`Drone`, `Missao`):** Gerenciamento do ciclo de vida tático. Controla quais equipamentos estão alocados para quais missões (relação N:M), além de rastrear o firmware e a bateria de cada unidade.
* **Componentes e Captura (`Sensor`, `Telemetria`):** A tabela de sensores adota o padrão *Single Table Inheritance*, acomodando as especificações de LIDAR, GPS e Câmeras em uma estrutura única. Já a telemetria é focada em altíssimo desempenho de escrita, indexada por UUIDs para mapeamento em tempo real.
* **Rastreabilidade (`LogAuditoria`):** Histórico completo de eventos e comandos disparados no sistema.

### 🔒 Blindagem e Regras de Negócio

Para evitar inconsistências e garantir a segurança da frota, transferimos diversas validações diretamente para o motor do banco de dados:

1. **Registros Imutáveis (Row Level Security):** A tabela de logs de auditoria foi configurada sob a regra de *append-only*. Através das políticas de RLS, comandos de `UPDATE` e `DELETE` são bloqueados nativamente pelo Supabase, garantindo conformidade.
2. **Validações Nativas (CHECK Constraints):** Inconsistências como "nível de bateria negativo" ou "status inexistente" são barradas antes mesmo de entrarem no banco de dados.
3. **Deleção em Cascata e Integridade:** Chaves Estrangeiras foram mapeadas com `ON DELETE CASCADE` de forma estratégica. Por exemplo: a remoção de um drone limpa automaticamente seus componentes de hardware vinculados, evitando a criação de dados órfãos.

🔗 **Acesso ao Ambiente (Supabase):** [https://dnuxxdntozelceeyljex.supabase.co](https://dnuxxdntozelceeyljex.supabase.co)
