package com.careerdevs.goApi.Controllers;

import com.careerdevs.goApi.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private Environment env;

    @GetMapping("/all")
    public ResponseEntity getAll(RestTemplate restTemplate) {
        try{

            ArrayList<UserModel> allUsers = new ArrayList<>();
            String url = "https://gorest.co.in/public/v2/users";

            ResponseEntity<UserModel[]> response = restTemplate.getForEntity(url, UserModel[].class);

            return response;

        }
        catch(Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
