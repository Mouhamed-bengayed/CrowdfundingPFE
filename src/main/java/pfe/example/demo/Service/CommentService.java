package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.example.demo.Dao.CommentRepository;
import pfe.example.demo.Entites.Comment;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public List<Comment> getAllComment() { return commentRepository.findAll(); }

    public Comment addComment(Comment c1) {return commentRepository.save(c1); }


    public Comment deleteComment(Long id){
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isPresent()){
            return comment.get();
        }else {
            return null;
        }
    }
    }
