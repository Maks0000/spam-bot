package com.avgona.spam.bot.services.impl;

import com.avgona.spam.bot.entities.Spam;
import com.avgona.spam.bot.repositories.SpamRepository;
import com.avgona.spam.bot.services.SpamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpamServiceImpl implements SpamService {

    private final SpamRepository spamRepository;

    @Autowired
    public SpamServiceImpl(SpamRepository spamRepository) {
        this.spamRepository = spamRepository;
    }

    @Override
    public void save(Spam spam) {
        spamRepository.save(spam);
    }

    @Override
    public List<Spam> getSpam() {
        return spamRepository.findAll();
    }
}
