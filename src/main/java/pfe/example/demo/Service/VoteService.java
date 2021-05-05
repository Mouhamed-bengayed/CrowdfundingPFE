package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.example.demo.Dao.ProjectRepository;
import pfe.example.demo.Dao.VoterRepository;
import pfe.example.demo.Entites.Comment;
import pfe.example.demo.Entites.Project;
import pfe.example.demo.Entites.Vote;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VoteService {
@Autowired
    VoterRepository voterRepository;
@Autowired
    ProjectRepository projectRepository;
//    public List<Vote> getAllVote(Long idProject){
//        return   voterRepository.findAllByProject(idProject) ;
//    }

    public List<Vote> getAllVote(Long idProject) {
        Optional<Project> project=projectRepository.findById(idProject);
        if(project.isPresent()){
            return voterRepository.findByProject(project.get());
        }else{
            return new ArrayList<>();
        }
    }


}
