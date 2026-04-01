package com.meridian.recon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReconPublisher {

    private static final Logger log = LoggerFactory.getLogger(ReconPublisher.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void publishBreak(String breakJson) {
        log.info("Publishing reconciliation break to RECON.BREAKS");
        jmsTemplate.convertAndSend("RECON.BREAKS", breakJson);
    }

    public void publishMatch(String matchJson) {
        log.info("Publishing reconciliation match to RECON.MATCHED");
        jmsTemplate.convertAndSend("RECON.MATCHED", matchJson);
    }
}
