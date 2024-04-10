<h1>Customer API Documentation</h1>
customer api - spring boot application. This api is built with Spring Boot, utilizing MySQL for data storage. It exposes endpoints to manage customer information, including id, first_name, last_name, email, and phone_number. The API is designed to be powerful, scalable, and easy to integrate into your applications.


## Note
        It's My First Springboot Back-end Project In which I have Implemented Rest API
        and also uses postman to test api:)

        🌟 Thank you, me, for making it happen! Let's keep coding and building awesome things! 🚀

        🚀 Key Achievements:

        Developed a RESTful API that showcases my proficiency in Java and Spring Boot.
        Successfully handled the integration of MySQL, ensuring data persistence and reliability.
        Demonstrated a commitment to best practices, documentation, and a user-friendly API design.

## git clone https://github.com/yashtank86/customer-api-springboot.git

## Prerequisites
        Maven 3+.
        MySQL Workbench 8+.
        Postman v9+.

## Generate the Project
        Go to the website Spring Initializr to initialize the Spring Boot project. Add the following dependencies:
        Spring Boot DevTools: for the development tools.
        Lombok: to reduce boilerplate code (for example, getters and setters).
        Spring Web: to embed Apache Tomcat and include Spring MVC.
        Spring Data JPA: to facilitate the database layer.
        MySQL Driver: to enable communication between the Spring Boot application and the database.

## Navigate to the project directory:
| Directory Structure  |
|:-:|
| <img width="220" alt="image" src="https://github.com/yashtank86/custome-api-springboot/assets/52051877/cad2dbab-44d4-434d-8c9b-80b388949e0a"> |




## Configure the MySQL database connection in application.properties.
    spring.datasource.url = jdbc:mysql://localhost:9090/customer-management-system
    spring.datasource.username = root
    spring.datasource.password = root
    spring.jpa.hibernate.ddl-auto = update
    spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQLDialect

    server.error.include-stacktrace = never

    server.port = 8090
    
## mvn spring-boot:run
    The API will be accessible at http://localhost:8090/customer/save for POST method.
    http://localhost:8090/customer/retrieve/email=abc@gmail.com 
    := for GET method. Its uses emailId for retrieve the information from database

## Testing with Postman
        Test the application using Postman.
        Add a couple of customers.
        
        Enter the body of the request:
        
        {
            "first_name": "rahul",
            "last_name": "sharma",
            "email": "rs@gmail.com",
            "phoneNumber": "9515517878"
        }


## Select SEND, and rahul sharma will be saved into the database
| MySql |
|:-:|
| <img width="304" alt="image" src="https://github.com/yashtank86/custome-api-springboot/assets/52051877/10547848-937a-4660-a72c-dd534a7e232b"> |


## The project utilizes the following Tech:
    🌐 Tech Stack:
    🖥️ Java | Spring Boot | Hibernate
    🛢️ MySQL
    🚀 RESTful APIs
    🔧 Git | Maven
  
All dependencies are managed using Maven.

## Screenshorts
| GET {retrieve an customer from database using emailID} |
|:-:|
| ![img1](https://github.com/yashtank86/customer-api-springboot/assets/52051877/fd2e0a4c-d759-4965-a580-50fd239a7050) |


| Screen2 |
|:-:|
| ![img2](https://github.com/yashtank86/customer-api-springboot/assets/52051877/5c6b1272-b20e-4256-b09c-1d4468e11955) |


| mysql workbanch |
|:-:|
| ![img3](https://github.com/yashtank86/customer-api-springboot/assets/52051877/afb011de-9fff-44a0-8f32-1518bcea4da4) |


| POST {Create an customer} |
|:-:|
| ![img4](https://github.com/yashtank86/customer-api-springboot/assets/52051877/731b5a1c-a81f-42d1-a8ae-1f5d3748f604) |


## Usage
    Make requests to the specified endpoints using your preferred API client.
    Ensure proper authorization and authentication mechanisms are in place.
    Integrate the API into your applications to manage customer data efficiently.
## Contribution
    Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.

## License
    This project is licensed under the MIT License.
