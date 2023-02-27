# Serviço de Denúncias

Este é um serviço de denúncias que permite a inserção de novas denúncias por meio de uma API REST. O serviço foi desenvolvido utilizando Java como linguagem principal e algumas outras tecnologias para complementar a estrutura do projeto.

## Requisitos

- Java 11
- Docker
- Docker Compose
- Postman
- IDE de preferência

## Funcionalidades

- [x] Inserção de novas denúncias: a API REST permite que sejam inseridas novas denúncias pelos usuários, incluindo informações como geolocalização, dados do denunciante e dados da denúncia.
- [x] Persistência dos dados: todos os dados recebidos na inserção de uma nova denúncia são persistidos em um banco de dados.
- [x] Busca de endereço: a partir da geolocalização fornecida, o serviço realiza uma chamada a uma API externa para obter os dados de endereço da localidade informada.

## Como rodar o projeto

- Faça um clone do projeto e abra na usa IDE de preferência
- Rode o projeto com o comando `docker compose up -d` para o docker compose inicializar o serviço de denúncias
- Acesse a documentação da API em `http://localhost:8080/denuncia/swagger-ui.html` para ver os endpoints disponíveis
- Importe o arquivo `Denuncia-API.postman_collection` no Postman para ter acesso aos endpoints já configurados]
