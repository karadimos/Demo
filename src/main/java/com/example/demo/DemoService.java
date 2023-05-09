/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


/**
 *
 * @author Karadimos
 */
@Service
public class DemoService {
    
    private String AYUDACLOUD_URL = "https://stroeerdemo.ayudapreview.com/Juice/Pi/";   
    
    private RestTemplate restTemplate= null;
    
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    /*
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder templateBuilder) {
        return templateBuilder
                .requestFactory(new BufferingClientHttpRequestFactory(new HttpComponentsClientHttpRequestFactory()))
                .interceptors(new StatefulRestTemplateInterceptor())
                .build();
    }
    */
    @Bean
    public RestTemplate getRestTemplate() {
        if(this.restTemplate==null){        
            //uri = AYUDACLOUD_URL  + "Session/Login";
            
            this.restTemplate = new RestTemplateBuilder()
                //.requestFactory(new HttpComponentsClientHttpRequestFactory())
                //.interceptors(new StatefulRestTemplateInterceptor())
                .basicAuthentication("APIUser2", "cS#H@2R#3")                    
                .build();
        }
        return this.restTemplate;
    }
    /*
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT).build();        
        CloseableHttpClient  httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)         
                .build();   

        RestTemplate restTemplate = restTemplateBuilder
                .requestFactory(
                        () -> {
                            HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
                            requestFactory.setHttpClient(httpClient);
                            return new BufferingClientHttpRequestFactory(requestFactory);
                        })
                .basicAuthentication("APIUser2", "cS#H@2R#3")
                
                .build();
        return restTemplate;
    }
    */
    /*
    HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders() {{
              String auth = username + ":" + password;
              byte[] encodedAuth = Base64.encodeBase64( 
                 auth.getBytes(Charset.forName("US-ASCII")) );
              String authHeader = "Basic " + new String( encodedAuth );
              set( "Authorization", authHeader );
           }};
     }
    */

    
    
    public String hello(){
        String str =login();        
        return str;
    }
        
    /*
    public String login() { 
        Map<String, String> params = new HashMap<>();
        //params.put("id", "11af8890-406f-4ef7-bf80-726da935b93d");    
        //Login(string username, string password)
        
        //params.put("password", "test");
        params.put("password", "cS#H@2R#3");
        params.put("username", "APIUser2");

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(AYUDACLOUD_URL  + "Session/Login"); //EmergencyMessage/Get");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            builder.queryParam(entry.getKey(), entry.getValue());
        }
        //String url = "https://stroeerdemo.ayudapreview.com/Juice/Pi/Session/Login?userName=APIUser2&password=cS%23H@2R%233";
        //String url = AYUDACLOUD_URL  + "Session/Login?username=APIUser2&password=cS#H@2R#3";
        //HttpHeaders headers = new HttpHeaders();
        
        //headers.setBasicAuth("APIUser2", "cS#H@2R#3");

        //HttpEntity<String> response = restTemplate(restTemplateBuilder).exchange(builder.toUriString(), HttpMethod.GET, new HttpEntity(headers), String.class);
        //HttpEntity<String> response = restTemplate(restTemplateBuilder).exchange(url, HttpMethod.POST, new HttpEntity(createHeaders("APIUser2", "cS#H@2R#3")), String.class);
        HttpEntity<Object> response = getRestTemplate().exchange(builder.toUriString(), HttpMethod.POST, null, Object.class);
        System.out.println("login: " + response.getBody());
            //WebTarget validateTarget = client.target(AYUDACLOUD_URL + "Session/Login");
            //Response validateResponse = validateTarget.request(MediaType.APPLICATION_JSON).post(Entity.form(parameters));
        return builder.toUriString() + " - " + response.getBody();    
            
    }
    */

    public String login(){
        final String url = AYUDACLOUD_URL  + "Session/Login";

        //RestTemplate template = new getRestTemplate();
            
        Credentials cred = new Credentials();
        cred.setUserName("APIUser2");
        cred.setPassword("cS#H@2R#3");

        HttpEntity<Credentials> request = new HttpEntity<>(cred);       
        HttpEntity<String> response = getRestTemplate().exchange(url, HttpMethod.POST, request, String.class);
        HttpHeaders headers = response.getHeaders();
        String set_cookie = headers.getFirst(HttpHeaders.SET_COOKIE);
        return set_cookie;
    }
    
    public EmergencyMessageModel getEmergency(){
        Map<String, String> params = new HashMap<>();
        params.put("id", "11af8890-406f-4ef7-bf80-726da935b93d");   
        
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(AYUDACLOUD_URL  + "EmergencyMessage/Get"); //EmergencyMessage/Get");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            builder.queryParam(entry.getKey(), entry.getValue());
        }
        HttpEntity<EmergencyMessageModel> response = getRestTemplate().exchange(builder.toUriString(), HttpMethod.GET, null, EmergencyMessageModel.class);
        return response.getBody();
    }
    
    
}
