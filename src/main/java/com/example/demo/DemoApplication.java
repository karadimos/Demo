package com.example.demo;

import java.util.UUID;
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
    /*    
    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        
        try{
            for(int x=0;x<10;x++){
                for(int i=0;i<10;i++){
                    //demoService.login();
                    //System.out.println(demoService.getEmergency().getName());
                    //demoService.uploadFileAPI("test113.html", UUID.randomUUID());
                    //demoService.createBundleAPI("Technischer_Test_1074_31", "4BF53413-EC83-4A6C-8B77-FA1F2A1709FE", "e1e4c872-9cc0-4ade-be9c-b9b92e72dd4e");
                    //demoService.logout();
                }
                Thread.sleep(1000*60*5);
            }
        }catch (Exception ex){
            System.out.println("init - Error" + ex.getMessage());
        }
        
    } 
    */
}
