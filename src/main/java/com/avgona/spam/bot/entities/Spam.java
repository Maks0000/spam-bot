package com.avgona.spam.bot.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "spam")
public class Spam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotEmpty(message = "The field is required")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "The field is required")
    @Size(min = 5, max = 200, message = "min 5, max 200 symbols")
    @Column(name = "text")
    private String text;

    @NotEmpty(message = "The field is required")
    @Column(name = "time")
    private String time;
}
