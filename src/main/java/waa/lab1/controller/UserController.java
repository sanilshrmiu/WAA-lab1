package waa.lab1.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waa.lab1.dto.UsersDTO;
import waa.lab1.service.UsersService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UsersService usersService;

    @PostMapping
    void save(@RequestBody UsersDTO usersDTO){
        usersService.save(usersDTO);
    }

    @GetMapping
    List<UsersDTO> findAll(){
        return usersService.findAll();
    }

    @GetMapping("/{id}")
    UsersDTO findById(@PathVariable("id")Long id){
        return usersService.findById(id);
    }

    @PutMapping("/{id}")
    void update(@PathVariable("id")Long id, @RequestBody UsersDTO usersDTO){
        usersService.update(usersDTO,id);
    }

    @GetMapping("/multiple-posts")
    List<UsersDTO> findByAuthorsMoreThan(){
        return usersService.findByPostsGreaterThanOne();
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable("id")Long id){
        usersService.deleteById(id);
    }

}
