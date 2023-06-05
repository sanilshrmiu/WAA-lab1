package waa.lab1.util;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import waa.lab1.domain.Users;
import waa.lab1.repo.UsersRepository;

@Component
@AllArgsConstructor
public class StaticContext {

    private final UsersRepository usersRepository;

    public Users getCurrentUser(){
        var user = usersRepository.findById(1L);
        if (user.isPresent()){
            return user.get();
        }
        return new Users(1L);
    }

}
