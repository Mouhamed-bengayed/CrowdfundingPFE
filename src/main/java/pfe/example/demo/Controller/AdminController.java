package pfe.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pfe.example.demo.Entites.Admin;
import pfe.example.demo.Service.AdminService;

import java.util.Optional;

@CrossOrigin

@RequestMapping("/api/Admin")
@RestController
public class AdminController {
    @Autowired
    AdminService adminService;
//    @GetMapping("/admin")
//    public Optional<Admin> admin() {
//        return adminService.getAdmin();
//    }
}
