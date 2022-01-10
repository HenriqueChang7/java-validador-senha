# Documentação backend-challenge 

## Descrição do projeto
<p>Serviço web API para efetuar a validação de senha, a senha será válida onde a mesma possuir as seguintes informações:</p>

<ul>
  <li>Nove ou mais caracteres</li>
  <li>Ao menos 1 dígito</li>
  <li>Ao menos 1 letra maiúscula</li>
  <li>Ao menos 1 caractere especial</li>
  <ul>
    <li>Considere como especial os seguintes caracteres: !@#$%^&*()-+</li>
  </ul>
  <li>Não possuir caracteres repetidos dentro do conjunto</li>
</ul>

<p>Para efetuar a validação da senha, primeiramente verifiquei se o valor da varivel recebida era null, "" ou empty se ela não se enquadrasse em uma das 3 possibilidades, criei uma regex para validar se a senha possuia 9 ou mais caracteres, minimo de 1 digito, 1 letra maiúscula. Criei dois metodo privado, um para verificar se a senha possuia algum caracter repetido, varrendo caracter por caracter em um for verificando se o mesmo continha mais de uma vez e outro para verificar se a senha possuia um dos caracteres especiais obrigatórios inicializado no array.</p>

## Como executar o projeto
<ul>
  <li>Clone este repositório</li>
  <li>Certifique-se de usar JDK 11 e Maven 3.x</li>
  <li>Você pode construir o projeto e executar os testes executando mvn clean package</li>
  <li>Depois de construído com sucesso, você pode executar o serviço por um destes dois métodos:</li>
</ul>

```
java -jar target/java-validador-senha-0.0.1.jar
or
mvn spring-boot:run
```
### Validar senha

```
GET /validador/v1/validarSenha?senha=:senha

HTTP/1.1 200 OK
Date: Sum, 09 Jan 2022 12:36:30
Status: 200 OK
Connection: keep-alive
Content-Type: application/json

true
```


