# LAB 1: Basic Jakarta EE Setup

Let's build a web application called "Concert Freak" that enables music fans to keep track of their favourite bands and any concerts they might be interested in.
We'll use servlets, EJBs, JPA, REST resources and OpenLiberty.

1. Start out by downloading a Jakarta EE starter project via [https://openliberty.io/start/](https://openliberty.io/start/ "smartCard-inline") . Use the following settings:
    - Group: `nl.belastingdienst`
    - Artifact: `concert-freak`
    - Build tool: Maven
    - Java SE Version: `17`
    - Jakarta EE Version: `10`
    - MicroProfile Version: `6`
1. Extract the zip archive.
1. Open the resulting directory with IntelliJ IDEA and add the `pom.xml` as Maven project.
1. Run the Maven goal `liberty:dev`. The OpenLiberty server will start up and keep running to automatically deploy any changes you might do.
1. Create a `ListBandsServlet` that’s connected to url `/bands/list`. It should write a simple HTML response that contains a list of band names (can be a static list for now!).
