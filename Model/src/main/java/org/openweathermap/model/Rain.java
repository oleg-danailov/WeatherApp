
package org.openweathermap.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({
//    "3h"
//})
public class Rain {


//    Rain volume for last 3 hours, mm
    @JsonProperty("3h")
    private Double volume;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    @JsonProperty("3h")
    public Double getVolume() {
        return volume;
    }
    @JsonProperty("3h")
    public void setVolume(Double _3h) {
        this.volume = _3h;
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
