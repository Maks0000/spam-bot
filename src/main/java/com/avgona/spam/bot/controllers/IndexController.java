package com.avgona.spam.bot.controllers;

import com.avgona.spam.bot.entities.Spam;
import com.avgona.spam.bot.services.SpamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class IndexController {

    private final SpamService spamService;

    @Autowired
    public IndexController(SpamService spamService) {
        this.spamService = spamService;
    }

    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("spam", new Spam());

        return "Index";
    }

    @PostMapping("/process")
    public String process(@Valid @ModelAttribute("spam") Spam spam, BindingResult bindingResult) throws IOException {

        if(bindingResult.hasErrors())
            return "Index";

        spamService.save(spam);

        return "redirect:/";
    }
}
