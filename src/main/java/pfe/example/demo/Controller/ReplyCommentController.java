package pfe.example.demo.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pfe.example.demo.Entites.ReplyComment;
import pfe.example.demo.Service.ReplyCommentService;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/ReplyComment")
public class ReplyCommentController {
@Autowired
    ReplyCommentService replyCommentService;

    @DeleteMapping("/deleteReplyComment/{idReplyComment}")
    public void deleteReplyComment(@PathVariable("idReplyComment") Long idReplyComment){ replyCommentService.deleteReplyComment(idReplyComment); }
    @PostMapping("/addReplyComment")
    public ReplyComment addReplyComment(@RequestBody @Valid ReplyComment p1){ return replyCommentService.addReplyComment(p1); }
    @GetMapping("/ListReplyComment")
    public List<ReplyComment> getAllReplyComment(){ return replyCommentService.getAllReplyComment();}

}
