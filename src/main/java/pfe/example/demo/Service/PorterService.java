package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.example.demo.Dao.ListBlackRepository;
import pfe.example.demo.Dao.PorterRepository;
import pfe.example.demo.Entites.ListBlack;
import pfe.example.demo.Entites.Porter;

import java.util.Collection;

@Service
public class PorterService {
@Autowired
PorterRepository porterRepository;
@Autowired
ListBlackRepository listBlackRepository;

    public void blockedPorter(Long id) {
        Porter porter = (Porter) porterRepository.findAllById(id);
        ListBlack listBlack = new ListBlack();
        listBlack.setPorter((Collection<Porter>) porter);
        listBlackRepository.save(listBlack);
    }

    public void activatePorter(Long id) {
        Porter porter = (Porter) porterRepository.findAllById(id);
        ListBlack listBlack =listBlackRepository.findByPorter(porter);
        this.listBlackRepository.delete(listBlack);

    }

}
