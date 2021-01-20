package com.deviceAtlas.TechnicalTest.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity("User")

public class User {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String city;
    @Relationship(type="FRIEND", direction = Relationship.UNDIRECTED)
    public List<User> friends;
    public User(){

    }
    public User(String name, String city)
    {
        this.name=name;
        this.city=city;

    }

    public void friendOf(User user)
    {
        if(friends==null)
        {
            friends = new ArrayList<>();
        }
        friends.add(user);
    }

    public String getName(){
        return name;
    }
    public String getCity(){
        return city;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setCity(String city){
        this.city = city;
    }

    public String toString(){
        return this.name+" "+this.city;
    }

}
