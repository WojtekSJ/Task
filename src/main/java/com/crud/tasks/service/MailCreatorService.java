package com.crud.tasks.service;

import com.crud.tasks.trello.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class MailCreatorService {

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;
    @Autowired
    private AdminConfig adminConfig;

    public String buildTrelloCardEmail(String message) {
        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "https://wojteksj.github.io/");
        context.setVariable("button", "Visit website");
        //context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("goodbyeMessage", adminConfig.getGoodbyeMessage() + " " + LocalDateTime.now());
        //context.setVariable("companyDetails", adminConfig.getCompanyDetails());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", true);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }
    public String buildTrelloSchedukledEmail(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "https://wojteksj.github.io/");
        context.setVariable("button", "Visit website");
        //context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("goodbyeMessage", "Daily summary of tasks. Send at 10:00 -> " + LocalDateTime.now().toLocalDate());
        //context.setVariable("companyDetails", adminConfig.getCompanyDetails());
        context.setVariable("show_button", true);
        context.setVariable("is_friend", false);
        context.setVariable("admin_config", adminConfig);
        return templateEngine.process("mail/created-trello-scheduled-mail", context);
    }
}