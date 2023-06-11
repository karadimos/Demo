/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Generated;
//import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Karadimos
 */

@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "PrimaryKeyValue",
    "EmergencyMessageID",
    "Code",
    "Name",
    "BundleID",
    "SpotLength",
    "IsAppendingLoop",
    "IsOverridingLoop",
    "AppendLoopStartDateTimeUTC",
    "OverrideLoopStartDateTimeUTC",
    "AppendLoopEndDateTimeUTC",
    "OverrideLoopEndDateTimeUTC",
    "Saturation",
    "EmergencyMessageFaces",
    "ExtensionData"
})

//@XmlRootElement
public class EmergencyMessageModel {
    
    @JsonProperty("SpotLength")
    private int spotLength;
    @JsonProperty("IsAppendingLoop")
    private boolean isAppendingLoop;                 
    @JsonProperty("IsOverridingLoop")
    private boolean isOverridingLoop;    
    
    @JsonProperty("OverrideLoopStartDateTimeUTC") 
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    //@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
    private LocalDateTime  overrideLoopStartDateTimeUTC;  
    
    @JsonProperty("OverrideLoopEndDateTimeUTC")
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    //@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
    private LocalDateTime  overrideLoopEndDateTimeUTC;
    
    @JsonProperty("AppendLoopStartDateTimeUTC")
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)    
    //@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
    private LocalDateTime   appendLoopStartDateTimeUTC;
    
    @JsonProperty("AppendLoopEndDateTimeUTC")
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)  
    //@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
    private LocalDateTime   appendLoopEndDateTimeUTC;
    
    @JsonProperty("Code")
    private String code;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("BundleID")    
    private UUID bundleID;
    @JsonProperty("EmergencyMessageID")
    private UUID emergencyMessageID;
    @JsonProperty("Saturation")
    private float saturation; 
    @JsonProperty("EmergencyMessageFaces")
    private List<UUID> emergencyMessageFaces; 
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    public EmergencyMessageModel(){}
    
    public static EmergencyMessageModel defaultEmergencyMessageHackModelTemplate(){
        EmergencyMessageModel emergencyMessageHackModel = new EmergencyMessageModel();
        /*TODO*/
        return emergencyMessageHackModel;
    }

    public int getSpotLength() {
        return spotLength;
    }

    public void setSpotLength(int spotLength) {
        this.spotLength = spotLength;
    }

    public boolean getIsAppendingLoop() {
        return isAppendingLoop;
    }

    public void setIsAppendingLoop(boolean isAppendingLoop) {
        this.isAppendingLoop = isAppendingLoop;
    }

    public boolean getIsOverridingLoop() {
        return isOverridingLoop;
    }

    public void setIsOverridingLoop(boolean isOverridingLoop) {
        this.isOverridingLoop = isOverridingLoop;
    }
    
    public LocalDateTime getOverrideLoopStartDateTimeUTC() {
        return this.overrideLoopStartDateTimeUTC;
    }

    public void setOverrideLoopStartDateTimeUTC(LocalDateTime overrideLoopStartDateTimeUTC) {
        this.overrideLoopStartDateTimeUTC = overrideLoopStartDateTimeUTC;
    }

    public LocalDateTime getOverrideLoopEndDateTimeUTC() {
        return overrideLoopEndDateTimeUTC;
    }

    public void setOverrideLoopEndDateTimeUTC(LocalDateTime overrideLoopEndDateTimeUTC) {
        this.overrideLoopEndDateTimeUTC = overrideLoopEndDateTimeUTC;
    }

    public LocalDateTime getAppendLoopStartDateTimeUTC() {
        return appendLoopStartDateTimeUTC;
    }

    public void setAppendLoopStartDateTimeUTC(LocalDateTime appendLoopStartDateTimeUTC) {
        this.appendLoopStartDateTimeUTC = appendLoopStartDateTimeUTC;
    }

    public LocalDateTime getAppendLoopEndDateTimeUTC() {
        return appendLoopEndDateTimeUTC;
    }

    public void setAppendLoopEndDateTimeUTC(LocalDateTime appendLoopEndDateTimeUTC) {
        this.appendLoopEndDateTimeUTC = appendLoopEndDateTimeUTC;
    }
    /*
    public boolean getAllowRedirectOnCreation() {
        return allowRedirectOnCreation;
    }

    public void setAllowRedirectOnCreation(boolean allowRedirectOnCreation) {
        this.allowRedirectOnCreation = allowRedirectOnCreation;
    }
    */
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getBundleID() {
        return bundleID;
    }

    public void setBundleID(UUID bundleID) {
        this.bundleID = bundleID;
    }
   
    public UUID getEmergencyMessageID() {
        return emergencyMessageID;
    }

    public void setEmergencyMessageID(UUID emergencyMessageID) {
        this.emergencyMessageID = emergencyMessageID;
    }

    public float getSaturation() {
        return saturation;
    }

    public void setSaturation(float saturation) {
        this.saturation = saturation;
    }
    
    public List<UUID> getEmergencyMessageFaces() {
        if(emergencyMessageFaces==null){
            emergencyMessageFaces = new ArrayList<>();
        }
        return emergencyMessageFaces;
    }

    public void setEmergencyMessageFaces(List<UUID> emergencyMessageFaces) {
        this.emergencyMessageFaces = emergencyMessageFaces;
    }
    
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
               
}
