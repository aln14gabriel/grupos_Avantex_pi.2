# Atividade em grupo - Projeto Integrador II

### Faculdade Alpha
### Professor: Rafael Marinho dos Anjos

### Equipe: Avantex

| Alunos |
|--------|
| Allan Gabriel|
| Davi |
| George|
| Ruan Vinicius |
| Adriano Santos  |
| Guilherme melo |
## Introdução

Este trabalho propõe a modelagem de um banco de dados para uma academia.
. O sistema foi estruturado com base em um minimundo que reflete as necessidades reais de uma academia, mapeando entidades (como membro, aula, pagamento), atributos (nome, CPF, horários) e relacionamentos (ex: membros vinculados a aulas).


## Banco de dados

- [Código de criação do BD](./data/codigo_criacao_banco.sql)



1. Tabela membro (Cadastro de Membros)

| Coluna | Tipo | Descrição |
|--------|------|-----------|
| id | INT | ID único do membro (PK) |
| nome | VARCHAR | Nome Completo |
| cpf | VARCHAR | CPF (único) |
| plano | VARCHAR | Tipo de plano |
| data_inicio | VARCHAR | Data de inicio do plano |

2. Tabela funcionario (Cadastro de Funcionários)

| Coluna  | Tipo     | Descrição                   |
|---------|----------|-----------------------------|
| id | INT | ID único (PK) |
| nome | VARCHAR | Nome Completo |
| cargo | VARCHAR | Cargo |
| salario | INT | Salário |

3.Tabela aula (Aulas Disponiveis)
| Coluna | Tipo | Descrição |
|--------|------|-----------|
| codigo| INT | Código de aula (PK) |
| nome| VARCHAR | Nome Da Aula |
| horario| VARCHAR| Horário|
| capacidade| INT | Capacidade Máxima|

4.Tabela pagamento(Registro de Pagamentos)


5. Tabela equipamento (Controle de Equipamentos)

| Coluna | Tipo | Descrição |
|--------|------|-----------|
| id | INT | ID único  (PK) |
| nome | VARCHAR | Nome do equipamento |
| status | VARCHAR | Status |



