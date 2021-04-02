package pfe.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.example.demo.Entites.Comment;

import pfe.example.demo.Service.CommentService;

import javax.validation.Valid;
import java.util.List;
@RequestMapping("/api")
@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @DeleteMapping("deleteComment")
    public void deleteComment(@RequestBody @Valid Long id){
        commentService.deleteComment(id);
    }
    @PostMapping("/addComment")
    public Comment addComment(@RequestBody @Valid Comment p1){
        return commentService.addComment(p1);
    }
    @GetMapping("ListProject")
    public List<Comment> getAllComment(){
        return commentService.getAllComment();
    }



}
