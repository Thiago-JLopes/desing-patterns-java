# Design Patterns Project

Este projeto demonstra a aplicação de padrões de projeto usando Spring Boot. O objetivo é fornecer uma implementação prática de alguns padrões populares, como Singleton, Strategy e Facade, em um contexto de serviço web RESTful.

## Descrição

O projeto consiste em um sistema simples de gerenciamento de usuários, onde cada usuário tem um endereço associado. Utilizamos a API ViaCEP para buscar endereços pelo CEP. A aplicação é construída usando Spring Boot e utiliza vários módulos do Spring, como Spring Data JPA e Spring Cloud OpenFeign.

## Padrões de Projeto Utilizados

### Singleton

- **Descrição:** Garante que uma classe tenha apenas uma instância e fornece um ponto global de acesso a ela.
- **Implementação:** O padrão Singleton é utilizado através da injeção de dependências do Spring com a anotação `@Autowired`, garantindo que haja apenas uma instância dos componentes injetados.

### Strategy

- **Descrição:** Define uma família de algoritmos, encapsula cada um deles e os torna intercambiáveis. O padrão Strategy permite que o algoritmo varie independentemente dos clientes que o utilizam.
- **Implementação:** A interface `UserService` define um contrato que pode ter várias implementações. A classe `UserServiceImp` é uma dessas implementações.

### Facade

- **Descrição:** Fornece uma interface unificada para um conjunto de interfaces em um subsistema. O Facade define uma interface de nível mais alto que torna o subsistema mais fácil de usar.
- **Implementação:** A classe `UserServiceImp` atua como uma fachada que abstrai as complexidades das interações com os repositórios de usuário e endereço, bem como a API ViaCEP.

## Dependências

O projeto utiliza as seguintes dependências:

- **Spring Boot Starter Data JPA:** Para persistência de dados.
- **Spring Boot Starter Web:** Para criar endpoints RESTful.
- **H2 Database:** Banco de dados em memória para desenvolvimento e testes.
- **Spring Cloud OpenFeign:** Para comunicação com a API ViaCEP.
- **Springdoc OpenAPI:** Para documentação da API.

## Endpoints

A API expõe os seguintes endpoints:

- **GET /usuarios:** Retorna todos os usuários.
- **GET /usuarios/{id}:** Retorna um usuário pelo ID.
- **POST /usuarios:** Adiciona um novo usuário.
- **PUT /usuarios/{id}:** Atualiza um usuário existente.
- **DELETE /usuarios/{id}:** Deleta um usuário pelo ID.
