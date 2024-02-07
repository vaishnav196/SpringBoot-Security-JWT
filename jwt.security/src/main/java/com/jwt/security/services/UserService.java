package com.jwt.security.services;

import com.jwt.security.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

//    @Autowired
//    private  UserService userService;

    public UserService() {
        store.add(new user(UUID.randomUUID().toString(),"vaish","1234","vaish@123"));

        store.add(new user(UUID.randomUUID().toString(),"ravi","1234","pret@23"));
        store.add(new user(UUID.randomUUID().toString(),"amit","1234","vahan123"));
        store.add(new user(UUID.randomUUID().toString(),"preet","1234","ravah@123"));
    }

    private List<user> store=new ArrayList<>();

    public List<user> getallUser(){
        return  this.store;
    }


}


