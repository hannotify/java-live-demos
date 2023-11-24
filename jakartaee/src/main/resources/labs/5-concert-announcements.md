# LAB 5: Concert Announcements

Our vision for the "Concert Freak" application is that each user will get an announcement email whenever a concert that user is interested in has been planned.
In this Lab we'll implement an MVP version of this requirement.

1. Extend the `Concert` entity with the capability to store the timestamp of the moment the concert was added to the database.
2. Create an `AddConcertServlet` (connected to URL `/concert/add` that outputs an HTML form in the `doGet()`.
3. Also implement the `doPost()`, which should add a new concert to the database.
4. Create a TimerBean that runs daily at 12PM. It should retrieve all concerts that were planned in the past 24 hours.
5. Log a list of planned concerts to System.out.

## If time permits

Now we want to allow this TimerBean to have a dynamic timing interval, where it fetches the concert data since the last time the TimerBean ran.

6. Rewrite this TimerBean in the programmatic way (see slides).
7. Configure it with a different timing interval (like once every hour, or once every week).
8. Make sure it retrieves the newly added concerts according to the new timing interval.