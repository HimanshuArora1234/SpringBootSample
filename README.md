# SpringBootSample
Spring boot sample project with one RestFul controller &amp; one controller to return HTML template.

#To run
  1. mvn clean install
  2. mvn spring-boot:run
  3. Goto http://localhost:8080/   ("/" controller returns the HTML page)
  4. Goto http://localhost:8080/hello  ("/hello" RESTFul controller)
  5. Goto http://localhost:8080/add  (RestFUL controller to insert mocked user data in database, call this endpoint as many time as the number of insertion you want)
  6. Goto http://localhost:8080/all  (RestFUL controller to retrieve all the users from database)
