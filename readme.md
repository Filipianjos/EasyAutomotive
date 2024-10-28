# EasyAutomotive

Easy Automotive é uma aplicação web que tem a função de gerar Ordens de Serviços de forma rápida e pratica para um melhor controle do serviços feitos.

#### Com ele é possível:
- Cadastrar mecânicos;
- Cadastrar clientes;
- Cadastrar veículos;
- Gerar e alterar as ordens de serviço;
- Detalhar o problema e reparo feito;
- Encerrar a o.S

## Tecnologias utilizadas:
- **Linguagem utilizada**: Java 17
- **API Framework**: SpringBoot
- **Banco de Dados:** PostgreSQL 16
- **Gerenciador de dependênicas:** Maven

---
# API

## Visão Geral:

Para a criação das API's, foi utilizado o SpringBoot e para testes o Insomnia

### Dependências:
- `Spring Data JPA`: Para a persistência do banco dedados.
- `Postgresql`: Drive de conexão de banco de dados.
- `Lombok`: Para a utilização de 'anotations', com o intuito de auxiliar na criação dos metodos de acesso e construtores.
- `Spring Data WEB`: Para dar suporte a útilização de MVC em aplicação WEB.
- `Spring DevTools`: Kit para auxilio no processo de desenvolvimento com `SpringBoot`.

## Ednpoints:

### Cadastrar Mecnico:
- **Método**: `Post`
- **Endpoint**: `\mecanico`

#### Dados requeridos
| Coluna     | Tipo   | Requerido?  |
|------------|--------|-------------|
| technician | String | Sim         |

#### Exemplo de requisição:
```Json
{
	"technician": "Diego Fernandes"
}
```