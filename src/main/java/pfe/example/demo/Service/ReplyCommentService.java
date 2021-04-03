package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.example.demo.Dao.ReplyCommentRepository;
import pfe.example.demo.Entites.ReplyComment;

import java.util.List;
import java.util.Optional;

@Service
public class ReplyCommentService {

@Autowired
ReplyCommentRepository replyCommentRepository;

    public List<ReplyComment> getAllReplyComment() { return replyCommentRepository.findAll();}

    public ReplyComment addReplyComment(ReplyComment c1) {return replyCommentRepository.save(c1); }

    public ReplyComment deleteReplyComment(Long id){
        Optional<ReplyComment> replyComment = replyCommentRepository.findById(id);
        if(replyComment.isPresent()){
            return replyComment.get();
        }else {
            return null;
        }
    }
}

