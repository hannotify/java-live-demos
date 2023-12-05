package com.infosupport.queue;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.Queue;

@Stateless
public class AwardsQueue {
    @Resource(lookup = "jms/awards")
    private Queue awardsQueue;

    @Resource(lookup = "jms/connectionFactory")
    private ConnectionFactory connectionFactory;

    public void send(AwardMessage message) {
        try (var context = connectionFactory.createContext()) {
            context.createProducer().send(awardsQueue, message);
        }
    }
}
