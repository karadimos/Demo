/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;


/**
 *
 * @author Karadimos
 */
@Service
public class DemoService {
    
    private RestTemplate restTemplate= null;
    
    private String AYUDACLOUD_URL = "https://stroeerdemo.ayudapreview.com/Juice/Pi/";   
    private String AYUDACLOUD_URL2 = "https://stroeerdemo.ayudapreview.com/Juice/";   
    String ayudaPVFacenumberId="5f753407-782b-4a3d-aaa0-6ce20119638c";
    String pvfacechangerequestaddress="AssetProperties/JsonAdd";
    
    private MultiValueMap<String, String> multiParams = new LinkedMultiValueMap<>();
    //private MultivaluedMap<String, String> multiParams = new MultivaluedHashMap<>();
    
    //@Autowired
    //private RestService restService;
    
    
    public String hello(){
        boolean b =login(); 
        List<String> lst = getEmergencyFacesIdGUI("c8c20624-5df8-412e-bd88-8556107a92d7");
        return "hello";
    }
    
    public List<String> getEmergencyFacesIdGUI(String emergencyUuid){
        //List<Object[]> faces = new  ArrayList<>();
        List<String> faceIds = new ArrayList<>();
        multiParams.clear();
        try {        
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            //headers.setContentType(MediaType.APPLICATION_JSON);
            FilterModelCollection filterCollection = new FilterModelCollection();
            FilterModel filterModelGUI = new FilterModel();
            filterModelGUI.setColumnName("EmergencyMessageID");
            filterModelGUI.setDataType("guid");
            filterModelGUI.setValue((String) emergencyUuid);
            filterModelGUI.setInclusionType("Or");
            filterModelGUI.setMappingEntityType("EmergencyMessages");
            filterModelGUI.setSearchCriteria("None");
            filterModelGUI.setIsImmutable(false);
            filterCollection.getFilters().add(filterModelGUI);                    
        
            try {
                multiParams.add("filters", JsonHelper.getJsonFromRequestModel(filterCollection));
                multiParams.add("iDisplayLength", String.valueOf(2)); 
                HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(multiParams, headers);
                ResponseEntity<String> response = getRestTemplate2().exchange(AYUDACLOUD_URL.replace("/Pi","/")  + "Faces/JsonGetSummaryEntities", HttpMethod.POST,                         request, String.class);
                ObjectMapper objectMapper = new ObjectMapper();
                Object json = objectMapper.readValue(response.getBody(), Object.class);
                LinkedHashMap h = (LinkedHashMap) json;
                List<LinkedHashMap> aaData = (List<LinkedHashMap>) h.get("aaData");
                for(LinkedHashMap key: aaData){
                    LinkedHashMap face = (LinkedHashMap) key;                    
                    faceIds.add(face.get("FaceID").toString().toUpperCase());
                }
                return faceIds;
            } catch (JsonProcessingException ex) {
                java.util.logging.Logger.getLogger(DemoService.class.getName()).log(Level.SEVERE, null, ex);
                return faceIds;
            }
        } catch (RestClientException ex) {            
                java.util.logging.Logger.getLogger(DemoService.class.getName()).log(Level.SEVERE, null, ex);
                return faceIds;
        }
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
    
    public boolean login(){
        boolean b=false;
        int i =0;
        while(i<3 && b == false){
            b =login2();
            i++;
        }
        return b;
    }

    public boolean login2(){
        try{
            final String url = AYUDACLOUD_URL  + "Session/Login";
            HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
                headers.add("Connection", "keep-alive");
                multiParams.clear();
                multiParams.add("userName", "APIUser2");
                multiParams.add("password", "cS#H@2R#3");

                HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(multiParams, headers);       
                ResponseEntity<String> response = getRestTemplate2().exchange(url, HttpMethod.POST, request, String.class);
                HttpHeaders respHeaders = response.getHeaders();
                String set_cookie = respHeaders.getFirst(HttpHeaders.SET_COOKIE);         
                System.out.println("cookie:" + set_cookie);           
            return set_cookie != null;
        }catch(Exception ex){
            System.out.println("login error: " + ex.getMessage());
            return false;
        }
            
    }
    
    public void logout() {
        try {
            String response = getRestTemplate2().getForObject(AYUDACLOUD_URL  + "Session/Logout", String.class);
            System.out.println("logout: " + response);
        } catch (Exception ex) {
        }
    }
        
    public String setPvFaceNr(String ayudaFaceGuid, String aliasName){
        MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
        SimpleDateFormat AYUDADATEFORMATTERNOHOURS = new SimpleDateFormat("yyyy-MM-dd");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        if (login()) {
            params.add("PropertyID", ayudaPVFacenumberId);
            params.add("EntityPropertyID", UUID.randomUUID().toString());
            params.add("LinkedToID", ayudaFaceGuid);
            params.add("Value", aliasName);
            params.add("StartDate", AYUDADATEFORMATTERNOHOURS.format(new Date()) + "T00:00:00");
            params.add("EndDate", "");
            params.add("IsLive", "True");
            params.add("TimeStamp", "AAAAAAAAAAA=");
            params.add("IsEditable", "True");
            params.add("IsNew", "True");
            params.add("IsExisting", "False");
            params.add("IsModify", "False");
            params.add("AllowRedirectOnCreation", "False");            
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
            try{
                System.out.println((AYUDACLOUD_URL2)  + pvfacechangerequestaddress);
                ResponseEntity<String> response = getRestTemplate2().exchange(AYUDACLOUD_URL2  + pvfacechangerequestaddress, HttpMethod.POST, request, String.class);
                System.out.println(response.getBody());
                if((response.getBody()).contains("\"Success\":false")){
                    return null;
                }else return (response.getBody());
            }catch(RestClientException e){
                return null;
            }finally{
                logout(); 
            }
        }else{
            logout(); 
            return null;
        }                                               
    }
    
    public UUID createBundleAPI(String designName, String advertiserID, String contentTypeId) {
        try{
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            //String bundleUuid = UUID.randomUUID().toString();
            if(!designName.isEmpty()) designName = designName.replaceAll(" ", "_");
            BundleModel bundleModel = new BundleModel();
            bundleModel.setAdvertiserID(advertiserID);
            //bundleModel.setAdvertiserCategoryID(null);
            //bundleModel.setBundleID(bundleUuid);
            bundleModel.setContentTypeID(contentTypeId);        
            bundleModel.setDescription(designName);
            bundleModel.setFilterDesignsByAspectRatio(true);
            bundleModel.setHeightInPixels(0);
            bundleModel.setName(designName);
            //CHECK bundleModel.setPlayToEnd(loggedIn);
            bundleModel.setStretch(1);
            bundleModel.setWidthInPixels(0);
            bundleModel.setTriggeredByBundleID(null);
            HttpEntity<BundleModel> request = new HttpEntity<>(bundleModel,httpHeaders); 
            ResponseEntity<String> bundleID = getRestTemplate2().exchange(AYUDACLOUD_URL  + "Bundle/Create", HttpMethod.POST, request, String.class);
            if (bundleID.getBody()!=null) {
                return UUID.fromString(bundleID.getBody());
            } else {
                return null; 
            }
        }catch(RestClientException ex){
            System.out.println(AYUDACLOUD_URL  + "createBundleAPI: " +  ex.getMessage());
            return null;
        }
    }
    
    public EmergencyMessageModel getEmergency(){
        return getEmergency("a5eb7c96-886c-4fa7-a35b-334eb8832507");        
    }
    
    public String getOptions(String url){
        Set<HttpMethod> optionsForAllow = getRestTemplate2().optionsForAllow(AYUDACLOUD_URL + url);
        //HttpMethod[] supportedMethods = {HttpMethod.GET, HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};
        
        String retStr = url + ":\n";
        for(HttpMethod o: optionsForAllow){
            retStr = retStr.concat(o.name()).concat("\n");
        }
        
        return retStr;
    }
    
    public EmergencyMessageModel createEmergency(){        
        LocalDateTime dat = LocalDateTime.now();
        
        EmergencyMessageModel em = new EmergencyMessageModel();
        
        em.setAppendLoopStartDateTimeUTC(dat);
        em.setAppendLoopEndDateTimeUTC(dat.plusHours(3));        
        em.setBundleID(UUID.fromString("d0b7cb3e-3cf0-49ab-99bc-124b0b066ef2"));
        em.setCode("Mowas_Test_01");
        em.setEmergencyMessageFaces(null);
        em.setEmergencyMessageID(null);
        em.setIsAppendingLoop(true);
        em.setIsOverridingLoop(false);
        em.setName("Mowas_Test_01");        
        em.setOverrideLoopStartDateTimeUTC(dat);
        em.setOverrideLoopEndDateTimeUTC(dat.plusHours(3));
        em.setSaturation(1);
        em.setSpotLength(30);
        HttpEntity<EmergencyMessageModel> request = new HttpEntity<>(em);
        HttpEntity<String> response = getRestTemplate2().exchange(AYUDACLOUD_URL  + "EmergencyMessage/Create", HttpMethod.POST, request, String.class);
        System.out.println(response.getBody());
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonString = mapper.writeValueAsString(em);
            System.out.println(jsonString);
            String jsonString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(em);
            System.out.println(jsonString2);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(DemoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);        
        MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
        //params.add("id", "11af8890-406f-4ef7-bf80-726da935b93d");  
        params.add("Code", em.getCode());
        params.add("Name", em.getName());
        params.add("BundleID", em.getBundleID().toString());
        params.add("SpotLength", String.valueOf(em.getSpotLength()));
        params.add("IsAppendingLoop", String.valueOf(em.getIsAppendingLoop()));
        params.add("IsOverridingLoop", String.valueOf(em.getIsOverridingLoop()));
        params.add("AppendLoopStartDateTimeUTC", em.getAppendLoopStartDateTimeUTC().toString());
        params.add("OverrideLoopStartDateTimeUTC", em.getOverrideLoopStartDateTimeUTC().toString());
        params.add("AppendLoopEndDateTimeUTC", em.getAppendLoopEndDateTimeUTC().toString());
        params.add("OverrideLoopEndDateTimeUTC", em.getOverrideLoopEndDateTimeUTC().toString());
        params.add("Saturation", String.valueOf(em.getSaturation()));
        params.add("EmergencyMessageFaces", null); //em.getEmergencyMessageFaces());
        HttpEntity<MultiValueMap<String, String>> request2 = new HttpEntity<>(params, headers);
        ResponseEntity<String> response2 = getRestTemplate2().exchange(AYUDACLOUD_URL  + "EmergencyMessage/Create", HttpMethod.POST, request2, String.class);
        System.out.println(response2.getBody());
        return getEmergency(response2.getBody());
    }
    
    public EmergencyMessageModel getEmergency(String uuid){
        Map<String, String> params = new HashMap<>();
        //params.put("id", uuid);   
        params.put("id", "eb577824-49ee-4150-ba06-a660e788ca61"); 
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(AYUDACLOUD_URL  + "EmergencyMessage/Get"); //EmergencyMessage/Get");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            builder.queryParam(entry.getKey(), entry.getValue());
        }
        ResponseEntity<EmergencyMessageModel> response = getRestTemplate2().exchange(builder.toUriString(), HttpMethod.GET, null, EmergencyMessageModel.class);
        return response.getBody();
    }
    
