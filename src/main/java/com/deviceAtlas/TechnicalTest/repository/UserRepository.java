package com.deviceAtlas.TechnicalTest.repository;

import com.deviceAtlas.TechnicalTest.entity.User;
import com.deviceAtlas.TechnicalTest.model.UserDTO;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;


public interface UserRepository extends Neo4jRepository<User, Long> {
    @Query("MATCH (u:User) \n"+
           "RETURN ID(u) as id,u.name as name,u.city as city")
        List<UserDTO> findAllNodes();

    @Query("MATCH (u:User)-[r]-(v:User) \n"+
            "where ID(u)=$0 \n"+
            "RETURN {name:v.name,city:v.city,id:id(v)}")
        List<Object> findFriendsByUserId(Long id);

    @Query("MATCH (u:User) \n"+
            "WHERE ID(u)=$0 \n"+
            "RETURN ID(u) as id,u.name as name,u.city as city")
        UserDTO findUserById(Long id);

    @Query("MATCH (user:User) \n"+
            "WHERE user.name=$0 \n" +
            "RETURN user")
        User findByName(String name);

    @Query("MATCH (n:User) WHERE ID(n)=$0  \n" +
            "MATCH  (n)-[:FRIEND*2]-(m) \n" +
            "WHERE NOT (n)-[:FRIEND]-(m) \n" +
            "RETURN DISTINCT {id:ID(m),name:m.name,city:m.city}")
        List<Object> findSuggestedFriends(Long id);


}
