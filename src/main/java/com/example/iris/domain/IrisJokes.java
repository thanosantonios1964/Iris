package com.example.iris.domain;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class IrisJokes {

    private Boolean error;
    private Integer amount;
    private List<Joke> jokes;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<Joke> getJokes() {
        return jokes;
    }

    public void setJokes(List<Joke> jokes) {
        this.jokes = jokes;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

