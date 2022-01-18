package com.ReferralUsingJpaAnotation.ReferralCodeProject.converter;


import com.ReferralUsingJpaAnotation.ReferralCodeProject.dto.UserDto;
import com.ReferralUsingJpaAnotation.ReferralCodeProject.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class StudentConverter {

    public UserDto entityToDto(User user){

        ModelMapper mapper=new ModelMapper();
        UserDto userDto= mapper.map(user,UserDto.class);
       return userDto;
    }

    public List<UserDto> entityToDto(List<User> user){
        return user.stream().map( p -> entityToDto(p)).collect(Collectors.toList());
    }

    public User dtoToEntity(UserDto userDto){

        ModelMapper mapper=new ModelMapper();
        User student= mapper.map(userDto,User.class);
        return student;
    }

    public List<User> dtoToEntity(List<UserDto> userDto){
        return userDto.stream().map( s -> dtoToEntity(s)).collect(Collectors.toList());
    }


}
