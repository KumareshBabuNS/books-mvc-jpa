# books-mvc-jpa

This is an example Spring Boot application that shows how to use Spring MVC
and Spring Data JPA with Spring Data's Web Support to bind an ID request
parameter to an entity.

Note that at this point, the application works when it is run, but the
`BooksControllerTest.bookDetail()` test method does not pass because Spring
Data Web Support doesn't seem to work well in a `@WebMvcTest`. (See
https://github.com/spring-projects/spring-boot/issues/9028)

To build/run this app, you can either load it into your IDE and run it from there or run it from the command line:

```
$ mvnw spring-boot:run
```

If, however, you choose to run the `package` or `test` goal and not skip
the tests, the `BooksControllerTest.bookDetail()` test method will fail.
In the logs, you'll find the following failure:

```
.w.s.m.s.DefaultHandlerExceptionResolver : Failed to convert request element: org.springframework.web.method.annotation.MethodArgumentConversionNotSupportedException: Failed to convert value of type 'java.lang.String' to required type 'com.example.demo.Book'; nested exception is java.lang.IllegalStateException: Cannot convert value of type 'java.lang.String' to required type 'com.example.demo.Book': no matching editors or conversion strategy found
```

This indicates a failure converting the `String` path variable representing a
book's ID to a `Book` object--which should be supported by Spring Data's Web
Support, but isn't available in the course of this test.
