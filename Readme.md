<!DOCTYPE html><html><head><meta charset="utf-8"><title>Readme.md</title><style></style></head><body id="preview">
<h1 class="code-line" data-line-start=0 data-line-end=1><a id="BookSchelf_project_0"></a>BookSchelf project</h1>
<p class="has-line-data" data-line-start="2" data-line-end="3">This application allows you to store a list of books on a virtual library, stores information about the Author, Title, ISBN code, and number of pages. It is also possible to add comments to individual items.</p>
<h3 class="code-line" data-line-start=4 data-line-end=5><a id="Tech_4"></a>Tech</h3>
<p class="has-line-data" data-line-start="5" data-line-end="7">Project based on Spring Boot, Java 8.<br>
Project Lombok was used during development, to import project and run it properly in IDE You will need to add Lombok plugin <a href="https://projectlombok.org/setup/intellij">https://projectlombok.org/setup/intellij</a></p>
<p class="has-line-data" data-line-start="8" data-line-end="9">Ready to import Postman collection is in BookShelf.postman_collection.json.</p>
<h3 class="code-line" data-line-start=10 data-line-end=11><a id="Running_10"></a>Running</h3>
<p class="has-line-data" data-line-start="11" data-line-end="13">Run command: mvn spring-boot:run<br>
By default tomcat will start on localhost:8080</p>
<p class="has-line-data" data-line-start="14" data-line-end="16">To use MSSQL Database instead of H2 in memory, uncomment url in resources/application.properties<br>
and run command: docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=shelf -e MYSQL_USER=sa -e MYSQL_PASSWORD=password -d mysql:5.6</p>
</body></html>