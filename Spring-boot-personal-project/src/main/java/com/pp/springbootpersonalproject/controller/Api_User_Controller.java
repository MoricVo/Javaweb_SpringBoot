package com.pp.springbootpersonalproject.controller;

import com.pp.springbootpersonalproject.model.Greeting_Model;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/v1")
public class Api_User_Controller {

    private static final String greetingTemplate="Hello,%s %s";
    private final AtomicInteger counter=new AtomicInteger();
    @GetMapping("/greeting")
    public Greeting_Model greeting(@RequestParam(value = "gender",defaultValue = "0")boolean gender
    ,@RequestParam(value="customerName",defaultValue = "customer")String customerName)
    {
        return Greeting_Model.builder()
                .id(counter.incrementAndGet())
                .content(String.format(greetingTemplate,gender ?"Mr.":"Ms.",customerName))
                .build();
    }
}
