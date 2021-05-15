package com.vertx.examples.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReviewPojo {
    private Integer id;
    @JsonProperty("customer_id")
    private Integer customerId;
    private String review;

    public ReviewPojo(){

    }

    public ReviewPojo(Integer id, Integer customerId, String review) {
        this.id = id;
        this.customerId = customerId;
        this.review = review;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
