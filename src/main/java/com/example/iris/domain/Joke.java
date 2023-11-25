package com.example.iris.domain;

import java.util.LinkedHashMap;
import java.util.Map;
 public class Joke {

        private String category;
        private String type;
        private String joke;

     public Joke(Integer id, String joke, Flags flags, Boolean safe ) {
         this.joke = joke;
         this.flags = flags;
         this.id = id;
         this.safe = safe;
     }

     private Flags flags;
        private Integer id;
        private Boolean safe;
        private String lang;
        private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getJoke() {
            return joke;
        }

        public void setJoke(String joke) {
            this.joke = joke;
        }

        public Flags getFlags() {
            return flags;
        }

        public void setFlags(Flags flags) {
            this.flags = flags;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Boolean getSafe() {
            return safe;
        }

        public void setSafe(Boolean safe) {
            this.safe = safe;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
