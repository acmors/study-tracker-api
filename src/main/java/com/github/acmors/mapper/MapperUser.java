package com.github.acmors.mapper;

import com.github.acmors.dto.user.ResponseUser;
import com.github.acmors.entities.UserAccount;

public class MapperUser {

    public static ResponseUser toDTO(UserAccount user){
        return new ResponseUser(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt()
        );
    }
}
