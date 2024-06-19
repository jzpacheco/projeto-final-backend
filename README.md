# Projeto de Consultas Médicas

Este é um projeto de gerenciamento de consultas médicas desenvolvido utilizando Spring Boot, Spring Data JPA e Docker. O projeto permite a criação, atualização, visualização e exclusão de consultas médicas, bem como a gestão de pacientes, médicos e atendentes.

## Sumário

- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Pré-requisitos](#pré-requisitos)
- [Instalação](#instalação)
- [Uso](#uso)
- [Endpoints](#endpoints)

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.x.x
- Spring Data JPA
- H2 database
- Maven
- Docker

## Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:

- [Git](https://git-scm.com)
- [Docker](https://www.docker.com)
- [Java 17](https://jdk.java.net/17/)
- [Maven](https://maven.apache.org)

## Instalação

### Clonando o Repositório

```bash
git clone https://github.com/seu-usuario/projeto-consultas-medicas.git
cd projeto-consultas-medicas
```

### Construindo a imagem docker
```bash
  docker build -t projeto-final-backend .
```

### Criando o container e expondo a porta 8080 da aplicação
```
 docker run -p 8080:8080 projeto-final-backend
```
### Uso
Após construir a imagem docker e executa-la em um container, a aplicação ficará disponível na porta 8080
```
  http://localhost:8080
```

## Endpoints

### Consultas

- **GET /appointments**: Retorna todas as consultas.
- **GET /appointments/{id}**: Retorna uma consulta específica por ID.
- **POST /appointments**: Cria uma nova consulta.
- **PUT /appointments/{id}**: Atualiza uma consulta existente por ID.
- **DELETE /appointments/{id}**: Exclui uma consulta por ID.

### Pacientes

- **GET /patients**: Retorna todos os pacientes.
- **GET /patients/{id}**: Retorna um paciente específico por ID.
- **POST /patients**: Cria um novo paciente.
- **PUT /patients/{id}**: Atualiza um paciente existente por ID.
- **DELETE /patients/{id}**: Exclui um paciente por ID.

### Parceiros (Médicos e Atendentes)

- **GET /partners**: Retorna todos os parceiros.
- **GET /partners/{id}**: Retorna um parceiro específico por ID.
- **POST /partners**: Cria um novo parceiro.
- **PUT /partners/{id}**: Atualiza um parceiro existente por ID.
- **DELETE /partners/{id}**: Exclui um parceiro por ID.

