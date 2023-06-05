package waa.lab1.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waa.lab1.dto.CommentDTO;
import waa.lab1.dto.PostDTO;
import waa.lab1.dto.UsersDTO;
import waa.lab1.service.CommentService;
import waa.lab1.service.PostService;
import waa.lab1.service.UsersService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UsersService usersService;
    private final PostService postService;
    private final CommentService commentService;

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

    @GetMapping("/posts")
    List<UsersDTO> findByPosts(@RequestParam(name = "posts", required = false)Integer posts){
        return usersService.findByPostsGreaterThanN(posts);
    }

    @GetMapping("/posts/{id}")
    PostDTO findByPostId(@PathVariable("id")Long postId){
        return postService.getById(postId);
    }

    @GetMapping("/posts/{id}/comments")
    List<CommentDTO> comments(@PathVariable("id")Long postId){
        return commentService.findByPost(postId);
    }

    @GetMapping("/posts/{id}/comments/{commentId}")
    CommentDTO commentsById(@PathVariable("id")Long postId,
                                  @PathVariable("commentId") Long commentId){
        return commentService.findByPostAndCommentId(postId,commentId);
    }

}
