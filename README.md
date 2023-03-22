<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Quarkus Social - Read Me</title>
</head>
<body>
	<h1>Quarkus Social</h1>
    <p>Este é um projeto de exemplo que demonstra como construir uma aplicação web de rede social usando Quarkus, um framework Java para Cloud Native. A aplicação permite que os usuários se inscrevam, façam login, publiquem posts, sigam outros usuários e vejam os posts em suas linhas do tempo.</p>

<h2>Como usar</h2>

<p>Para executar o projeto, você precisa ter o JDK 11 ou superior instalado em seu computador. Também é recomendado ter o Docker instalado, para executar o banco de dados PostgreSQL em um container.</p>

<ol>
	<li>Clone o repositório para o seu computador:</li>
</ol>

<pre><code>git clone https://github.com/AndreFressatti/quarkus-social.git</code></pre>

<ol start="2">
	<li>Navegue até o diretório do projeto:</li>
</ol>

<pre><code>cd quarkus-social</code></pre>

<ol start="3">
	<li>Execute o banco de dados PostgreSQL em um container Docker:</li>
</ol>

<pre><code>docker run --ulimit memlock=-1:-1 -it --rm=true --memory-swappiness=0 \
--name quarkus_social_postgres -e POSTGRES_USER=quarkus_social \
-e POSTGRES_PASSWORD=quarkus_social -e POSTGRES_DB=quarkus_social \
-p 5432:5432 postgres:12</code></pre>

<ol start="4">
	<li>Execute a aplicação usando o comando Maven:</li>
</ol>

<pre><code>./mvnw compile quarkus:dev</code></pre>

<ol start="5">
	<li>Acesse a aplicação em seu navegador em http://localhost:8080.</li>
</ol>

<h2>Tecnologias utilizadas</h2>

<ul>
	<li>Quarkus: Framework Java para Cloud Native</li>
	<li>Hibernate: Framework ORM para persistência de dados</li>
	<li>PostgreSQL: Banco de dados relacional</li>
	<li>React: Biblioteca JavaScript para construção de interfaces de usuário</li>
	<li>Bootstrap: Framework CSS para construção de interfaces de usuário responsivas</li>
</ul>

<h2>Contribuindo</h2>

<p>Sinta-se à vontade para contribuir com o projeto, abrindo issues, enviando pull requests ou fornecendo feedback. Todas as contribuições são bem-vindas!</p>
</body>
</html>
