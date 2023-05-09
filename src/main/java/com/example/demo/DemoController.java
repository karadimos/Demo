/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Karadimos
 */
@RestController
@RequestMapping("/api")
public class DemoController {
    
    @Autowired
    private DemoService demoService;
    
    @GetMapping("/greetings")
    public String getGreeting(){
        return demoService.hello();
    }
    
    @GetMapping("/getEM")
    public String getEM(){
        return demoService.getEmergency().getName();
    }
    
}
    
