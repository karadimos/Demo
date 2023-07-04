
package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "BundleID",
    "Name",
    "Description",
    "AdvertiserID",
    "ContentTypeID",
    "AdvertiserCategoryID",
    "PlayToEnd",
    "Stretch",
    "WidthInPixels",
    "HeightInPixels",
    "TriggeredByBundleID",
    "FilterDesignsByAspectRatio"
})
public class BundleModel {

    @JsonProperty("BundleID")
    private String BundleID;
    @JsonProperty("Name")
    private String Name;
    @JsonProperty("Description")
    private String Description;
    @JsonProperty("AdvertiserID")
    private String AdvertiserID;
    @JsonProperty("ContentTypeID")
    private String ContentTypeID;
    @JsonProperty("AdvertiserCategoryID")
    private String AdvertiserCategoryID;
    @JsonProperty("PlayToEnd")
    private Boolean PlayToEnd;
    @JsonProperty("Stretch")
    private Integer Stretch;
    @JsonProperty("WidthInPixels")
    private Integer WidthInPixels;
    @JsonProperty("HeightInPixels")
    private Integer HeightInPixels;
    @JsonProperty("TriggeredByBundleID")
    private String TriggeredByBundleID;
    @JsonProperty("FilterDesignsByAspectRatio")
    private Boolean FilterDesignsByAspectRatio;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The BundleID
     */
    @JsonProperty("BundleID")
    public String getBundleID() {
        return BundleID;
    }

    /**
     * 
     * @param BundleID
     *     The BundleID
     */
    @JsonProperty("BundleID")
    public void setBundleID(String BundleID) {
        this.BundleID = BundleID;
    }

    /**
     * 
     * @return
     *     The Name
     */
    @JsonProperty("Name")
    public String getName() {
        return Name;
    }

    /**
     * 
     * @param Name
     *     The Name
     */
    @JsonProperty("Name")
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * 
     * @return
     *     The Description
     */
    @JsonProperty("Description")
    public String getDescription() {
        return Description;
    }

    /**
     * 
     * @param Description
     *     The Description
     */
    @JsonProperty("Description")
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * 
     * @return
     *     The AdvertiserID
     */
    @JsonProperty("AdvertiserID")
    public String getAdvertiserID() {
        return AdvertiserID;
    }

    /**
     * 
     * @param AdvertiserID
     *     The AdvertiserID
     */
    @JsonProperty("AdvertiserID")
    public void setAdvertiserID(String AdvertiserID) {
        this.AdvertiserID = AdvertiserID;
    }

    /**
     * 
     * @return
     *     The ContentTypeID
     */
    @JsonProperty("ContentTypeID")
    public String getContentTypeID() {
        return ContentTypeID;
    }

    /**
     * 
     * @param ContentTypeID
     *     The ContentTypeID
     */
    @JsonProperty("ContentTypeID")
    public void setContentTypeID(String ContentTypeID) {
        this.ContentTypeID = ContentTypeID;
    }

    /**
     * 
     * @return
     *     The AdvertiserCategoryID
     */
    @JsonProperty("AdvertiserCategoryID")
    public String getAdvertiserCategoryID() {
        return AdvertiserCategoryID;
    }

    /**
     * 
     * @param AdvertiserCategoryID
     *     The AdvertiserCategoryID
     */
    @JsonProperty("AdvertiserCategoryID")
    public void setAdvertiserCategoryID(String AdvertiserCategoryID) {
        this.AdvertiserCategoryID = AdvertiserCategoryID;
    }

    /**
     * 
     * @return
     *     The PlayToEnd
     */
    @JsonProperty("PlayToEnd")
    public Boolean getPlayToEnd() {
        return PlayToEnd;
    }

    /**
     * 
     * @param PlayToEnd
     *     The PlayToEnd
     */
    @JsonProperty("PlayToEnd")
    public void setPlayToEnd(Boolean PlayToEnd) {
        this.PlayToEnd = PlayToEnd;
    }

    /**
     * 
     * @return
     *     The Stretch
     */
    @JsonProperty("Stretch")
    public Integer getStretch() {
        return Stretch;
    }

    /**
     * 
     * @param Stretch
     *     The Stretch
     */
    @JsonProperty("Stretch")
    public void setStretch(Integer Stretch) {
        this.Stretch = Stretch;
    }

    /**
     * 
     * @return
     *     The WidthInPixels
     */
    @JsonProperty("WidthInPixels")
    public Integer getWidthInPixels() {
        return WidthInPixels;
    }

    /**
     * 
     * @param WidthInPixels
     *     The WidthInPixels
     */
    @JsonProperty("WidthInPixels")
    public void setWidthInPixels(Integer WidthInPixels) {
        this.WidthInPixels = WidthInPixels;
    }

    /**
     * 
     * @return
     *     The HeightInPixels
     */
    @JsonProperty("HeightInPixels")
    public Integer getHeightInPixels() {
        return HeightInPixels;
    }

    /**
     * 
     * @param HeightInPixels
     *     The HeightInPixels
     */
    @JsonProperty("HeightInPixels")
    public void setHeightInPixels(Integer HeightInPixels) {
        this.HeightInPixels = HeightInPixels;
    }

    /**
     * 
     * @return
     *     The TriggeredByBundleID
     */
    @JsonProperty("TriggeredByBundleID")
    public String getTriggeredByBundleID() {
        return TriggeredByBundleID;
    }

    /**
     * 
     * @param TriggeredByBundleID
     *     The TriggeredByBundleID
     */
    @JsonProperty("TriggeredByBundleID")
    public void setTriggeredByBundleID(String TriggeredByBundleID) {
        this.TriggeredByBundleID = TriggeredByBundleID;
    }

    /**
     * 
     * @return
     *     The FilterDesignsByAspectRatio
     */
    @JsonProperty("FilterDesignsByAspectRatio")
    public Boolean getFilterDesignsByAspectRatio() {
        return FilterDesignsByAspectRatio;
    }

    /**
     * 
     * @param FilterDesignsByAspectRatio
     *     The FilterDesignsByAspectRatio
     */
    @JsonProperty("FilterDesignsByAspectRatio")
    public void setFilterDesignsByAspectRatio(Boolean FilterDesignsByAspectRatio) {
        this.FilterDesignsByAspectRatio = FilterDesignsByAspectRatio;
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
