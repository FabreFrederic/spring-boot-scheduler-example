package com.example.schedulerdemo;

import com.example.schedulerdemo.jms.Producer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.JMSException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleJmsTest {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Autowired
    private Producer producer;

    @Test
    public void sendSimpleMessage() throws InterruptedException, JMSException {
        this.producer.send("Test message");
        Thread.sleep(1000L);
        assertThat(outputCapture.toString().contains("Test message")).isTrue();
    }

}