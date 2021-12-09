package com.kainska.service;

import com.kainska.dao.SecurityDao;
import com.kainska.model.Security;

import java.util.ArrayList;

public class SecurityService {

    public ArrayList<String[]> findAllSecurity() {
        return new SecurityDao().findAll();
    }

    public Security findSecurityById(int id) {
        return new SecurityDao().findById(id);
    }

    public void createSecurity(Security Security) {
        new SecurityDao().create(Security);
    }

    public void updateSecurity(Security security) {
        new SecurityDao().update(security);
    }

    public void deleteSecurity(int id) {
        new SecurityDao().delete(id);
    }
}