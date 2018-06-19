package com.oocl.ir4.gipp.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @RequestMapping(value = "/sample", method = RequestMethod.GET)
    @CrossOrigin(origins = "*")
    public String getButtonResponse() {
        return "I've been clicked!";
    }
}
