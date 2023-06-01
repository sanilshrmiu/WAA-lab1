package waa.lab1.mapper;

import org.mapstruct.Mapper;
import waa.lab1.domain.Users;
import waa.lab1.dto.UsersDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    Users toEntity(UsersDTO usersDTO);

    UsersDTO toDto(Users users);

    List<Users> toEntityList(List<UsersDTO> usersDTOS);

    List<UsersDTO> toDtoList(List<Users> users);

}
