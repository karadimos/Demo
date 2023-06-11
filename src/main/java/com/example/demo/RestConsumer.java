/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Karadimos
 */
@Service
public class RestConsumer {
    
    private RestTemplate restTemplate= null;
       
    private HttpComponentsClientHttpRequestFactory getClientHttpRequestFactory() 
    {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                          = new HttpComponentsClientHttpRequestFactory();
        
        int connectTimeout = 5000;
        int readTimeout = 5000;
          
        clientHttpRequestFactory.setConnectTimeout(connectTimeout);
        clientHttpRequestFactory.setReadTimeout(readTimeout);
         
        clientHttpRequestFactory.setHttpClient( httpClient());
              
        return clientHttpRequestFactory;
    }

       
       
    @Bean
    public RestTemplate getRestTemplate() {
        if(this.restTemplate==null){        
            //uri = AYUDACLOUD_URL  + "Session/Login";
            
            this.restTemplate = new RestTemplate(getClientHttpRequestFactory());
        }
        return this.restTemplate;
    }
    
    
    private HttpClient httpClient() 
    {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
 
        credentialsProvider.setCredentials(AuthScope.ANY, 
                new UsernamePasswordCredentials("APIUser2", "cS#H@2R#3"));
 
        HttpClient client = HttpClientBuilder
                    .create()
                    .setDefaultCredentialsProvider(credentialsProvider)
                    .build();
        return client;
    }
    
}