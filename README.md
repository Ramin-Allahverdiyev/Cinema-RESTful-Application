# Cinema-RESTful-Application
-by Ramin Allahverdiyev
## Requirements

- Java 11 or later
- Gradle
- Spring Boot 3.1.5

## NOTE
-After cloneing this app to your computer , by default flyway creates test data for you.

## Basic Flow
1. Start by creating a category
2. Create Seat Type like STANDARD, VIP and exc.
3. Create movie and select category
4. Create a session via selecting movieId and show time (format: "HH:mm dd.MM.yyyy")
5. Creating a hall : define hall name and sessions
6. Creating seats : define price , seat type Id and Hall Id ( only 30 seats can define for each hall) 
7. Create roles for users
8. Createing user: define name,surname, father name, username,role Id and password
9. Now u can create ticket for any film: selecting session Id , hall Id, seat Id, user Id
