# LAB 12: Unit & Integration Tests

1. Create a unit test class that covers the code in `DatabaseManagerBean` as much as possible.
   * Use Mockito to mock all EntityManager operations.
   * (it's also OK to use a different `*Dao` or `*Repository` class)
2. Write a few integration tests using REST Assured. Try to test a few common scenarios that cover multiple endpoints, for example:
   * Register a user with the "admin" role, log in and make sure an admin-specific endpoint is reachable.
   * Add a new contact, edit one of its fields, retrieve it and make sure the field was actually updated.
   * ...come up with a scenario of your own.