package com.example.pleaserun;


import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    @PostConstruct
    public void init() {
    }

    public String getGreetingTemplate(String language) {
        String result = "Hello %s";
        /*switch (language){
            case "fr":result="Bonjour";break;
            case"de":result=:"Willkommen";break;
        }*/
        return result;
    }
}
