package pfe.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.example.demo.Entites.Comment;

import pfe.example.demo.Entites.Project;
import pfe.example.demo.Service.CommentService;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin
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
    @GetMapping("List-comment")
    public List<Comment> getAllComment(){ return commentService.getAllComment();
    }
    @GetMapping("/get-comment-by-project/{idProject}")
    public List<Comment> getCommentById(@PathVariable("idProject") Long idProject) {
        return  commentService.getAllCommentByProject(idProject);
    }

}
