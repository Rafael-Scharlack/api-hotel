# 🏨 API Hotel — Spring Boot + MySQL

API RESTful para gerenciamento de Hóspedes e Reservas, desenvolvida com Spring Boot e banco de dados MySQL.

## 🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot 4.0.3
- Spring Data JPA / Hibernate
- MySQL 8.0
- Swagger / OpenAPI (SpringDoc)
- Docker
- Lombok

## ▶️ Como Rodar a Aplicação

### Pré-requisitos

- [Java 21](https://www.oracle.com/java/technologies/downloads/)
- [Docker Desktop](https://www.docker.com/products/docker-desktop/)
- [Git](https://git-scm.com/)

### 1. Clone o repositório

```bash
git clone https://github.com/Rafael-Scharlack/api-hotel.git
cd api-hotel
```

### 2. Suba o banco de dados com Docker

```bash
docker-compose up -d
```

| Configuração | Valor |
|---|---|
| Host | localhost |
| Porta | 3306 |
| Banco | api_hotel |
| Usuário | root |
| Senha | root |

### 3. Rode a aplicação

```bash
./mvnw spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

### 4. Acesse o Swagger

http://localhost:8080

## 📋 Endpoints

### 🛎️ Hóspedes

| Método | Rota | Descrição |
|---|---|---|
| GET | /hospedes | Lista todos os hóspedes |
| GET | /hospedes/{id} | Busca hóspede por ID |
| POST | /hospedes | Cria um novo hóspede |
| PUT | /hospedes/{id} | Atualiza um hóspede |
| DELETE | /hospedes/{id} | Remove um hóspede |

**Exemplo de body para POST/PUT:**
```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "cpf": "123.456.789-00",
  "telefone": "11999999999",
  "observacao": "Hóspede VIP"
}
```

### 📅 Reservas

| Método | Rota | Descrição |
|---|---|---|
| GET | /reservas | Lista todas as reservas |
| GET | /reservas/{id} | Busca reserva por ID |
| POST | /reservas | Cria uma nova reserva |
| PUT | /reservas/{id} | Atualiza uma reserva |
| DELETE | /reservas/{id} | Remove uma reserva |

**Exemplo de body para POST/PUT:**
```json
{
  "nomeHospede": "João Silva",
  "numeroQuarto": 101,
  "dataCheckin": "2026-05-10",
  "dataCheckout": "2026-05-15",
  "observacao": "Quarto com vista para o mar"
}
```

## 🐳 Docker

```bash
# Subir o banco
docker-compose up -d

# Parar o banco
docker-compose down
```