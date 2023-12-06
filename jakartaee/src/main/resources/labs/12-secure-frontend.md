# LAB 12: Secure Frontend

1. Create a login form using Angular.
2. Have it call the `/login` endpoint and store the token that gets returned.
3. Pass the token of the logged in user to each call your frontend performs to the Contacts API.
4. Implement a `/logout` endpoint in Java and call it from Angular.
   * Make sure the token is cleared after `/logout` has been called.

# If time permits

5. Set the `Authorization` header automatically with each request using an Angular interceptor.
    * Create a TypeScript class `JwtInterceptor` that implements the `HttpInterceptor` interface.
    * Set the header when a user is currently logged in and if a token is available.
