#Consumer Application 
####Authored by Vincent Tshabalala - vincent.b.tshabalala@gmail.com
This app consumer application is an  automated  model/application  that  will  perform  several  checks throughout the event life cycle of a use case/project. These checks are to ensure the efficiency of the consumer application regarding consuming the event, enriching the event, performing decisions and lastly publishing the event. 
This app is done as an assessment for a Technical Assessment at FNB. Any use outside this scope is prohibited.

###Minimum Requirements
```
   Java 1.8
   Maven 3.6.3
```
##Running the application
#####Running the application tests
```
   mvn clean test
```
#####Running the application 
The application will build and run on port 9005 when the below command is run:
```
   ./mvnw spring-boot:run
```
The endpoint can then be accessed at http://localhost:9005/enrich

For any queries, please contact me at
```
   0783029761
   vincent.b.tshabalala@gmail.com 
```

