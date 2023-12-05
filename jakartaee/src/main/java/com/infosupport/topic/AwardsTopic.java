package com.infosupport.topic;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.Topic;

@Stateless
public class AwardsTopic {
    @Resource(lookup = "jms/awardsTopic")
    private Topic awardsTopic;

    @Resource(lookup = "jms/connectionFactory")
    private ConnectionFactory connectionFactory;

    public void send(AwardMessage message) {
        try (var context = connectionFactory.createContext()) {
            context.createProducer().send(awardsTopic, message);
        }
    }
}
