package com.technical.test.smartpayment.room.dto

import com.technical.test.smartpayment.model.UserData
import com.technical.test.smartpayment.room.entity.UserEntityDB

class UserDTOMapper {
    fun fromUserDTOToUserDomain(userDTO: UserEntityDB): UserData {
        return UserData(
            userDTO.id!!,
            userDTO.name,
            userDTO.surnamePaternal,
            userDTO.surnameMaternal,
            userDTO.birthdate,
            userDTO.country,
        )
    }

}