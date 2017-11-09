package com.example.schedulerdemo;

import com.example.schedulerdemo.jms.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTask {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTask.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private Producer producer;

    @Scheduled(fixedRate = 2000)
    public void scheduleTaskWithFixedRate() {
        logger.info("Date : {}", dateFormat.format(new Date()) );
        producer.send("Test message");
    }
}
