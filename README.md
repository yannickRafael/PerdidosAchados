# PerdidosAchados

**PerdidosAchados** is a Spring Boot-based backend application designed to manage reports of lost and found items. The system connects to a MySQL database for efficient management of data related to user reports, item categories, and the overall system functionality.

## Features

- **Report Lost/Found Items**: Users can report items that they have lost or found with all necessary details, including location, category, and description.
- **Item Status Management**: Allows the update of item status (e.g., claimed, resolved).
- **MySQL Database Integration**: All data, including user reports and item details, are stored securely in a MySQL database.
- **REST API**: Exposes endpoints for frontend integration and third-party applications.
- **User Authentication**: Basic user authentication using JWT for securing endpoints.

## Tech Stack

- **Backend**: Spring Boot (Java) - for creating REST APIs.
- **Database**: MySQL - for persistent data storage.
- **Security**: Spring Security and JWT - for handling user authentication and securing APIs.
- **Build Tool**: Maven - for project management and building.

## Requirements

- **Java 17+**
- **Maven**
- **MySQL Server**
- **Postman** (for API testing)

## Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yannickRafael/PerdidosAchados.git
   ```

2. **Navigate to the project directory:**
   ```bash
   cd PerdidosAchados
   ```

3. **Configure MySQL Database:**

   Create a database in MySQL:
   ```sql
   CREATE DATABASE perdidosachados;
   USE perdidosachados
   ```
   [Download the dump](https://github.com/yannickRafael/PerdidosAchados/blob/master/database/perdidosachados_dump.sql)
   OR
   [Download the commands to create the tables](https://github.com/yannickRafael/PerdidosAchados/blob/master/database/PerdidosAchadosCreation.sql) 
   
   

   Add the database credentials to `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/perdidosachados
   spring.datasource.username=<username>
   spring.datasource.password=<password>
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
   ```

5. **Build the project using Maven:**
   ```bash
   mvn clean install
   ```

6. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints



## Features to Implement

### Backend

- **Authentication**: Secure login and user registration using Spring Security and JWT.
- **Authorization**: Role-based access control for various API endpoints.
- **Items match notification**: Send notification to users in case of items match.

## Contributing

1. Fork the repository.
2. Create your feature branch (`git checkout -b feature/new-feature`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/new-feature`).
5. Open a pull request.
