# LAB 9: Connecting to a frontend

Now we'll create a new REST API that we'll connect to the Angular frontend we created during the ANGULAR course.

1. Create both a `Contact` JPA entity and DTO class that holds the following fields:
   * int id;
   * String firstName;
   * String email;
   * String color;
1. Create a `ContactResource` class and connect it to the `/contacts` URL.
2. Implement REST operations for `GET`, `POST`, `PUT` and `DELETE`. Make sure these operations drill down to the database.
3. Open up your Angular app, change the url of the API calls so that it'll connect to the Open Liberty app instead and test if everything still works.

Congratulations, you have successfully connected your home-made API to a frontend application!
