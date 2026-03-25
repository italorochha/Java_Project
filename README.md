 Sistema VIP Desktop: MVC, API REST, SQLite e POO

Este é um projeto **Full-Stack Desktop** construído nativamente em **Java**. O sistema evoluiu de um script simples para uma aplicação robusta utilizando a arquitetura **MVC (Model-View-Controller)** e o padrão **DAO (Data Access Object)**, demonstrando as melhores práticas de Engenharia de Software.

 Funcionalidades e Arquitetura
* **Arquitetura Limpa (MVC & DAO):** O código foi refatorado para separar responsabilidades. A interface visual (`View`) não se comunica diretamente com o banco de dados. Toda a persistência de dados foi isolada na classe `ConvidadoDAO`, tornando o sistema escalável e fácil de manter.
* **Programação Orientada a Objetos (POO):** Aplicação prática de conceitos avançados como **Herança** (classes estendendo atributos base) e **Polimorfismo** (sobrescrita de métodos com `@Override` para comportamentos específicos).
* **Interface Gráfica (GUI):** Construída com **Java Swing**, capturando eventos assíncronos (`ActionListener`) para uma experiência de usuário fluida.
* **Consumo de API RESTful:** Integração via `java.net.http.HttpClient` para requisições HTTP ao servidor ViaCEP, processando dados JSON para autocompletar endereços dinamicamente.
* **Banco de Dados Relacional (SQLite):** Persistência estruturada com JDBC. Uso de comandos DDL e DML com `PreparedStatement` para garantir integridade e prevenir ataques de SQL Injection.

 Tecnologias Utilizadas
* **Linguagem:** Java (JDK 11+)
* **Paradigmas:** POO, Arquitetura MVC, Padrão DAO
* **Front-end:** Java Swing & AWT
* **Integração:** `java.net.http`
* **Banco de Dados:** SQLite e `java.sql` (JDBC)

---
*Desenvolvido por Italo Rocha de Almeida Ferreira - Estudante de Engenharia de Software*
