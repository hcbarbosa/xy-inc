# Projeto xy-inc (Plataforma baseada em serviços)

O projeto foi desenvolvido a fim de resolver o seguinte problema:
Você foi contratado para desenvolver uma plataforma baseada que forneça 3 serviços.

- Serviço para cadastrar pontos de interesse com 3 atributos: Nome do POI, Coordenada X (inteiro não negativo) Coordenada Y (inteiro não negativo). 
- Serviço para listar todos os POIs cadastrados. 
- Serviço para listar POIs por proximidade. Este serviço receberá uma coordenada X e uma c oordenada Y, especificando um ponto de referência, em como uma distância máxima (dmax) em metros.

### Resumo das Tecnologias utilizadas
- Java 1.8
- Spring Boot 1.5.3
- Spring Data
- MySQL
- Flyway
- Lombok
- Spring Boot Devtools
- Rest-assured

### Definições da aplicação

Para resolver o problema abordado anteriormente, foi implementado um web service REST simples com o [Spring Boot](https://spring.io/guides/gs/rest-service/) para agilizar no desenvolvimento e  [Spring Data]( http://projects.spring.io/spring-data/) que irá prover as operações necessárias para adicionar um novo ponto de interesse e realizar as consultas. Foi utilizado o [Tomcat]( https://spring.io/blog/2014/03/07/deploying-spring-boot-applications) como servidor de aplicação padrão do Spring Boot, o [MySQL]( https://www.mysql.com/) como banco de dados e o [Maven](https://maven.apache.org/) para o gerenciamento das dependências. 

Também foi configurado o [Flyway](https://flywaydb.org/), um gerenciador de banco de dados relacionais, para que quando o projeto for inicializado a ferramenta possa criar a tabela de ponto de interesse e inserir alguns registros automaticamente, também existe o [Lombok](https://projectlombok.org/) no projeto com o intuito de diminuir a verbosidade do código e o [Rest Assured](http://rest-assured.io/) para validar e testar as requisições. 

Foi criado um aplicação cliente utilizando [AngularJS](https://angularjs.org/) para inserção de um novo ponto de interesse (POST) e consultas (GET), testando assim a comunicação entre cliente-servidor. Para os testes de requisição foi utilizada a ferramenta  [POSTMAN](https://www.getpostman.com/).
	

## Instruções para execução

Existem dois projetos poi (back-end) e client (front-end). Abaixo, segue as instruções que irão permitir que você possa rodar a aplicação e realizar os testes localmente. 

### Download da aplicação (Windows)

Execute em linha de comando:
```
$ git clone https://github.com/hcbarbosa/xy-inc.git
```

### Necessário a criação do banco de dados

Quando o projeto iniciar, o Flyway irá procurar pelo banco de dados para verificar divergências entre script e base de dados.

Execute no MySQL:

```
CREATE DATABASE xy_inc;
```

Obs: Necessário alteração no arquivo application.properties em /resources do nome do usuário do banco de dados e senha.

### Execução da aplicação

Acesse a pasta da aplicação:

```
$ cd xy-inc\poi
```

Execute comando maven:

```
$ mvn clean
```

Para iniciar o serviço basta executar:
```
$ mvn spring-boot:run
```

## Testes da aplicação

##### Pontos de Interesse #####

Endereço: http://localhost:8085

Url           |HTTP Verb        |Request Body  | Descrição
--------------|------------- |------------- | -------------
/pontoInteresse      |GET          |void|   lista todos os pontos de interesses cadastrados na aplicação.
/pontoInteresse      |POST         |JSON|   cria um novo ponto de interesse.
/pontoInteresse/{x}/{y}/{distance}|GET|void| busca pontos de interesse baseado em uma localização `x`, `y` e uma distância máxima (`distance`).

Serviço 1: Salvar novo ponto de interesse (POI)
 
	 Method: POST
	 URI: /pontoInteresse
	 data: {
	      nome   : String
	      x : number
	      y : number
	 }
   
  Requisição:
  ```
  POST  http://localhost:8085/pontoInteresse
  
  body: 
  {
    "nome": "Discoteca",
    "x": 15,
    "y": 9
  }
  ```
  Resposta:
  ```
  HTTP/1.1 201 "" 272ms
  
  Date: Fri, 12 May 2017 11:36:34 GMT
  Transfer-Encoding: chunked
  Content-Type: application/json;charset=UTF-8
  
  {"id":8,"nome":"Discoteca","x":15,"y":9}
  ```

Serviço 2: Listar todos os POIS cadastrados

	Method: GET
	URI: /pontoInteresse
  
  Requisição:
  ```
  GET  http://localhost:8085/pontoInteresse
  ```
  Resposta:
  ```
  HTTP/1.1 200 "" 87ms
  
  Date: Fri, 12 May 2017 11:37:55 GMT
  Transfer-Encoding: chunked
  Content-Type: application/json;charset=UTF-8
  
  [{"id":1,"nome":"Lanchonete","x":27,"y":12},{"id":2,"nome":"Posto","x":31,"y":18},{"id":3,"nome":"Joalheria","x":15,"y":12},{"id":4,"nome":"Floricultura","x":19,"y":21},{"id":5,"nome":"Pub","x":12,"y":8},{"id":6,"nome":"Supermercado","x":23,"y":6},{"id":7,"nome":"Churrascaria","x":28,"y":2},{"id":8,"nome":"Discoteca","x":15,"y":9}]
  ```
  
Serviço 3: Listar os POIs próximos a um ponto (x,y) com uma distância máxima (distance)
 
	 Method: GET
	 URI: /pontoInteresse
	 params: 
	      x     : number
	      y     : number
	      distance : number
  
  Requisição:
  ```
  http://localhost:8085/pontoInteresse/20/10/8
  ```
  Resposta:
  ```
  HTTP/1.1 200 "" 69ms
  
  Date: Fri, 12 May 2017 11:38:58 GMT
  Transfer-Encoding: chunked
  Content-Type: application/json;charset=UTF-8
  
  [{"id":3,"nome":"Joalheria","x":15,"y":12},{"id":6,"nome":"Supermercado","x":23,"y":6},{"id":8,"nome":"Discoteca","x":15,"y":9}]
  ```
