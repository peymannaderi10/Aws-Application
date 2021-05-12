# Aws-Application

STEPS TO SET UP:
1. When downloading code and opening as project please allow time for shared indexes to download before continuing
2. Head to the application.yml located in "/src/main/resources/"
3. Set "static","access-key", "secret-key" and "uri" to your person AWS credentials and end-point. (NOTE next to static you set your AWS SQS region ie. us-east-2)
4. Head to AwsSQSConfig.java located in "/src/main/java/com.peymanapp.springbootawssqsexe/config/"
5. Set your region (line 29)

OPTIONAL:
6. Head to SpringbootAwsSqsExeApplication.java located in "/src/main/java/com.peymanapp.springbootawssqsexe/"  
7. Uncomment the SQS listener in order to load messages to the console, make sure to enter queue name within parameters.

CONTINUE:
8. Run the SpringbootAwsSqsExeApplication.java file
9. Type "localhost:8080" into browser search bar to send JSON format message to queue
10. If optional part was complete the json format message will automatically display in console, if not poll messages in AWS SQS.

Thank you!