    public String uploadFileAPI(String fileName, UUID fileId)  {
        try {
            uploadFileUsingApi(fileId, fileName);            
            moveFileToStorage(fileId, fileName);
            return fileId.toString();
        } catch (Exception ex) {
            System.out.println("error: "  + ex.getMessage());            
            return null;
        }     
    }
    
    public String uploadFileUsingApi(UUID fileId, String fileName) {
        String responseStr="";
        try{             
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
            final File uploadFile = new File("d://".concat(fileName));
            final FileSystemResource fileSystemResource = new FileSystemResource(uploadFile);
            final MultiValueMap<String, Object> fileUploadMap = new LinkedMultiValueMap<>();
            fileUploadMap.set("data", fileSystemResource);
            fileUploadMap.set("id", fileId.toString());
            HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(fileUploadMap, httpHeaders);
            ResponseEntity<String> responseEntity = getRestTemplate2().exchange(AYUDACLOUD_URL + "File/Upload", HttpMethod.POST, httpEntity, String.class);
            if(responseEntity.getStatusCode().equals(HttpStatus.OK)){
                responseStr = responseEntity.getBody();
                if( responseStr.contains("\"Success\":false") || responseStr.equals("false")){
                    System.out.println(AYUDACLOUD_URL  + "File/Upload: " +  responseStr);
                }
                System.out.println(responseStr);
            } else {
                System.out.println(AYUDACLOUD_URL  + "File/Upload: " + responseEntity.getStatusCode()+ " - " + responseEntity.getBody());
            }     
            return responseStr;
        }catch(Exception ex){
            System.out.println(AYUDACLOUD_URL  + "uploadFileUsingApi: " + ex.getMessage());
            return responseStr;
        }
    }
    
