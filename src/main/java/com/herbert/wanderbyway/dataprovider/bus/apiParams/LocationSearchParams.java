package com.herbert.wanderbyway.dataprovider.bus.apiParams;

import com.herbert.wanderbyway.utils.rest.SearchParams;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class LocationSearchParams implements SearchParams {
    private String name;
    private String id;
    private String postalCode;

    public LocationSearchParams(){}

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public MultiValueMap<String, String> toMap(){
        MultiValueMap<String, String> items = new LinkedMultiValueMap<>();
        if(name != null) items.add("name", name);
        if(id != null) items.add("id", id);
        if(postalCode != null) items.add("postalcode", postalCode);
        return items;
    }
}
