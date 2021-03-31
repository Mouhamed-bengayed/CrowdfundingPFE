package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pfe.example.demo.Dao.CommentRepository;
import pfe.example.demo.Entites.Account;
import pfe.example.demo.Entites.Comment;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public List<Comment> getAllComment() { return commentRepository.findAll(); }

    public Comment addComment(Comment c1) {return commentRepository.save(c1); }

    public Comment getCommentById(Long id){
        return commentRepository.findById(id).orElseThrow();
    }

    public ResponseEntity<?> deleteComment(Long id){
        Comment comment=getCommentById(id);
        commentRepository.delete(comment);
        return ResponseEntity.ok().build();
    }
}