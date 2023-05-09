package com.example.demo;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TextNode;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karadimos
 *
 */
public class JsonDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    
    @Override
    public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        String dateString ="";
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            /*
            dateString="2023-04-08T10:00:00";
            
            return LocalDateTime.parse(dateString, formatter);
            */
            
            ObjectCodec oc = jp.getCodec();
            //System.out.println(oc.readTree(jp).get("DateTime"));
            //TextNode node = (TextNode) oc.readTree(jp);
            //dateString = node.textValue();
            //dateString="2023-04-08T10:00:00";
            TextNode node = (TextNode) oc.readTree(jp).get("DateTime");
            dateString = node.textValue();
            System.out.println(dateString);
            return LocalDateTime.parse(dateString);
            
        }catch(Exception ex){
            System.out.println("error: " + dateString);
            System.out.println("error: " + ex.getMessage());
            return null;
        }
    }
}
