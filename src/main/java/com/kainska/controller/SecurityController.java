package com.kainska.controller;

import com.kainska.domain.Post;
import com.kainska.domain.Security;
import com.kainska.domain.Photo;
import com.kainska.service.PostService;
import com.kainska.service.SecurityService;
import com.kainska.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kainska")
public class SecurityController {
    @Autowired
    SecurityService securityService;

    @GetMapping("/security")
    public List<Security> findAll() throws Exception {
        return securityService.findAll();
    }

    @GetMapping("/security/{id}")
    public Security findById(@PathVariable Integer id) throws Exception {
        return securityService.findById(id);
    }

    @PostMapping("/security")
    public void create(@RequestBody Security entity) throws Exception {
        securityService.create(entity);
    }

    @PutMapping("/security/{id}")
    public void update(@PathVariable Integer id, @RequestBody Security entity) throws Exception {
        entity.setId(id);
        securityService.update(entity);
    }

    @DeleteMapping("/security/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        securityService.delete(id);
    }
}
