---
tags: [rest]
projects: [spring-framework]
---
:spring_version: current
:toc:
:project_id: desafio-rest-service
:spring_version: current
:spring_boot_version: 1.3.0.M4
:icons: font
:source-highlighter: prettify

# Descrição dos Recursos

Essa solução fornece um serviço da Web API RESTful para possibilitar a leitura e manutenção da lista de indicados e vencedores da categoria Pior Filme do Golden Raspberry Awards.

* Usando Spring Boot.
* Um esforço para atender as práticas (HTTP Verbos) identificada no Nível 2 dentro do modelo de maturidade de Leonard Richardson.
* O serviço irá trabalhar com CSV como inserção inicial de dados.
* Utilizando o padrão de projeto DTO (Data Transfer Object) - Em resumo superficial esse padrão de projeto utiliza um objeto simples para transferir dados de um local a outro na aplicação.
* Utilizando o Banco de dados H2. O H2 é um banco de dados Java leve e de código aberto. Incorporado neste aplicativo. O banco de dados H2 pode ser configurado para ser executado como um banco de dados na memória, o que significa que os dados não persistirão no disco, assim a base de dados fica rodando na memória sem a necessidade de nenhuma instalação ou serviço de banco de dados externo, mas que também perde todos os dados e alterações realizadas neles ao finalizar a aplicação.
* Carregamento automático dos dados contidos em arquivo CSV, em um processo iniciado junto com a aplicação.

# Recursos Providos
O projeto fornece e integra testes que aceitará solicitações para os métodos:

## Endpoins
Obtém o produtor com maior intervalo entre dois prêmios, e o que obteve dois prêmios mais rápido.

----
http://localhost:8080/movies/awardsinterval
----

Exemplo de resposta:

[source,json]
----
{
    "min": [
        {
            "producer": "Wyck Godfrey, Stephenie Meyer and Karen Rosenfelt",
            "interval": 1,
            "previousWin": 2011,
            "followingWin": 2012
        }
    ],
    "max": [
        {
            "producer": "Bo Derek",
            "interval": 6,
            "previousWin": 1984,
            "followingWin": 1990
        }
    ],
}