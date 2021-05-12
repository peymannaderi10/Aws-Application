# Aws-Application

STEPS TO SET UP:
1. Head to the application.yml located in "/src/main/resources/"
2. Change "access-key", "secret-key" and "uri" to your person AWS credentials and end-point.
3. Head to AwsSQSConfig.java located in "/src/main/java/com.peymanapp.springbootawssqsexe/config/"
4. Set your region (line 29)

OPTIONAL{
5. Head to SpringbootAwsSqsExeApplication.java located in "/src/main/java/com.peymanapp.springbootawssqsexe/"  
6. Uncomment the SQS listener in order to load messages to the console, make sure to enter queue name within parameters.
}

7. Run the SpringbootAwsSqsExeApplication.java file
8. Type "http://localhost:8080/" into browser search bar to send JSON format message to queue
9. If optional part was complete the json format message will automatically display in console, if not poll messages in AWS SQS.

Thank you!
