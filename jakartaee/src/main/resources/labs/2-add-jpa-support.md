# LAB 2: Add JPA Support

1. Add JPA support to your project.
   - Add required Maven dependencies
   - Add a persistence.xml with a `<jta-datasource>` element
   - Configure OpenLiberty to connect to your database url ([see OpenLiberty docs](https://openliberty.io/docs/latest/relational-database-connections-JDBC.html#examples)).
1. Create a `Band` entity that has:
   - an id
   - a band name
   - a band genre ('rock', ‘pop’, ‘indie’)
   - a OneToMany with `Concert`
1. Create a `Concert` entity that has:
   - an id
   - a date
   - a ManyToOne with `Venue`
1. Create a `Venue` entity that has:
   - an id
   - a name
   - a capacity
   - a city
   - a country
1. Create a stateless local session bean `DatabaseManagerBean` that can perform all database operations.
   - Inject an `EntityManager` using the  `@PersistenceContext` annotation
1. Create stateless local session beans for each entity, that supports the following operations:
   - create
   - update
   - delete
   - list

> You are allowed to replace repeating logic by a generic implementation, if you know how to.

1. Create a few tests that assert that these operations are fully functional.