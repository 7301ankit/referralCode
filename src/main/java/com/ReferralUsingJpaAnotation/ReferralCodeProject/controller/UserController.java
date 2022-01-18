package com.ReferralUsingJpaAnotation.ReferralCodeProject.controller;


import com.ReferralUsingJpaAnotation.ReferralCodeProject.dto.UserDto;
import com.ReferralUsingJpaAnotation.ReferralCodeProject.entity.RefferedFriends;
import com.ReferralUsingJpaAnotation.ReferralCodeProject.entity.User;
import com.ReferralUsingJpaAnotation.ReferralCodeProject.service.UserService;
import com.ReferralUsingJpaAnotation.ReferralCodeProject.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")

public class UserController {



    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<Object> registerUsers(@RequestBody UserDto userDto) {
        ResponseEntity<Object> user1 = userService.registerUser(userDto);
        return ResponseHandler.response(HttpStatus.CREATED, false, "user register", user1);
    }

    @GetMapping("/user")
    public ResponseEntity<Object> getAll(User user){
        List<User> user1= userService.getAllUser();

        return ResponseHandler.response(HttpStatus.OK,false,"Get all user",user1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getByAll(@PathVariable("id") Long refferedByUserId){
        List<RefferedFriends> refferedFriends= userService.getRefferedfriendsById(refferedByUserId);
      return ResponseHandler.response(HttpStatus.OK,false,"get all reffered friends ",refferedFriends);
    }




}