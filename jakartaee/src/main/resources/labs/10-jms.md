# LAB 10: JMS

1. Within the bands&concerts domain, create two new packages:
   * concertmanager
   * concertannouncer
1. Deactivate all existing TimerBeans and Events.
2. Create a REST endpoint or a servlet (your call!) that can announce a new concert.
3. Make sure that the concert announcer sends a message to a queue.
3. Create a message-driven bean in the `concertmanager` package that is able to respond to the announcement of a new concert.
4. Rewrite the concert announcer to use a topic instead of a queue. Make sure the MDB in `concertmanager` uses this topic, too.
5. Create a package `concertcalendarintegration`.
6. Create a message-driven bean in this package that responds to the topic.
7. Test your setup and make sure that both MDB's are responding to a new message in the topic.
