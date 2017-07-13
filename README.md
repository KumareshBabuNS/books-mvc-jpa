# books-mvc-jpa

This is an example Spring Boot application that shows how to use Spring MVC
and Spring Data JPA with Spring Data's Web Support to bind an ID request
parameter to an entity.

Note that at this point, the application works when it is run, but the
`BooksControllerTest.bookDetail()` test method does not pass because Spring
Data Web Support doesn't seem to work well in a `@WebMvcTest`. (See
https://github.com/spring-projects/spring-boot/issues/9028)
