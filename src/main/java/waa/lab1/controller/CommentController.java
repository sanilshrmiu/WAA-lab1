package waa.lab1.controller;

import org.springframework.web.bind.annotation.*;
import waa.lab1.dto.CommentDTO;
import waa.lab1.service.CommentService;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    List<CommentDTO> save(@RequestBody CommentDTO commentDTO){
        return null;
    }

    @GetMapping
    CommentDTO getAll(){
        return null;
    }

    @GetMapping("/{id}")
    CommentDTO getById(@PathVariable("id")Long id){
        return null;
    }

    @DeleteMapping("/{id}")
    void  deleteById(@PathVariable("id")Long id){

    }

}
