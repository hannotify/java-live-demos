# LAB 11: Secure Endpoints

1. Create a UserResource mapped to `/user` with a `register` endpoint.
   * This endpoint should create a new User in the database.
   * The `User` entity should contain:
     * `UUID id`
     * `String username`
     * `String password`
     * `Set<String> roles`
2. Create a user with an 'admin' role using the endpoint.
3. Restrict access to the `register` endpoint with `@RolesAllowed("admin")`.
4. Create a `login` endpoint which should be accessible by all.
   * It should check the validity of the username/password combination.
   * It should generate a JWT.
   * It should return a UserDto (clear the password!) with the token reference.
5. Now also restrict the access to the ContactResource:
   * `GET` should be accessible to the 'reader' or 'admin' role.
   * `PUT` should be accessible to the 'admin' role.
   * `POST` should be accessible to the 'admin' role.
   * `DELETE` should be accessible to the 'admin' role.
6. Use REST Assured to test the accessibility of these 4 endpoints. 
   * Create a test 'admin' and a test 'reader' user.
   * Set the `Authorization` header accordingly.
   * Assert the status codes.
   * See https://www.j-labs.pl/en/tech-blog/json-web-token-handling-with-rest-assured/ for a few tips.
