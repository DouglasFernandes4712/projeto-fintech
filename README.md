# 💰 Projeto Fintech — Backend

## 📘 Relatório Técnico

### 1. Introdução
O relatório tem como objetivo apresentar a estrutura e funcionamento do backend do projeto **Fintech**.  
O sistema foi desenvolvido utilizando o **Spring Boot** com **banco de dados Oracle**, seguindo uma **arquitetura em camadas (MVC)** que separa claramente as responsabilidades entre os componentes de **modelo**, **serviço**, **repositório** e **controle**.

---

### 2. Arquitetura do Sistema
O backend da Fintech foi implementado com base no padrão **MVC (Model-View-Controller)**, adaptado para uma aplicação **Spring Boot**.  
A estrutura foi organizada em quatro pacotes principais:

```
• model: contém as classes de entidade que representam as tabelas do banco de dados.
• repository: define as interfaces responsáveis pela comunicação com o banco de dados.
• service: implementa as regras de negócio e a lógica de persistência.
• controller: expõe endpoints REST para o consumo das funcionalidades pelo frontend.
```

---

### 3. Modelagem das Entidades

#### 3.1 Entidade `Usuario`
Representa os dados cadastrais do usuário, contendo atributos como nome, sobrenome, email, senha e data de nascimento.  
A entidade possui uma relação **1:1 com `LoginModel`**, indicando que cada usuário possui exatamente um login associado.

#### 3.2 Entidade `LoginModel`
Representa as credenciais de acesso do usuário.  
A relação entre `LoginModel` e `Usuario` é de **1:1**, sendo o **`Usuario` o lado dominante (mandante)** do relacionamento.  
A tabela `T_LOGIN` contém a chave estrangeira que referencia o ID da tabela `T_USUARIO`.

#### 3.3 Outras Entidades
As entidades `T_INVESTIMENTO`, `T_META_FINANCEIRA` e `T_TRANSACAO` possuem relacionamento do tipo **N:1 com `T_USUARIO`**, permitindo que um mesmo usuário registre múltiplos investimentos, metas e transações.  
Essas classes foram mapeadas com **@ManyToOne** e **@JoinColumn** para refletir corretamente os relacionamentos no banco.

---

### 4. Camada de Serviço
Responsável por gerenciar as **regras de negócio** e realizar a comunicação entre as camadas de **controle** e **repositório**.  
Cada entidade possui um service correspondente, como `UsuarioService` e `LoginService`.  
Essas classes utilizam **injeção de dependência** do Spring e realizam operações **CRUD** (Post, Get, Put, Delete).

---

### 5. Camada de Controle
Os **Controllers** disponibilizam **endpoints REST** para o frontend.  
Cada entidade possui um controlador com rotas para cadastro, consulta, atualização e exclusão.  
Principais anotações utilizadas: `@RestController`, `@RequestMapping`, `@ResponseStatus`.

---

### 6. Persistência e Banco de Dados
- Banco de Dados: **Oracle**
- ORM: **Spring Data JPA + Hibernate**
- Geração automática de IDs via **@SequenceGenerator**
- Configuração de **dialeto Oracle** e **DDL auto-update**

---

### 7. Considerações Finais
O backend garante uma **arquitetura sólida, escalável e de fácil manutenção**.  
A separação em camadas, o uso de anotações JPA e o padrão RESTful permitem integração eficiente com o frontend ReactJS, além de facilitar futuras expansões.

---

## 🚀 Instruções de Inicialização do Projeto

### 1. Visão Geral
O projeto Fintech é uma aplicação voltada para **gestão financeira e investimentos automatizados**, desenvolvida em **Spring Boot (Java 17)** e integrada a **Oracle Database**.

---

### 2. Tecnologias Utilizadas
| Categoria | Tecnologia |
|------------|-------------|
| Linguagem | Java 17 |
| Framework | Spring Boot 3.x |
| Banco de Dados | Oracle Database |
| ORM | Hibernate (JPA) |
| Build | Maven |
| IDE | IntelliJ IDEA / Eclipse |
| Servidor | Tomcat (embutido) |

---

### 3. Estrutura do Projeto

```
br.com.fiap.fintech.Fintech
│
├── controller/      → Controladores REST (ex: UsuarioController, LoginController)
├── model/           → Entidades do sistema (ex: Usuario, LoginModel)
├── repository/      → Interfaces de persistência (ex: UsuarioRepository)
├── service/         → Camada de regras de negócio (ex: UsuarioService)
└── FintechApplication.java → Classe principal
```

---

### 4. Configuração do Banco de Dados

Arquivo: `src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
spring.datasource.username=Username
spring.datasource.password=Senha
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.OracleDialect
```

⚠️ **Importante:** Ajuste `username`, `password` e `url` conforme o seu ambiente Oracle.

---

### 5. Criação do Banco de Dados

Tabelas principais:

```
T_USUARIO         → informações pessoais e credenciais básicas
T_LOGIN           → controle de autenticação (1:1 com T_USUARIO)
T_INVESTIMENTO    → registros de investimentos
T_META_FINANCEIRA → metas e objetivos financeiros
T_TRANSACAO       → histórico de transações
```

Cada tabela possui uma **sequência (SEQ_...)** para controle automático de IDs.

---

### 6. Execução do Projeto

1. Abra o projeto na IDE (IntelliJ/Eclipse).  
2. Atualize dependências Maven:  
   **Botão direito → Maven → Reload Project**
3. Configure o banco de dados Oracle.  
4. Execute a classe principal:

```bash
FintechApplication.java
```

5. Acesse o servidor local:

```
http://localhost:8080
```

---

### 7. Teste das Rotas (Endpoints)

Use **Postman** ou **Insomnia**.

#### Exemplo — Usuário

**POST** `/usuario`
```json
{
  "nome": "João",
  "sobrenome": "Silva",
  "email": "joao@email.com",
  "senha": "123456",
  "dataNascimento": "1990-05-10"
}
```

#### Exemplo — Login

**POST** `/login`
```json
{
  "usuario": {
    "id": 1
  },
  "dsMetodoSenha": "senha123"
}
```

**Listagem de usuários:**  
`GET /usuario`

**Busca por ID:**  
`GET /usuario/{id}`

**Atualização:**  
`PUT /usuario/{id}`

**Exclusão:**  
`DELETE /usuario/{id}`

---

### 8. Boas Práticas Implementadas
- Separação em camadas (**Model**, **Controller**, **Service**, **Repository**)  
- Uso de `Optional` para evitar NullPointer  
- Relação **@OneToOne** entre `Usuario` e `LoginModel`  
- Persistência com **Spring Data JPA**  
- Sequências Oracle para IDs automáticos  
