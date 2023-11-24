# LAB 7: REST Band & Concert API

Let's create a REST API to interact with our bands & concerts domain.

1. Create a `RestApplication` class that extends `Application`.
2. Create a `BandResource` class and connect it to the `/bands` URL.
3. Implement a `readAll()` operation.
4. Implement CRUD operations for a single band.
5. Create a `VenueResource` class and connect it to the `/venues` URL.
6. Implement a `readAll()` operation.
7. Implement CRUD operations for a single venue.
8. Create a `ConcertResource` class and connect it to the `/concerts` URL.
9. Implement a `readAll()` operation.

Before starting the remainder of this lab, remember that a concert cannot exist outside the context of a band, and that each concert needs a venue.

10. Implement CRUD operations for a single concert. 
11. Test your API operations with Postman. (`brew install --cask postman`)

## If time permits

12. Test and assert the expected behaviour of your REST endpoints using the [REST Assured](https://github.com/rest-assured/rest-assured) library.