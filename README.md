#API_G3
##Projeto de API para E-commerce
Este projeto de API utiliza como base o banco de dados construído na disciplina de banco de dados.
###Beans Iniciais
Para o e-commerce tradicional, os beans iniciais necessários são:
•	Cliente
•	Funcionário
•	Pedido
•	Produto
•	Categoria
###Requisitos Obrigatórios
Independente da opção acima, os seguintes requisitos são obrigatórios:
1.	Pacotes: O projeto deve ser organizado nos seguintes pacotes:
•	Config: Contém classes de configuração, como Swagger. Nome sugerido: NomeConfig.
•	Domain: Contém as classes bean, que representam as entidades do projeto. Nome sugerido: Nome.
•	Repositories: Contém as interfaces para cada bean, responsáveis pelas queries de consulta no banco. Nome sugerido: NomeRepository.
•	Services: Contém classes para cada repository, responsáveis pela lógica da requisição. Além disso, inclui classes extras que não possuem repository, como a classe EmailService. Nome sugerido: NomeService.
•	Controllers: Contém classes de requisição, responsáveis por receber e dar retorno às requisições. Nome sugerido: NomeController.
•	Exceptions: Contém classes de tratamento de exceções, responsáveis pelo retorno "amigável" dos erros enviados nas requisições de PUT e POST. Nome sugerido: NomeException.
•	DTO: Contém classes que funcionam como filtros, facilitando o envio e retorno das requisições de PUT e POST. Nome sugerido: NomeDTO.
•	Enums: Contém classes de constantes, facilitando a criação de combos (dropdown, checkbox, etc.) no frontend. Nome sugerido: NomeEnum.
•	security, security.jwt, security.domain, security.repositories, security.services, security.controllers, security.dto: Pacotes extras relacionados à segurança.
2.	Validações nas classes bean: Adicione anotações de validação adequadas nas classes bean para garantir a consistência dos dados.
3.	Construção do relacionamento nas classes bean: Verifique e implemente corretamente os relacionamentos entre as classes bean no banco de dados.
4.	CRUD completo para cada controller: Crie operações CRUD (Create, Read, Update, Delete) completas para cada entidade na camada de controller.
5.	Configuração de envio de e-mail: Crie uma conta de e-mail para o grupo e configure o envio de e-mails em duas requisições de escolha do grupo. Imagine uma situação real para essa escolha.
6.	Configuração do Swagger: Configure o Swagger para gerar documentação da API automaticamente.
7.	Utilização da API ViaCep: Utilize a API ViaCep para recuperar os dados de endereço do cliente/funcionário/usuário da aplicação. Será necessário criar um bean para endereço.
8.	Cadastro com foto: Permita o cadastro de cliente/funcionário/usuário/produto com foto. Será necessário criar um bean para foto.
9.	Configuração de segurança com JWT: Realize a configuração de segurança utilizando JWT (JSON Web Token).
10.	ReadMe, Commits, Branches e Tags: Crie um ReadMe para documentar o projeto. Utilize commits, branches e tags seguindo o padrão

## Tecnologias utilizadas

## Colaboradores
### Alunos
* [Bianca](https://github.com/Bianca-Gall)
* [Felipe](https://github.com/Felipe-Rubino)
* [Natalie](https://github.com/crznatalie/crznatalie)
* [Marcos](https://github.com/MarcosHBritto) 
* [Rafael](https://github.com/RafaelCarvalho90)

### Professora

* [Débora Souza](https://github.com/DebySouza)
