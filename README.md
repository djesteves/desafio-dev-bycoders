# Desafio programação - para vaga desenvolvedor
Projeto feito por Danilo João Esteves
Desenvolvedor fullstack
IDE utilizada: Visual Studio Code
# Linguagens Utilizadas
Java
# Frameworks
SpringBoot
AngularJS
# Instalação
Necessita Java JDK 11 ou maior, DOCKER e Angular CLI para execução.
#### Execute docker compose para iniciar o banco de dados:
```sh
docker-compose up
```
# Execute o backend na sua IDE de preferência
Tenha certeza que o backend esteja em execução para que as requisições sejam realizadas com sucesso.
# Execute o frontend na sua IDE de preferência
Execute o comando abaixo dentro da pasta frontend para baixar as dependências necessárias:
```sh
npm install
```
Após ter o Angular CLI instalado execute o seguinte comando:
```sh
ng serve --open
```
O frontend será executado na http://localhost:4200
# Consumir as apis diretamente
Para essa etapa eu utilizei o Postman, mas pode ser utilizado qualquer httpClient que quiser
# API para envio do arquivo CNAB
cURL: 
```sh
curl --location --request POST 'localhost:8080/v1/upload/cnab' \
--form 'file=@"{caminho_arquivo}/CNAB.txt"'
```
# API para consulta das lojas do arquivo CNAB
cURL:
```sh
curl --location --request GET 'localhost:8080/v1/upload/cnab'
```