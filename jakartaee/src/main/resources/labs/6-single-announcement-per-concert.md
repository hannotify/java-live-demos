# LAB 6: CDI & Single Announcement Per Concert

## Dependency Injection

1. Do a global find on the expression " new " in your project.
2. Replace as many of these expressions as you can by a Dependency Injection-based mechanism.

## Events

1. Create a `ConcertAnnounced` class that holds a field to store concert data.
2. Inject this class with `@Inject Event<ConcertAnnounced> concertAnnounced` in a suitable location (make sure to fire this event after a concert has been added to the database).
3. Create a `ConcertAnnouncedListener` that writes a concert announcement to the log whenever a `ConcertAnnounced` event is received.