package pfe.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.example.demo.Entites.ReplyComment;

public interface ReplyCommentRepository extends JpaRepository<ReplyComment, Long> {
}
