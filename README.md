# Projeto Biblioteca & API em Java

## Visão Geral
Este projeto é uma implementação de uma biblioteca virtual com uma API RESTful para gerenciar livros, autores e usuários. A API permite a realização de operações básicas de CRUD (Create, Read, Update, Delete) em cada uma dessas entidades.

## Tecnologias Utilizadas
- **Linguagem de Programação**: Java
- **Banco de Dados**: MySQL

## Instalação e Configuração
1. Clone o repositório:

2. Importe o projeto em sua IDE de preferência (Eclipse, IntelliJ, etc.).

3. Configure as informações do banco de dados no arquivo `biblioteca/hsqldb.jar`.

## Uso
1. Inicie o servidor:


## Rotas da API
Para acessar a API, utilize o seguinte endpoint base: `http://localhost:8080/biblioteca-api`.

### Livros
- **GET /livros**: Retorna todos os livros cadastrados.
- **GET /livros/{id}**: Retorna detalhes de um livro específico.
- **POST /livros**: Adiciona um novo livro.
- **PUT /livros/{id}**: Atualiza informações de um livro existente.
- **DELETE /livros/{id}**: Remove um livro do sistema.

### Autores
- **GET /autores**: Retorna todos os autores cadastrados.
- **GET /autores/{id}**: Retorna detalhes de um autor específico.
- **POST /autores**: Adiciona um novo autor.
- **PUT /autores/{id}**: Atualiza informações de um autor existente.
- **DELETE /autores/{id}**: Remove um autor do sistema.

### Usuários
- **GET /usuarios**: Retorna todos os usuários cadastrados.
- **GET /usuarios/{id}**: Retorna detalhes de um usuário específico.
- **POST /usuarios**: Adiciona um novo usuário.
- **PUT /usuarios/{id}**: Atualiza informações de um usuário existente.
- **DELETE /usuarios/{id}**: Remove um usuário do sistema.
- 
## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue para relatar problemas ou propor melhorias. Se preferir, você pode fazer um fork deste repositório e enviar um pull request com suas alterações.
