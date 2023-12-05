package com.infosupport.topic.movies;

import com.infosupport.topic.AwardMessage;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

@MessageDriven(name = "awardsTopicMovieMdb")
public class MovieWinsAnAwardMdb implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("[MovieWinsAnAwardMdb] -- AwardMessage received -- ");

        try {
            var awardMessage = message.getBody(AwardMessage.class);
            System.out.println("The movie '" + awardMessage.movie().name() + "' has won an award!");
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