    private void moveFileToStorage(UUID fileId, String fileName){
        moveFileToStorageUsingApi(fileId, fileName);
    }
    
    public void moveFileToStorageUsingApi(UUID fileId, String fileName) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        //httpHeaders.add("X-Requested-With", "XMLHttpRequest");
        multiParams.clear();
        multiParams.add("id", fileId.toString());
        multiParams.add("blockCount", "1");
        multiParams.add("name", fileName);
        multiParams.add("fileExtension", "78005D67-8340-4555-960B-084279F91A73"); //HardcodedAyudaFileExtensions.forFileName(fileName).toString());
        try{            
            HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(multiParams, httpHeaders);
            ResponseEntity<String> response = getRestTemplate2().exchange(AYUDACLOUD_URL  + "File/Store", HttpMethod.POST, httpEntity, String.class);    
            String responseStr = response.getBody();
            if (response.getStatusCode().equals(HttpStatus.OK)) {            
                if( responseStr.contains("\"Success\":false") || responseStr.equals("false")){
                    System.out.println("moveFileToStorageUsingApi: " +  responseStr);
                }
                System.out.println(responseStr);
            } else {
                System.out.println("moveFileToStorageUsingApi: " +  responseStr);
            } 
        }catch(RestClientException ex){
            System.out.println("moveFileToStorageUsingApi: " +  ex.getMessage());
        }
    }
    
    //@Bean
    public RestTemplate getRestTemplate2() {
        if(this.restTemplate==null){        
            this.restTemplate = new RestTemplateBuilder()
                .basicAuthentication("APIUser2", "cS#H@2R#3")   
                .interceptors(new StatefulRestTemplateInterceptor())    
                .build();
        }
        return this.restTemplate;
    }
}
