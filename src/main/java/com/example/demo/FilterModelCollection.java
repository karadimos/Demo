
package com.example.demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Filters"
})
public class FilterModelCollection {
    
    public FilterModelCollection() {
        this.filters = new ArrayList<>();
    }
    
    public void clear() {
        this.filters.clear();
    }
    
    public boolean isEmpty() {
        return filters.isEmpty();
    }

    @JsonProperty("Filters")
    private ArrayList<FilterModel> filters;

    @JsonProperty("Filters")
    public ArrayList<FilterModel> getFilters() {
        return this.filters;
    }

    @JsonProperty("Filters")
    public void setFilters(ArrayList<FilterModel> filters) {
        this.filters = filters;
    }
}
