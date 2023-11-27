package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.example.demo.Dao.CommentRepository;
import pfe.example.demo.Dao.ProjectRepository;
import pfe.example.demo.Entites.Comment;
import pfe.example.demo.Entites.Project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public List<Comment> getAllComment() { return commentRepository.findAll(); }

    public List<Comment> getAllCommentByProject(Long idProject) {
        Optional<Project> project=projectRepository.findById(idProject);
        if(project.isPresent()){
        return commentRepository.findByProject(project.get());
        }else{
            return new ArrayList<>();
        }
        }


    public Comment addComment(Comment c1) {return commentRepository.save(c1); }

    public Comment deleteComment(Long id){
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isPresent()){
            return comment.get();
            //commentRepository
        }else {
            return null;
        }
    }
    }
