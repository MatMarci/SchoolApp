package com.company.enroller.controllers;

import com.company.enroller.model.Participant;
import com.company.enroller.persistence.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class RestAPITestController {

    //@Autowired
    //ParticipantService participantService;

    @RequestMapping(path = "/hello")
    public @ResponseBody String sayHello() {
        return "Hello Test Rest API";
    }
}
