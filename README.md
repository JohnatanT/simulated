# Guia rápido do Projeto

O projeto é **open-source**. Sintam-se a vontade para realizar pull requests e melhorias em cima dele.

### Estrutura

O projeto possui atualmente a seguinte estrutura: [Drive](https://drive.google.com/file/d/1pezjOINmsVlKRo3pRps8Xc76OCspCgjD/view?usp=sharing)

A ideia é que exista um "banco de questões", parecido com o ENEM. Onde possa haver a utilização das questões novamente em outras provas.

Uma mudança na estrutura é na hora de responder uma questão. Nesse momento é salvo a informação se está correto ou não, de acordo com o gabarito.
Isso ajuda a economizar tempo e processamento na hora de trazer o rank dos alunos de acordo com um simulado.

Esse processo também poderia ser feito através de uma trigger no banco de dados.


#### Banco de Dados

Foi utilizado o banco de dados em memória: **H2**
O mesmo é usado tanto para o desenvolvimento como os testes unitários.

Não é preciso instalar nenhum banco de dados no sistema.

#### Dados do projeto

O projeto utiliza o **flyway** para versionamento do banco e o **dbunit** para popular o banco de testes e criar os cenários dos mesmos.


## Documentação com SWAGGER

O projeto possui a documentação online dos seus endpoints no **swagger** através do swagger-ui.

Para acessar basta entrar no endereço:

```txt
localhost:8080/swagger-ui.html
```
Os seguintes endpoints estão disponíveis:

* GET /simulated/rank/{id} -> Retorna o rank de um simulado
* POST /answers -> Responde uma questão. É preciso informar a questão, o item, o estudante e qual a prova.
* GET /feedbacks/proof/{id} -> Retorna o gabarito de uma prova
* GET /simulated -> Retorna as informaçẽos do simulado e as que o compões

## Executando o projeto Localmente

#### Executando Testes

Para executar os testes do projeto basta após baixa-lo, entrar na pasta e executar o seguinte comando:

```txt
mvn clean test
```

#### Executando como JAR

Depois de ter baixado o projeto e entrado na pasta dele. Podemos gerar o .jar na nossa máquina e então executa-lo.

```bash
echo 1 | mvn clean install -DskipTests
echo 2 | cd /target/
echo 3 | java -jar simulated-{version}.jar
```


### Executando como Docker

* Caso prefira executar o projeto com o docker, sem ter que baixa-lo. Podemos executar o seguinte comando:

```bash
sudo docker run -p 8080:8080 johnatant/simulated:latest
```

Foi utilizado o Jib para a criação da imagem e deploy no DockerHub.

## Executando o remotamente

### Hospedado no Heroku

Para aqueles que querem apenas testar o projeto sem baixar nada na máquina, pode-se acessar o link para o projeto hospedado no heroku.

```txt
mvn clean test
```

## Dúvidas

* johnatantavares9@gmail.com