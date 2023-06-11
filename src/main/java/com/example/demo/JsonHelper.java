package com.example.demo;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author Karadimos
 * 12.01.2015
 *
 */
public class JsonHelper {

    /**
     * build a json request from any java object
     * @param o
     * @return
     * @throws JsonProcessingException 
     */
    public static String getJsonFromRequestModel( Object o ) throws JsonProcessingException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.setSerializationInclusion( Include.NON_NULL );
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            mapper.setDateFormat(dateFormat);
            return mapper.writeValueAsString( o );
        } catch (JsonProcessingException ex) {
            throw ex;
        }
    }    
    
    public static String getPrettyJsonFromRequestModel( Object o ) throws JsonProcessingException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.setSerializationInclusion( Include.NON_NULL );
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            mapper.setDateFormat(dateFormat);
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString( o );
        } catch (JsonProcessingException ex) {
            throw ex;
        }
    }    
    
    /**
     * get entity from ayuda json response
     * @param <T>
     * @param input
     * @param targetclass
     * @return
     * @throws IOException 
     */
    public static <T> T getTargetClassFromJsonString( String input, Class<T> targetclass ) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        //mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        mapper.setDateFormat(dateFormat);
        return mapper.readValue(input, targetclass);
    }
    
    /**
     * get a list of entities from an ayuda json response (entitites are embedded in data node of response)
     * @param <T>
     * @param input
     * @param typeKey
     * @param targetType
     * @return
     * @throws IOException 
     */
    public static <T> List<T> getTargetClassListFromJsonString( String input, String typeKey, Class<T> targetType) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        mapper.setDateFormat(dateFormat);
        JsonNode node = mapper.readTree(input);
        if( node.has("Data")) {
            return mapper.readValue(node.get("Data").findValue(typeKey).toString(), mapper.getTypeFactory().constructCollectionType(List.class, targetType));
        } else {
            return mapper.readValue(input, mapper.getTypeFactory().constructCollectionType(List.class, targetType));            
        }
    }
    
    public static <T> List<T> getTargetClassListFromJsonStringGUI( String input, Class<T> targetType) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        mapper.setDateFormat(dateFormat);
        JsonNode node = mapper.readTree(input);
        if( node.has("aaData")) {
            return mapper.readValue(node.get("aaData").toString(), mapper.getTypeFactory().constructCollectionType(List.class, targetType));
        } else {
            return mapper.readValue(input, mapper.getTypeFactory().constructCollectionType(List.class, targetType));            
        }
    }
}
