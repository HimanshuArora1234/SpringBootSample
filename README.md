# SpringBootSample
Spring boot + JPA DATA sample project with RestFul controllers. This application's front end uses ReactJS(Fluxx). <br/>
It provides stateless session management using a browser cookie and AES encryption/decryption.

##Tech env
  - Java8
  - Spring boot
  - Spring JPA DATA
  - H2 memory database
  - REST
  - HTML5
  - CSS3 (Stylus
  - ReactJS (Fluxx)

##To run
  1. ```mvn clean install```
  2. ```mvn spring-boot:run```
  3. Goto ```http://localhost:8080/```   ("/" controller returns the HTML page)
  4. Goto ```http://localhost:8080/hello```  ("/hello" RESTFul controller)
  5. Goto ```http://localhost:8080/add```  (RestFUL controller to insert mocked user data in database, call this endpoint as many time as the number of insertions you want)
  6. Goto ```http://localhost:8080/all```  (RestFUL controller to retrieve all the users from database)
  
##Package app
  1. ```mvn package``` (with the help of spring boot maven plugin this command prepares a complete JAR of you web app with all the dependencies, ready to run)
  2. ```java -jar your_packaged_application_jar.jar``` (To run the application. Packaged jar will be available in the target folder of your project as for example ```springBootTest-0.1.0.jar```)
  3. Goto ```http://localhost:8080/``` to access your running spring boot application.
  4. Test rest API : http://localhost:8080/swagger-ui.html
