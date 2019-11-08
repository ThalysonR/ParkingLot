# SmartParking

## Descrição do Projeto

### Back-end

API REST feita em Java. Foram usadas as seguintes tecnologias:

* Maven
* Spring Boot
* Swagger
* Lombok
* H2 (Banco em Memória)
* Hibernate

É possível acessar a documentação da API (Swagger-ui) através do link http://localhost:8080/swagger-ui.html quando a aplicação está em execução. Foram implementados testes básicos de integração e unitários.
**Obs.:** Ao iniciar a aplicação são inseridos, automáticamente, dados aleatórios entre as datas de 10/10/2019 e 30/10/2019 para que seja possível a visualização do relatório.

### Front-end

Aplicação cliente para consumir a API. Foram usadas as seguintes tecnologias: 

* Angular 8
* Angular Material
* SASS
* Chart.js

## Configuração e Execução

### Docker

Foi disponibilizado um arquivo **docker-compose.yml** contendo os conteiners necessários à execução, já configurados. Para executar a aplicação usando docker, basta executar o compose.
> docker-compose up

O front-end será executado na porta 80 (http://localhost:4200) e o back-end será executado na porta 8080 (http://localhost:8080).

### Execução Local

#### Front-end

Na pasta front, digite:
> npm install

> npm start

O front-end será executado em http://localhost:4200.

#### Back-end

Na pasta back, digite:
>mvn spring-boot:run

O back-end será executado em http://localhost:8080.
