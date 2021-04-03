package pfe.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.example.demo.Entites.Comment;

import pfe.example.demo.Service.CommentService;

import javax.validation.Valid;
import java.util.List;
@RequestMapping("/api/comment")
@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @DeleteMapping("delete-comment/{idComment}")
    public void deleteComment(@PathVariable("idComment") Long idComment){
        commentService.deleteComment(idComment);
    }
    @PostMapping("/add-comment")
    public Comment addComment(@RequestBody @Valid Comment p1){
        return commentService.addComment(p1);
    }
    @GetMapping("List-project")
    public List<Comment> getAllComment(){
        return commentService.getAllComment();
    }



}
