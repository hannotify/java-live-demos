# LAB 4: Singleton Bean

1. Make the necessary changes so that the `DatabaseManagerBean` becomes a Singleton Bean.
2. Annotate the bean with `@Lock(LockType.READ)`, but at the same time make sure all methods that perform writing operations use write locks instead.
3. Make sure that all code locations that currently create new `DatabaseManagerBean`s use Dependency Injection instead (use the `@EJB` annotation).