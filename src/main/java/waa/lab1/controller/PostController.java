package waa.lab1.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import waa.lab1.dto.PostDTO;
import waa.lab1.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PostDTO> getAll(){
        return postService.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody PostDTO postDTO){
        postService.save(postDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PostDTO getById(@PathVariable("id")Long id){
        return postService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deletebyId(@PathVariable("id")Long id){
        postService.deleteById(id);
    }

}
