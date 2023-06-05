package waa.lab1.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import waa.lab1.domain.Users;
import waa.lab1.dto.UsersDTO;
import waa.lab1.mapper.UsersMapper;
import waa.lab1.repo.UsersRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class UsersServiceImpl implements UsersService{

    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;

    @Override
    public UsersDTO save(UsersDTO usersDTO){
        var savedUser = usersRepository.save(usersMapper.toEntity(usersDTO));
        return usersMapper.toDto(savedUser);
    }

    @Override
    public List<UsersDTO> findAll() {
        return usersMapper.toDtoList(usersRepository.findAll());
    }

    @Override
    public UsersDTO update(UsersDTO usersDTO, Long id) {
        var user = usersRepository.findById(id);
        if (user.isPresent()){
            var toUpdateUser = usersMapper.toEntity(usersDTO);
            toUpdateUser.setId(id);
            toUpdateUser.setPosts(user.get().getPosts());
            usersRepository.save(toUpdateUser);
            return usersMapper.toDto(toUpdateUser);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public UsersDTO findById(Long id) {
        return usersMapper.toDto(usersRepository.getById(id));
    }

    @Override
    public List<UsersDTO> findByPostsGreaterThanOne(){
        return usersMapper.toDtoList(usersRepository.findByPostsGreaterThan());
    }

    @Override
    public List<UsersDTO> findByPostsGreaterThanN(Integer n){
        var num = n!=null?n:0;
        return usersMapper.toDtoList(usersRepository.findByPostsGreaterThanN(num));
    }

}
