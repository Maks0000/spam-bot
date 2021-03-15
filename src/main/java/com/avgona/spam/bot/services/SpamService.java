package com.avgona.spam.bot.services;

import com.avgona.spam.bot.entities.Spam;

import java.util.List;

public interface SpamService {
    void save(Spam spam);

    List<Spam> getSpam();
}
