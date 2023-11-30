# LAB 9: Connecting to a frontend

Now we'll create a new REST API that we'll connect to the Angular frontend we created during the ANGULAR course.

1. Create a new package `contacts` to separate it from the bands&concerts domain.
1. Create both a `Contact` JPA entity and a DTO class that holds the following fields:
   * int id;
   * String firstName;
   * String email;
   * String color;
1. Create a `ContactResource` class and connect it to the `/contacts` URL.
2. Implement REST operations for `GET`, `POST`, `PUT` and `DELETE`. Make sure these operations drill down to the database.
3. Open up your Angular app, change the url of the API calls so that it'll connect to the Open Liberty app instead.

Now you probably end up with CORS-related errors in the browser console.

6. Open up `server.xml` and add the following configuration:

```xml
 <cors domain="/replace-me"
       allowedOrigins="http://localhost:4200"
       allowedMethods="GET, DELETE, POST, PUT"
       allowedHeaders="accept"
       allowCredentials="true"
       maxAge="3600" />
```
...where `replace-me` should be replaced by the URL you've chosen for your Contact REST endpoint.
Keep in mind that if your front end runs on a different port or URL, you should change the value for `allowedOrigins` accordingly.

7. Test if everything works.

Congratulations, you have successfully connected your home-made API to a frontend application!
