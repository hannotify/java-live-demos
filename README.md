# JWT

To get JWT working you need to create a `public-key.pem` and `private-key.pem` as follows:

- private key: `openssl genpkey -algorithm RSA -out private-key.pem -pkeyopt rsa_keygen_bits:2048`
- public key: `openssl rsa -pubout -in private-key.pem -out public-key.pem`
- on windows, you can use Git Bash for this

# Generating coverage reports 

* See `jakartaee/pom.xml` for a good example of a Maven configuration that supports generating coverage reports for both unit tests and integration tests.
* Make sure to pass your own *root package* to the line that specifies the `-javaagent` flag.
* Make sure all your integration test class names end in  `*IT.java` (otherwise they will not run).
* Run `mvn verify` to run both unit and integration tests.

> The Maven configuration will automatically start OpenLiberty before running integration tests and automatically stop it after integration tests have been run.

* The Jacoco coverage plugin will write all coverage information to the file `target/jacoco.exec`.
* It uses this file to generate an HTML report.
* After generation, the report is located at `target/site/jacoco/index.html`.