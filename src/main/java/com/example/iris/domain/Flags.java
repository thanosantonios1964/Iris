package com.example.iris.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Flags {

    private Boolean nsfw;
    private Boolean religious;
    private Boolean political;
    private Boolean racist;
    private Boolean sexist;
    private Boolean explicit;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Flags(Boolean racist, Boolean sexist) {
        this.racist = racist;
        this.sexist = sexist;
    }

    public Boolean getNsfw() {
        return nsfw;
    }

    public void setNsfw(Boolean nsfw) {
        this.nsfw = nsfw;
    }

    public Boolean getReligious() {
        return religious;
    }

    public void setReligious(Boolean religious) {
        this.religious = religious;
    }

    public Boolean getPolitical() {
        return political;
    }

    public void setPolitical(Boolean political) {
        this.political = political;
    }

    public Boolean getRacist() {
        return racist;
    }

    public void setRacist(Boolean racist) {
        this.racist = racist;
    }

    public Boolean getSexist() {
        return sexist;
    }

    public void setSexist(Boolean sexist) {
        this.sexist = sexist;
    }

    public Boolean getExplicit() {
        return explicit;
    }

    public void setExplicit(Boolean explicit) {
        this.explicit = explicit;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
