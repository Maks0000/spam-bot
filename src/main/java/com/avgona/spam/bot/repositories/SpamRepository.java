package com.avgona.spam.bot.repositories;

import com.avgona.spam.bot.entities.Spam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpamRepository extends JpaRepository<Spam, Long> {

}
