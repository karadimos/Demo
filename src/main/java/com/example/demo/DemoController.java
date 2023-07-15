/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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
    
    @GetMapping("/bundle")
    public UUID createBundle(){
        return demoService.createBundleAPI("Technischer_Test_1074_30", "4BF53413-EC83-4A6C-8B77-FA1F2A1709FE", "e1e4c872-9cc0-4ade-be9c-b9b92e72dd4e");
    }
    
    @GetMapping("/em2bundle")
    public String em2bundle(){
        return demoService.updateEmergencyBundleAPI(UUID.fromString("3297dd3b-92c0-4ba6-9a48-8000a497658d"), UUID.fromString("b257cd3e-7c24-4206-b421-a0cf7e078953"));
    }
    
    
    
    
    
    @GetMapping("/getEM")
    public EmergencyMessageModel getEM(){
        EmergencyMessageModel em = null;
        demoService.login();
        for(int i =0;i<100;i++){
            
            em = demoService.getEmergency(); //.getName();
            System.out.println(em.getAppendLoopStartDateTimeUTC());
            
            System.out.println("i: " + i);
        }
        demoService.logout();
        return em;
    }
    
    @GetMapping("/createEM")
    public EmergencyMessageModel createEM(){
        return demoService.createEmergency();
    }
    
    @GetMapping("/set_pv_face_nr")
    public String setPvFaceNr(){
        return demoService.setPvFaceNr("600102f9-325c-4b88-a89b-cad16fd77990", "GTd1928");
    }
    
    @GetMapping("/all-cookies")
public String readAllCookies(HttpServletRequest request) {

    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        return Arrays.stream(cookies)
                .map(c -> c.getName() + "=" + c.getValue()).collect(Collectors.joining(", "));
    }

    return "No cookies";
}

    
}
    
