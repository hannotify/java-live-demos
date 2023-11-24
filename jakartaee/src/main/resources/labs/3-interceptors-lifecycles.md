# LAB 3: Interceptors & Lifecycles

1. Write an interceptor `DatabaseDurationLogger` that intercepts all method calls for the `DatabaseManagerBean` class. 
2. Make the interceptor log the duration of each database action.
3. Use the `InvocationContext` parameter to also log the name of the method that was invoked on the bean.
4. Log a message to the console whenever a `DatabaseManagerBean` is constructed or destroyed.

> To make sure this actually happens, you might have to restart OpenLiberty.
