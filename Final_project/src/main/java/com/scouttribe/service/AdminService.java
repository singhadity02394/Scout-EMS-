package com.scouttribe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scouttribe.entity.Admin;
import com.scouttribe.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public boolean authenticate(String username, String password) {
        Admin user = adminRepository.findByUsernameAndPassword(username, password);
        return user != null;
    }
}