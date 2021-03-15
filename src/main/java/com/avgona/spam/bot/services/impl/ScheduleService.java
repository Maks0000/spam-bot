package com.avgona.spam.bot.services.impl;

import com.avgona.spam.bot.entities.Spam;
import com.avgona.spam.bot.services.SpamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleService {

    private final SpamService spamService;
    private final JavaMailServiceImpl javaMailService;

    @Autowired
    public ScheduleService(SpamService spamService, JavaMailServiceImpl javaMailService) {
        this.spamService = spamService;
        this.javaMailService = javaMailService;
    }

    @Scheduled(fixedRate = 1000)
    public void checkTimeToSend() throws MessagingException {
        List<Spam> spams = spamService.getSpam();

        for (Spam spam : spams) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            String time = simpleDateFormat.format(new Date());

            if(spam.getTime().equals(time)){
                javaMailService.sendMail(spam.getEmail(),
                                "New Message from WSB!",
                                        spam.getText());
            }
        }
    }
}
