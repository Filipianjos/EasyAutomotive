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

### Cadastrar Mecânico:
- **Método**: `Post`
- **Endpoint**: `\mecanico`

#### Atributos
| Coluna     | Tipo   | Requerido?  |
|------------|--------|-------------|
| technician | String | Sim         |

#### Exemplo de retorno:
```Json
{
	"technician": "Diego Fernandes"
}
```

### Cadastrar clientes:

#### Atributos
| Coluna     | Tipo   | Requerido? |
|------------|--------|------------|
|name        | String | sim        |
|lastname    | String | sim        |
|cpfCnpj     | String | sim        |
|email       | String | sim        |
|phone       | String | sim        |

### Cadastrar Mecânico:
- **Método**: `Post`
- **Endpoint**: `\cliente`

#### Exemplo de retorno:
```Json
  {
    "name": "Filipi",
    "lastname": "Anjos",
    "cpfCnpj": "123.456.789-10",
    "email": "filipiteste@anjos.com.br",
    "phone": "1199875-8547"
  }
```
### Consultar cliente por Id:
- **Método**: `Post`
- **Endpoint**: `\cliente\{id}`

#### Exemplo de retorno:
```Json
    {
      "id": 1,
      "name": "teste",
      "lastname": "via sql",
      "cpfCnpj": "123.456.789",
      "email": "teste@viasql.com",
      "phone": "11990237174"
    }
```

---