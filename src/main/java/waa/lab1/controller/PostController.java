package waa.lab1.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import waa.lab1.dto.CommentDTO;
import waa.lab1.dto.PostDTO;
import waa.lab1.dto.PostV2DTO;
import waa.lab1.dto.UsersDTO;
import waa.lab1.service.CommentService;
import waa.lab1.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {

    private final PostService postService;
    private final CommentService commentService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PostDTO> getAll(@RequestParam(value = "title",required = false)String title){
        return StringUtils.isEmpty(title) ? postService.getAll() : postService.getAllByTitle(title);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(headers = {"X-API-VERSION=v1"})
    public List<PostV2DTO> getAllV2(){
        return postService.getAllV2();
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

    @PutMapping("/{id}")
    public void updatePost(@PathVariable("id") Long id,@RequestBody PostDTO postDTO){
        postService.updatePost(postDTO,id);
    }

    @PostMapping("/{id}/comment/")
    public void postComment(@PathVariable("id") Long postId, @RequestBody CommentDTO commentDTO){
        commentService.postComment(commentDTO,postId);
    }

    @GetMapping("/users")
    public List<UsersDTO> getUsersByPostTitle(@RequestParam("title") String postTitle){
        return postService.findUserByPostTitle(postTitle);
    }

}
