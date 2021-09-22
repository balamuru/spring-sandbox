package com.vgb.boot.sandbox.testable.a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.UUID;

@Service
public class UserService {

    private NameService nameService;

    @Autowired
    public UserService(NameService nameService) {
        this.nameService = nameService;
    }

    public String getUserName(String id) {
        return nameService.getName(id);
    }

    public String getRandomUserName() {
        return UUID.randomUUID().toString();
    }

    public String capitalize (String s) {
        return s.toUpperCase(Locale.ROOT);
    }
}