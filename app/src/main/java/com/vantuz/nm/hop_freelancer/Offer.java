package com.vantuz.nm.hop_freelancer;

import com.google.gson.annotations.SerializedName;

import java.sql.Date;

/**
 * Created by NM on 05.12.2017.
 */

public class Offer {
    @SerializedName("order_id")
    private String  offer_id;
    private String  client_id;
    private String  title;
    private Date    deadline;
    @SerializedName("amount")
    private Integer budget;
    private String address;
    @SerializedName("created_datetime")
    private String  created_date;
    @SerializedName("status_id")
    private String  status;
    private String  path;
    private String  username;
    @SerializedName("first_name")
    private String  firstName;
    @SerializedName("last_name")
    private String  lastName;


    public Offer() {
    }

    public Offer(String offer_id, String title, Integer budget, String created_date, String status) {
        this.offer_id = offer_id;
        this.title = title;
        this.budget = budget;
        this.created_date = created_date;
        this.status = status;
    }

    public Offer(String offer_id, String address, String client_id, String title, Date deadline, Integer budget,  String created_date, String status) {
        this.offer_id = offer_id;
        this.title = title;
        this.address = address;
        this.client_id = client_id;
        this.deadline = deadline;
        this.budget = budget;
        this.created_date = created_date;
        this.status = status;
    }

    public Offer(String offer_id, String title, String address, String created_date, Integer budget, String status, String client_id, String path, String username, String firstName, String lastName) {
        this.offer_id = offer_id;
        this.title = title;
        this.address = address;
        this.created_date = created_date;
        this.client_id = client_id;
        this.budget = budget;
        this.status = status;
        this.path = path;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(String offer_id) {
        this.offer_id = offer_id;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }
}
