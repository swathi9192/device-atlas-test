package com.deviceAtlas.TechnicalTest.model;

import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class UserDTO {
    private long id;
    private String name;
    private String city;
    private Object friends;
    private Object suggestedFriends;

    public UserDTO(long id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Object getFriends() {
        return friends;
    }

    public void setFriends(Object friends) {
        this.friends = friends;
    }

    public Object getSuggestedFriends() {
        return suggestedFriends;
    }

    public void setSuggestedFriends(Object suggestedFriends) {
        this.suggestedFriends = suggestedFriends;
    }
}
