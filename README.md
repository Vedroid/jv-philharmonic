## Philharmonic ticket-office

In this project used N-tier architecture with DB layer, DAO layer, Service layer and Controllers layer. <br>
Project was developed according to SOLID principles with authorization and authentication.

#### UML diagram that describes the relationship between the entities

<img src="https://github.com/Vedroid/images-in-readme/blob/main/project_philharmonic_uml.png" alt="project_philharmonic_uml" width="600"/>

### Project Structure

The project has an N-tier structure and consists of the database layer, the DAO layer for
interaction with the database, the service layer which contains the business logic, and the
controllers layer.  

##### Users can perform the following actions:

- Registration
- Authorization
- View a list of available concerts
- View the list of stages
- Find session by date
- View order list
- Add sessions to shopping cart
- Make an order

##### Admins in their turn can:

- View / add concerts
- View / add stages
- Add concerts session
- Find session by date
- Find user by email

### Technologies Used

- Java 11
- Spring Core, MVC, Security
- Hibernate
- Hibernate Validator
- PostgreSQL
- Apache Maven
- Apache Tomcat
- Apache Log4j 2
- Maven Checkstyle Plugin

### To start the project you need:

1) Download and install the
   [JDK](https://www.oracle.com/java/technologies/javase-downloads.html, "Download JDK")
2) Download and install servlet container
   (for example Apache [Tomcat](https://tomcat.apache.org/download-90.cgi, "Download Tomcat"))
3) Download and install SQL Server
   (for example [PostgreSQL](https://www.postgresql.org/download/, "Download PostgreSQL"))
4) Clone this project into your local folder and open the project in an IDE
5) Configure Tomcat Server and your SQL server on your machine.
6) Configure your connection properties in `resources/db.properties`.
7) Run a project

### Author

[Vadim Okulov](https://github.com/Vedroid)
