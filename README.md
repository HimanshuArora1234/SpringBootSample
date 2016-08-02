# SpringBootSample
Spring boot + JPA DATA sample project with one RestFul controllers.

##Tech env
  - Java8
  - Sprint boot
  - Sprint JPA DATA
  - H2 memory database
  - REST

##To run
  1. mvn clean install
  2. mvn spring-boot:run
  3. Goto http://localhost:8080/   ("/" controller returns the HTML page)
  4. Goto http://localhost:8080/hello  ("/hello" RESTFul controller)
  5. Goto http://localhost:8080/add  (RestFUL controller to insert mocked user data in database, call this endpoint as many time as the number of insertions you want)
  6. Goto http://localhost:8080/all  (RestFUL controller to retrieve all the users from database)
