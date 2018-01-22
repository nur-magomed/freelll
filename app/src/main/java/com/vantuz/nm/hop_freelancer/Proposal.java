package com.vantuz.nm.hop_freelancer;

import com.google.gson.annotations.SerializedName;

/**
 * Created by NM on 21.01.2018.
 */

public class Proposal {

    @SerializedName("client_order_id")
    private String  clientOrderId;
    @SerializedName("freelancer_id")
    private String  freelancerId;
    private String  amount;
    private String  description;
    @SerializedName("created_datetime")
    private String  created;
    @SerializedName("updated_datetime")
    private String  updated;

    public Proposal() {
    }

    public Proposal(String clientOrderId, String freelancerId, String amount, String description, String created, String updated) {
        this.clientOrderId = clientOrderId;
        this.freelancerId = freelancerId;
        this.amount = amount;
        this.description = description;
        this.created = created;
        this.updated = updated;
    }

    public Proposal(String clientOrderId, String freelancerId, String amount, String description) {
        this.clientOrderId = clientOrderId;
        this.freelancerId = freelancerId;
        this.amount = amount;
        this.description = description;
    }

    public String getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
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
}
