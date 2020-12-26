# BasicAuthentication

** Technologies Used **
1. Spring boot
2. Mysql
3. Maven
4. Bcrypt
5. REST
6. IntelliJ
7. Hibernate

-> This is basic authentication, which is used to signup and signin in an application and then user can make request to application.

-> Here I have made two normal APIs. Signup will take some parameters and then save it to our mysql database.(password will be stored in encrypted form)

-> For password encryption we will use BCrypt.

-> We will use hibernate and mysql to store the information of the user.

-> While logging in we have to verify that the user and password are correct otherwise we throw exception.
