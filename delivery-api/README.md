📝 README.md — Delivery API
📦 Descrição do Projeto
Delivery API é uma aplicação REST desenvolvida com Spring Boot e JDK 21, voltada para gerenciamento de entregas. O projeto foi criado como parte de um curso prático, com foco em boas práticas de desenvolvimento, testes de endpoints, uso de banco em memória (H2) e recursos modernos do Java.

🚀 Como Executar Localmente
Pré-requisitos:

Java 21 instalado
Maven instalado
IDE (IntelliJ, VS Code, Eclipse) ou terminal

Passos:


1 - Clone o repositório: https://github.com/RyanAlmeida25/delivery-api--Ryan-Iury-X-

2 - Execute a aplicação pela IDE

3 - Acesse os endpoints via navegador ou Postman:

http://localhost:8080/health
http://localhost:8080/info
http://localhost:8080/h2-console

🧪 Testes Realizados

✅ Aplicação executada com sucesso usando Java 21
✅ Endpoints /health e /info testados via Postman
✅ Console H2 acessado e funcional
✅ Logs verificados com versão do Java e DevTools ativo
✅ Hot reload testado com Spring DevTools


🛠️ Tecnologias Utilizadas

Java 21 (com uso de Text Blocks e Records)
Spring Boot 3.5.7
Spring Data JPA
H2 Database (em memória)
Spring DevTools
Lombok
Maven

🔧 Configuração

Porta: 8080
Banco de dados: H2 (em memória)
Profile ativo: development

# Desenvolvedor

Ryan Iury Xavier Laranjeira de Almeida
RA: 13625110675  Turma: Análise e Desenvolvimento de sistemas FPB

Desenvolvido com JDK 21 e Spring Boot 3.2.x


API REST para gerenciamento de clientes, restaurantes, produtos e pedidos em uma plataforma de delivery.

🚀 Tecnologias utilizadas

Java 17+
Spring Boot
Spring Data JPA
H2 (ou outro banco relacional)
Maven


▶️ Como executar o projeto


Clone o repositório:
git clone https://github.com/seu-usuario/deliverytech.git
cd deliverytech


Execute o projeto:
./mvnw spring-boot:run


Acesse a API:
http://localhost:8080



🧪 Como testar
Execute os testes com o comando:
./mvnw test
Certifique-se de que o banco de dados de testes (ex: H2) está configurado corretamente.

📘 Exemplos de uso dos endpoints
Cliente


POST /clientes
Cadastrar cliente
Body:
{
"nome": "João Silva",
"email": "joao@email.com",
"telefone": "99999-9999"
}


GET /clientes
Listar clientes ativos


GET /clientes/{id}
Buscar cliente por ID


PUT /clientes/{id}
Atualizar cliente
Body:
{
"nome": "João Atualizado",
"telefone": "88888-8888"
}


DELETE /clientes/{id}
Inativar cliente



Restaurante


POST /restaurantes
Cadastrar restaurante
Body:
{
"nome": "Pizza da Vila",
"categoria": "Pizza",
"avaliacao": 4.5
}


GET /restaurantes
Listar todos os restaurantes


GET /restaurantes/ativos
Listar restaurantes ativos


GET /restaurantes/{id}
Buscar restaurante por ID


PUT /restaurantes/{id}
Atualizar restaurante


DELETE /restaurantes/{id}
Inativar restaurante


PUT /restaurantes/{id}/ativar
Ativar restaurante


GET /restaurantes/categoria/{categoria}
Buscar restaurantes por categoria



Produto


POST /produtos/restaurante/{restauranteId}
Cadastrar produto para restaurante
Body:
{
"nome": "Pizza Calabresa",
"descricao": "Com queijo e cebola",
"categoria": "Pizza",
"preco": 39.90
}


GET /produtos/restaurante/{restauranteId}
Listar produtos por restaurante


GET /produtos/{id}
Buscar produto por ID


PUT /produtos/{id}
Atualizar produto


PUT /produtos/{id}/disponibilidade?disponivel=true
Alterar disponibilidade do produto


GET /produtos/categoria/{categoria}
Buscar produtos por categoria


GET /produtos/nome/{nome}
Buscar produtos por nome



Pedido


POST /pedidos/cliente/{clienteId}
Criar pedido
Body:
{
"valorTotal": 100.0
}


PUT /pedidos/{id}/status?status=FINALIZADO
Atualizar status do pedido


GET /pedidos/cliente/{clienteId}
Buscar pedidos por cliente


GET /pedidos/{id}
Buscar pedido por ID



📄 Licença
Este projeto é open-source e está sob a licença MIT.
