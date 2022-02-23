# 🤣 Persistent-Jokes
Spring boot application to retrieve jokes from Jokes API ONE and make them persistent

<h2 align="left">Languages & Tools Used: 🛠️</h3>
<p align="left"> <a href="https://www.java.com" target="_blank" rel="noreferrer"> 
<img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> 
<a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> 
<img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="40" height="40"/> </a> 
<a href="https://postman.com" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/getpostman/getpostman-icon.svg" alt="postman" width="40" height="40"/> </a> 
<a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> 
</p>

## 🤓 Assumptions: 
- You have mysql installed and running
- Postman installed and running
- You have Java 11 or higher installed
- Compatible browser such as Google Chrome

# Application has 2️⃣ sections
## ☸ API
- The API is used to consume Joke of the day from with the request URL: Copyright ©`https://api.jokes.one/jod` from Copyright ©`2019-20 https://jokes.one`
- This uses a scheduler to get the joke of the day (JOD) from the joke API and store it a SQL database

## 🧰 Application
- Used to create your own jokes and store in SQL database
- Allows you to create, read update, and delete jokes (CRUD)

The above can be done in two way: Using Swagger or Postman Collection

# 🚀 Starting the application

- Execute the `schema.sql` file to create the schema titled:`jokes`
- Change the mysql user and password configuration in the application.yml if need be to suit your configuration
- Open the application in your respective IDE for Java. Such as Intellij IDEA, VS Code or Netbeans
- Run the application, build will start with all MAVEN dependencies being downloaded, the application will be start up on port `5000`
- When the service is running import the `Persistent_Jokes.postman_collection.json` file in Postman
- Send the HTTP request in the Postman collection to interact with the application 
- Alternatively access the Swagger UI on `http://localhost:5000/swagger-ui.html` and try out the available end points

### Swagger 2
- After successfully starting the application.
- Navigate to `http://localhost:5000/swagger-ui.html` to see and try out the available rest endpoints.

### Postman <a href="https://postman.com" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/getpostman/getpostman-icon.svg" alt="postman" width="40" height="40"/> </a> 
- After successfully starting the application.
- Open Postman and import the `Persistent_Jokes.postman_collection.json`
- Gives you the following:
    - GET methods
        - getJokeById
        - getAllJokes
    - POST method
        - saveJoke
    - PUT method
        - updateJoke
    - DELETE method 
        - deleteJoke
  
  ## 📝 License
  
  Copyright © 2022 [Malesela Sithole](https://github.com/HoodLum-1).<br />
  This project is [MIT](https://github.com/HoodLum-1/route-scores/blob/main/LICENSE) licensed.
