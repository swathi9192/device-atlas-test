package com.deviceAtlas.TechnicalTest.services;


import com.deviceAtlas.TechnicalTest.model.UserDTO;
import com.deviceAtlas.TechnicalTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserDTO> getAllUsers(){
        List<UserDTO> userList = userRepository.findAllNodes();
        for(UserDTO userDTO:userList){
            userDTO.setFriends(userRepository.findFriendsByUserId(userDTO.getId()));
            userDTO.setSuggestedFriends(userRepository.findSuggestedFriends(userDTO.getId()));
        }
        return userList;
    }

    public List<Object> getFriendsByUserId(Long id)
    {
        return userRepository.findFriendsByUserId(id);
    }

    public List<Object> getSuggestedFriendsByUserId(Long id){
        return userRepository.findSuggestedFriends(id);
    }

    public UserDTO getUserById(Long id)
    {
        UserDTO userDTO = userRepository.findUserById(id);
        userDTO.setFriends(userRepository.findFriendsByUserId(id));
        userDTO.setSuggestedFriends(userRepository.findSuggestedFriends(id));
        return userDTO;
    }



}
