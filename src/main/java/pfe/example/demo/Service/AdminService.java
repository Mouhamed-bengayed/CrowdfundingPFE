package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.example.demo.Dao.AdminRepository;
import pfe.example.demo.Entites.Admin;

import java.util.Optional;
@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

}
