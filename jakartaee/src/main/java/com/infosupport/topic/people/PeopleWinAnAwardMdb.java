package com.infosupport.topic.people;

import com.infosupport.model.Actor;
import com.infosupport.topic.AwardMessage;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

@MessageDriven(name = "awardsTopicPeopleMdb")
public class PeopleWinAnAwardMdb implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("[PeopleWinsAnAwardMdb] -- AwardMessage received -- ");

        try {
            var awardMessage = message.getBody(AwardMessage.class);
            System.out.println("[PeopleWinAnAwardMdb] The following people have won an award because they played in the movie '%s':%n".formatted(awardMessage.movie().name()));

            for (Actor actor : awardMessage.movie().actors()) {
                System.out.println("[PeopleWinsAnAwardMdb] - " + actor);
            }
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
