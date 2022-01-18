package com.ReferralUsingJpaAnotation.ReferralCodeProject.service;

import com.ReferralUsingJpaAnotation.ReferralCodeProject.converter.StudentConverter;
import com.ReferralUsingJpaAnotation.ReferralCodeProject.dto.UserDto;
import com.ReferralUsingJpaAnotation.ReferralCodeProject.entity.RefferedFriends;
import com.ReferralUsingJpaAnotation.ReferralCodeProject.entity.User;
import com.ReferralUsingJpaAnotation.ReferralCodeProject.repository.RefferedFriendsRepo;
import com.ReferralUsingJpaAnotation.ReferralCodeProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.SecureRandom;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private RefferedFriendsRepo refferedFriendsRepo;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StudentConverter studentConverter;

     public ResponseEntity<Object> registerUser(UserDto userDto) {
         String refral = createRandomCode();
         User user = new User();
         user = studentConverter.dtoToEntity(userDto);
         user.setReferralCode(refral);

         User users = userRepository.save(user);
        if(Objects.nonNull(userDto.getReferralCode())) {
            RefferedFriends refferedFriends = new RefferedFriends();

            refferedFriends.setUserName(userDto.getFirstName());
            User user1 = userRepository.findByReferralCode(userDto.getReferralCode());
            refferedFriends.setUserId(users.getId());
            refferedFriends.setRefferedByUserId(user1.getId());

            refferedFriends.setUserId(users.getId());
          refferedFriendsRepo.save(refferedFriends);
        }
         return new ResponseEntity<>(users, HttpStatus.CREATED);

    }



    public List<User> getAllUser(){
      return userRepository.findAll();
    }

    public String createRandomCode() {
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new SecureRandom();
        for (int i = 0; i < 10;i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        System.out.println(output);
        return output;

    }

    public List<RefferedFriends> getRefferedfriendsById(Long refferedByUserId){
        List<RefferedFriends> refferedFriends= refferedFriendsRepo
                .findByRefferedByUserId(refferedByUserId);
       return refferedFriends;
    }

}
