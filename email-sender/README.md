# Sending emails with Jakarta EE

Sending emails with Jakarta EE can be done by using the `jakarta.mail` API.
Open Liberty provides an implementation of this API through the feature `mail-2.1`.
You'll also need JNDI support, so make sure to add both of them to the `server.xml`:

```xml
<feature>mail-2.1</feature>
<feature>jndi-1.0</feature>
```

You'll also need a `jakarta.mail.Session` JNDI resource, so that it can be injected and used in the `MimeMessage` constructor.
(see the `Email` for an example of this and the `<mailSession>` configuration in `server.xml`).

## Running GreenMail as a fake email server on localhost

Now let's run a 'fake' email server to be able to send and receive email.
The [GreenMail](https://greenmail-mail-test.github.io/greenmail/#) library is perfect for this.
Run the following command from the root of the `email-sender` project to start up GreenMail as a local email server:

```bash
docker-compose up -d
```

This command uses the configuration in `docker-compose.yml`.

## Receiving email from GreenMail in an email client

Now we can set up an email client to receive email that's been sent to GreenMail.
[This blog post](https://jensknipper.de/blog/greenmail-mock-mail-server-dev-setup/#greenmail-mail-client-connection) explains it nicely.
It offers tips for working with Mozilla Thunderbird or the Roundcube web client.

To install Thunderbird on a Mac:

```bash
brew install --cask thunderbird
```

To use Roundcube instead, you need to extend the `docker-compose.yml` file with a Roundcube image as described in the blog post linked above.

## Testing your setup

The `EmailSenderBean` in this project is a startup bean that sends a test email when the server starts.
Check your configured email client to see if you've received this email. 
If so, your setup works!

## Testing email behavior

GreenMail also supports assertions on received and sent emails for use in automated testing.
See `EmailSenderServiceTest` for an example of this.
Or read the [GreenMail documentation](https://greenmail-mail-test.github.io/greenmail/#).