package com.example.resttemplate;

import com.example.resttemplate.Rest.User;
import com.example.resttemplate.Rest.UserService;
import org.springframework.web.client.RestTemplate;

public class RestTemplateApplication {

    public static void main(String[] args) {
        StringBuilder key = new StringBuilder();
        User user = new User(3L, "James", "Brown", (byte)30);
        RestTemplate restTemplate = new RestTemplate();
        UserService userService= new UserService(restTemplate);
        String sessionId = userService.getCookie();
        key.append(userService.postUser(sessionId, user));
        user.setName("Thomas");
        user.setLastName("Shelby");
        key.append(userService.putUser(sessionId, user));
        key.append(userService.deleteUser(sessionId, user));
        System.out.println("KEY: " + key);
    }

}
