<div align="center">
  <a href="#-versão-em-português">🇧🇷 Ler em Português</a> | <a href="#-english-version">🇺🇸 Read in English</a>
</div>

---

## 🇧🇷 Versão em Português

#  Sistema VIP: Desktop MVC, Maven, API REST e SQLite

Este é um projeto **Full-Stack Desktop** nativo em **Java**. O sistema evoluiu de um script simples para uma aplicação robusta utilizando a arquitetura **MVC**, padrão **DAO** e gerenciamento profissional de dependências com **Maven**.

###  Funcionalidades e Arquitetura
* **Gerenciamento com Maven:** Build e injeção de dependências automatizados via `pom.xml`, substituindo a gestão manual de arquivos `.jar`.
* **Ciclo CRUD Completo:** Implementação de operações de banco de dados para Criar (Create), Ler/Listar (Read) e Deletar (Delete) registros via comandos SQL.
* **Arquitetura Limpa (MVC & DAO):** A interface visual (`View`) é totalmente isolada do banco de dados (`DAO`). Os dados trafegam pelo sistema encapsulados em objetos (`Model`), garantindo escalabilidade.
* **Interface Gráfica e API:** Interface construída com **Java Swing**. O cadastro consome a API RESTful do ViaCEP (`java.net.http.HttpClient`) para autocompletar endereços via JSON.
* **Banco de Dados Relacional:** Persistência nativa com **SQLite** utilizando JDBC e `PreparedStatement` para prevenção de SQL Injection.

###  Tecnologias
* **Linguagem:** Java (JDK 11+)
* **Build Tool:** Apache Maven
* **Paradigmas:** POO, MVC, DAO
* **Front-end:** Java Swing
* **Banco de Dados:** SQLite (JDBC)

---
*Desenvolvido por Italo Rocha de Almeida Ferreira - Estudante de Engenharia de Software*

<br>

---

## 🇺🇸 English Version

#  VIP System: Desktop MVC, Maven, REST API & SQLite

This is a **Full-Stack Desktop** project built natively in **Java**. The system evolved from a simple script into a robust application utilizing the **MVC** architecture, **DAO** pattern, and professional dependency management with **Maven**.

###  Features and Architecture
* **Maven Management:** Automated build and dependency injection via `pom.xml`, replacing manual `.jar` file handling.
* **Full CRUD Cycle:** Implementation of database operations to Create, Read/List, and Delete records using raw SQL commands.
* **Clean Architecture (MVC & DAO):** The visual interface (`View`) is strictly isolated from the database (`DAO`). Data travels through the system encapsulated in objects (`Model`), ensuring scalability.
* **GUI and API Integration:** Interface built with **Java Swing**. The registration form consumes the ViaCEP RESTful API (`java.net.http.HttpClient`) to dynamically autocomplete addresses via JSON.
* **Relational Database:** Native persistence with **SQLite** using JDBC and `PreparedStatement` to prevent SQL Injection.

###  Technologies
* **Language:** Java (JDK 11+)
* **Build Tool:** Apache Maven
* **Paradigms:** OOP, MVC, DAO
* **Front-end:** Java Swing
* **Database:** SQLite (JDBC)

---
*Developed by Italo Rocha de Almeida Ferreira - Software Engineering Student*