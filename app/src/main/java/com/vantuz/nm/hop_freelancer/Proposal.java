package com.vantuz.nm.hop_freelancer;

import com.google.gson.annotations.SerializedName;

/**
 * Created by NM on 21.01.2018.
 */

public class Proposal {

    @SerializedName("offer_id")
    private String  offerId;
    @SerializedName("freelancer_id")
    private String  freelancerId;
    private String  amount;
    private String  description;
    @SerializedName("created_datetime")
    private String  created;
    @SerializedName("updated_datetime")
    private String  updated;

    //Freelancer
    @SerializedName("first_name")
    private String  firstName;
    @SerializedName("last_name")
    private String  lastName;

    public Proposal() {
    }

    public Proposal(String offerId, String freelancerId, String amount, String description, String created, String updated) {
        this.offerId = offerId;
        this.freelancerId = freelancerId;
        this.amount = amount;
        this.description = description;
        this.created = created;
        this.updated = updated;
    }

    public Proposal(String offerId, String freelancerId, String amount, String description) {
        this.offerId = offerId;
        this.freelancerId = freelancerId;
        this.amount = amount;
        this.description = description;
    }

    public Proposal(String offerId, String freelancerId, String amount, String description, String created, String updated, String firstName, String lastName) {
        this.offerId = offerId;
        this.freelancerId = freelancerId;
        this.amount = amount;
        this.description = description;
        this.created = created;
        this.updated = updated;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getFreelancerId() {
        return freelancerId;
    }

    public void setFreelancerId(String freelancerId) {
        this.freelancerId = freelancerId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
