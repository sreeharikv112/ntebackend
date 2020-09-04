package com.support.ntebackend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Feedback {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("feedback")
    private String feedback;

    public Feedback(){
        super();
    }

    public Feedback(String name,String email,String feedback){
        this.name = name;
        this.email = email;
        this.feedback = feedback;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
