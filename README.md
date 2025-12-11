# farmacia-api
# API Farmácia

API RESTful para gestão de medicamentos em uma farmácia, desenvolvida com Spring Boot.

##  Funcionalidades

- **Usuários Externos**: Consulta de medicamentos (read-only)
- **Fornecedores**: CRUD completo de medicamentos
- Validação de dados com Bean Validation
- Documentação automática com Swagger/OpenAPI
- Tratamento centralizado de erros
- Banco de dados H2 (dev) e MySQL (prod)

##  Tecnologias

- Java 17
- Spring Boot 3.2.0
- Spring Data JPA
- H2 Database (dev)
- MySQL (prod)
- Swagger/OpenAPI 3.0
- Maven

##  Estrutura do Projeto
com.farmacia.api/
├── controller/ # Controladores REST
├── service/ # Lógica de negócio
├── repository/ # Acesso a dados
├── model/ # Entidades JPA
├── dto/ # Objetos de transferência
├── exception/ # Exceções customizadas
└── config/ # Configurações

##  Como Executar

### Pré-requisitos
- Java 17+
- Maven 3.8+
- MySQL (opcional, para produção)

### 1. Clone o repositório
```bash
git clone https://github.com/seu-usuario/farmacia-api.git
cd farmacia-api

mvn spring-boot:run
```

## Acesse os endpoints
- API: http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui.html
- H2 Console: http://localhost:8080/h2-console
