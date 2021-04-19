package com.crud.tasks.trello.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class TrelloConfig {


    private String trelloApiEndpoint = "https://api.trello.com/1";

    private String trelloAppKey = "1d90e940525da248188851f6e94c4cfb";

    private String trelloToken = "9d28492efaac693c281760e59c3fa9a1a48ccc58e3987a40fda261a2ef27d945";

    private String trelloUser = "wojciech464";



    /*@Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;
    @Value("${trello.app.key}")
    private String trelloAppKey;
    @Value("${trello.app.token}")
    private String trelloToken;
    @Value("${trello.app.user}")
    private String trelloUser;*/
}