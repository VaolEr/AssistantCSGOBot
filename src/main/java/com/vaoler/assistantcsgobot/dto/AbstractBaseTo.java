package com.vaoler.assistantcsgobot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public abstract class AbstractBaseTo {

    @JsonProperty("id")
    private String apiId;

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    @Override
    public String toString() {
        return "apiId='" + apiId + '\'' + " ";
    }
}
