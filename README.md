**Documentação da API de Livros**

A API de Livros permite gerenciar informações sobre livros, incluindo a criação, atualização, exclusão e busca de livros. A API foi construída utilizando o framework Spring Boot em conjunto com o banco de dados MySQL.

### Endpoints da API

A seguir, estão listados os endpoints disponíveis na API:

1. **Listar todos os livros**

   - Método: GET
   - URL: `/books`
   - Descrição: Retorna uma lista com todos os livros cadastrados no sistema.

2. **Buscar livro por ID**

   - Método: GET
   - URL: `/books/{id}`
   - Parâmetros:
     - `id`: ID do livro a ser buscado.
   - Descrição: Retorna os detalhes do livro com o ID especificado.

3. **Cadastrar um novo livro**

   - Método: POST

   - URL: `/books`

   - Corpo da requisição (em JSON):

     ```json
     {
       "title": "1984",
       "author": "George Orwell",
       "publicationYear": 1949
     }
     ```

   - Descrição: Cadastra um novo livro com os dados fornecidos no corpo da requisição.

4. **Atualizar um livro**

   - Método: PUT

   - URL: `/books/{id}`

   - Parâmetros:

     - `id`: ID do livro a ser atualizado.

   - Corpo da requisição (em JSON):

     ```json
     {
       "title": "Novo Título",
       "author": "Novo Autor",
       "publicationYear": 2023
     }
     ```

   - Descrição: Atualiza os dados do livro com o ID especificado de acordo com os dados fornecidos no corpo da requisição.

5. **Excluir um livro por ID**

   - Método: DELETE
   - URL: `/books/{id}`
   - Parâmetros:
     - `id`: ID do livro a ser excluído.
   - Descrição: Exclui o livro com o ID especificado do sistema.

6. **Excluir todos os livros**

   - Método: DELETE
   - URL: `/books`
   - Descrição: Exclui todos os livros cadastrados no sistema.

### Tratamento de Exceções

A API faz uso de tratamento de exceções para garantir que os erros sejam adequadamente tratados e retornem respostas adequadas ao cliente. As seguintes exceções são tratadas na API:

1. **BookNotFoundException (404 Not Found)**:
   - Descrição: Lançada quando um livro não é encontrado por um determinado ID.

2. **InvalidBookDataException (400 Bad Request)**:
   - Descrição: Lançada quando os dados fornecidos para cadastrar ou atualizar um livro são inválidos ou estão em formato incorreto.

3. **MethodArgumentNotValidException (400 Bad Request)**:
   - Descrição: Lançada quando os dados fornecidos no corpo da requisição não passam nas validações do DTO de livro (BookDTO).

4. **DataIntegrityViolationException (409 Conflict)**:
   - Descrição: Lançada quando ocorre uma violação de integridade de dados, por exemplo, ao tentar cadastrar um livro com um título que já existe no sistema.

### Boas Práticas Adotadas

Ao longo do desenvolvimento da API, foram seguidas algumas boas práticas para garantir a qualidade e a manutenibilidade do código:

- Uso de validações com anotações no DTO (Data Transfer Object) para garantir a consistência dos dados fornecidos nas requisições.
- Separação das responsabilidades em camadas, como Controller, Service e Repository, para melhor organização e facilidade de manutenção.
- Tratamento adequado de exceções para retornar respostas claras e informativas ao cliente.
- Utilização do padrão DTO para separar a representação dos dados na API da representação dos dados no banco de dados.
- Utilização do padrão RESTful para nomear os endpoints e definir as operações da API de forma padronizada.

### Conclusão

A API de Livros oferece funcionalidades para cadastrar, atualizar, excluir e buscar informações sobre livros de forma simples e eficiente. As boas práticas adotadas ao longo do desenvolvimento garantem a qualidade e a confiabilidade da API. O tratamento de exceções contribui para uma experiência melhor do usuário, fornecendo respostas claras e informativas em caso de erros. A API é uma solução robusta para gerenciar informações sobre livros e pode ser facilmente integrada a outros sistemas e aplicações.
