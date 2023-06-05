package waa.lab1.service;

import waa.lab1.domain.Users;
import waa.lab1.dto.UsersDTO;

import java.util.List;

public interface UsersService {
    UsersDTO save(UsersDTO usersDTO);

    List<UsersDTO> findAll();

    UsersDTO update(UsersDTO usersDTO, Long id);

    void deleteById(Long id);

    UsersDTO findById(Long id);

    List<UsersDTO> findByPostsGreaterThanOne();

    List<UsersDTO> findByPostsGreaterThanN(Integer n);
}
