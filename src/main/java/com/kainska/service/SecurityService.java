package com.kainska.service;

import com.kainska.Repository.PostRepository;
import com.kainska.Repository.SecurityRepository;
import com.kainska.domain.Post;
import com.kainska.domain.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class SecurityService {
    @Autowired
    SecurityRepository securityRepository;

    public List<Security> findAll() throws Exception {
        List<Security> security = new LinkedList<>(securityRepository.findAll());
        if (security.isEmpty()) {
            return null;
        }
        return security;
    }

    public Security findById(Integer id) throws Exception {
        if (securityRepository.findById(id).isPresent()) {
            return securityRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Security entity) throws Exception {
        if (entity != null) {
            securityRepository.save(entity);
        }
    }

    @Transactional
    public void update(Security security) throws Exception {
        securityRepository.findById(security.getId())
                .map(oldEntity -> {
                    oldEntity.setNickname(security.getNickname());
                    oldEntity.setPassword(security.getPassword());
                    oldEntity.setUserId(security.getUserId());
                    return securityRepository.save(oldEntity);
                })
                .orElseGet(() -> securityRepository.save(security));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (securityRepository.findById(id).isPresent()) {
            securityRepository.delete(findById(id));
        }
    }
}
