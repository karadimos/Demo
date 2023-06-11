
package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ColumnName",
    "DataType",
    "Value",
    "InclusionType",
    "MappingEntityType",
    "SearchCriteria",
    "IsImmutable"
})
public class FilterModel {

    @JsonProperty("ColumnName")
    private String columnName;
    @JsonProperty("DataType")
    private String dataType;
    @JsonProperty("Value")
    private String value;
    @JsonProperty("InclusionType")
    private String inclusionType;
    @JsonProperty("MappingEntityType")
    private String mappingEntityType;
    @JsonProperty("SearchCriteria")
    private String searchCriteria;
    @JsonProperty("IsImmutable")
    private Boolean isImmutable;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ColumnName")
    public String getColumnName() {
        return columnName;
    }

    @JsonProperty("ColumnName")
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    @JsonProperty("DataType")
    public String getDataType() {
        return dataType;
    }

    @JsonProperty("DataType")
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @JsonProperty("Value")
    public String getValue() {
        return value;
    }

    @JsonProperty("Value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonProperty("InclusionType")
    public String getInclusionType() {
        return inclusionType;
    }

    @JsonProperty("InclusionType")
    public void setInclusionType(String inclusionType) {
        this.inclusionType = inclusionType;
    }

    @JsonProperty("MappingEntityType")
    public String getMappingEntityType() {
        return mappingEntityType;
    }

    @JsonProperty("MappingEntityType")
    public void setMappingEntityType(String mappingEntityType) {
        this.mappingEntityType = mappingEntityType;
    }

    @JsonProperty("SearchCriteria")
    public String getSearchCriteria() {
        return searchCriteria;
    }

    @JsonProperty("SearchCriteria")
    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @JsonProperty("IsImmutable")
    public Boolean getIsImmutable() {
        return isImmutable;
    }

    @JsonProperty("IsImmutable")
    public void setIsImmutable(Boolean isImmutable) {
        this.isImmutable = isImmutable;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}
