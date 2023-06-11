package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DemoApplication {
    
    @Autowired
    DemoService demoService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
        
        @EventListener(ApplicationReadyEvent.class)
    public void init(){
        
        try{
            for(int i=0;i<10;i++){
                demoService.login();
                demoService.logout();
        }
            
        }catch (Exception ex){
            //log.error("AupalSync - Error", ex.getMessage());
        }
    } 

}
