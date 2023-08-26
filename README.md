# Aplicação Spring Boot com PostgreSQL usando Docker 🚀

Esta aplicação é um exemplo de um sistema simples para gerenciar livros, construído com o Spring Boot, utilizando o banco de dados PostgreSQL. A aplicação é separada do banco de dados, e ambos são executados como containers Docker.

## Tecnologias Utilizadas 💻

- **Spring Boot**: O framework Spring Boot é usado para construir a aplicação Java de forma rápida e simplificada.
- **PostgreSQL**: O banco de dados PostgreSQL é utilizado para armazenar os dados dos livros.
- **Docker**: O Docker é utilizado para criar e executar containers isolados para a aplicação e o banco de dados.

## Configurações

### ModelMapper Configuration

A classe `ModelMapperConfiguration` configura o ModelMapper para mapear dtos para models e também oferece um mapeamento personalizado de datas entre strings e objetos `LocalDate`.

### Controller

O `BookController` é responsável por lidar com as requisições HTTP relacionadas aos livros. Ele inclui métodos PUT,POST,DELETE e GET para obter todos os livros, obter um livro por ID, salvar um novo livro, atualizar e deletar livros.

| HTTP Method     |  Path                 |  Status Code          | Description             |
|-----------------|-----------------------|-----------------------|-------------------------|
| GET             | /book                 |  200 (OK)             | Lista todos os livros   |
| POST            | /book                 |  201 (Created)        | Cria um novo livro      |
| GET             | /book/{id}            |  200 (OK)             | Lista um livro          |
| DELETE          | /book/{id}            |  204 (No Content)     | Deleta um livro         |

### Controller Advice

A classe `ControllerExceptionHandler` é responsável por lidar com exceções personalizadas e retornar respostas HTTP apropriadas. Ela trata exceções como violações de integridade de dados, entidades não encontradas e formatos de data incorretos.

### Entidade BookModel

A classe `BookModel` é uma entidade JPA que representa um livro e é mapeada para a tabela `livros` no banco de dados PostgreSQL. Ela contém campos como `bookName`, `bookAuthor`, `bookCode` (com restrição de unicidade) e `releaseDate`.

### DTOs

Os DTOs (`BookRequestDTO` e `BookResponseDTO`) são objetos de transferência de dados utilizados para comunicação entre a camada de controle e a camada de serviço.
O DTO (`ExceptionResponseDTO`) é usado para execeção.

### Service

O `BookService` é responsável pela lógica de negócios relacionada aos livros. Ele realiza a criação, leitura, atualização e remoção de livros. Também utiliza o `ModelMapper` para mapear entre modelos e DTOs.

### Repository

O `BookRepository` é uma interface extendendo `JpaRepository` do Spring Data JPA, que permite a interação com a tabela `livros` no banco de dados.

## Docker Compose

O Docker Compose é utilizado para orquestrar a execução da aplicação e do banco de dados PostgreSQL. Ambos são definidos como serviços no arquivo `docker-compose.yml`.

## Docker file
O Docker file é utilizado para construir a imagem da nossa aplicação.

## Como Executar 🔨

1. Certifique-se de que você tenha o Docker e o Docker Compose instalados em sua máquina.
2. Coloque os arquivos acima em seus respectivos pacotes em um projeto Spring Boot.
3. Crie o arquivo `docker-compose.yml` no mesmo diretório do projeto, com o seguinte conteúdo:
4. No terminal, navegue para o diretório do projeto (onde está o arquivo `docker-compose.yml`) e execute:

```bash
docker-compose up -d
```

Isso iniciará os serviços em containers isolados.

5. Acesse a aplicação em `http://localhost:8080`.

Agora, você tem uma aplicação Spring Boot executando em um container Docker, conectado a um banco de dados PostgreSQL também em um container Docker. Certifique-se de ajustar as configurações de conexão ao banco de dados conforme necessário.

