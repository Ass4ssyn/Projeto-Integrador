# Sistema de Estoque e Entregas

## Descrição
O **Sistema de Estoque e Entregas** foi desenvolvido como parte de um trabalho de conclusão de curso. O sistema visa gerenciar o controle de estoques e entregas, com funcionalidades de cadastro, listagem e confirmação de entregas, além de um sistema de alertas para estoques repetidos.

O sistema foi desenvolvido utilizando **Spring Boot**, com **MySQL** para persistência de dados, e **Thymeleaf** para renderização das páginas HTML. A aplicação possui autenticação de usuário, cadastro de usuários, estoques, e entregas, além de suporte à exclusão e confirmação de entregas.

## Funcionalidades

- **Login de usuário**: Autenticação de usuários com credenciais válidas.
- **Cadastro de usuários**: Funcionalidade de cadastro com validação de senhas e dados.
- **Estoque**:
  - Cadastro de materiais e sua quantidade no estoque.
  - Alerta para estoques repetidos.
- **Entregas**:
  - Cadastro de entregas e sua confirmação.
  - Exclusão de entregas.
- **Alertas**: Alerta visual no canto superior direito para estoques repetidos.
- **Responsividade**: O sistema foi projetado para ser responsivo, adaptando-se a diferentes resoluções de tela.

## Tecnologias Utilizadas

- **Backend**: Spring Boot 3.x
- **Banco de Dados**: MySQL
- **Frontend**: Thymeleaf, HTML5, CSS3, JavaScript
- **Gerenciamento de Dependências**: Maven
- **API Testing**: Postman

## Requisitos

- **Java**: Versão 17 ou superior.
- **MySQL**: Banco de dados configurado com o schema para o sistema.
- **NetBeans IDE** ou qualquer IDE compatível com Spring Boot.

