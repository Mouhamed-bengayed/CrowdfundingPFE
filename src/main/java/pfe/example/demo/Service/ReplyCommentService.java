package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pfe.example.demo.Dao.ReplyCommentRepository;
import pfe.example.demo.Entites.Comment;
import pfe.example.demo.Entites.ReplyComment;

import java.util.List;

@Service
public class ReplyCommentService {

@Autowired
ReplyCommentRepository replyCommentRepository;

    public List<ReplyComment> getAllReplyComment() { return replyCommentRepository.findAll();}

    public ReplyComment addReplyComment(ReplyComment c1) {return replyCommentRepository.save(c1); }

    public ReplyComment getCommentById(Long id){
        return replyCommentRepository.findById(id).orElseThrow();
    }

    public ResponseEntity<?> deleteReplyComment(Long id){
        ReplyComment replyComment=getCommentById(id);
        replyCommentRepository.delete(replyComment);
        return ResponseEntity.ok().build();
    }
}

