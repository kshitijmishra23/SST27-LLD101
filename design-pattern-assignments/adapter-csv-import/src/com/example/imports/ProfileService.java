package com.example.imports;

import java.util.Objects;

public class ProfileService {
    public void createProfile(String id, String email, String displayName) {
        Objects.requireNonNull(id, "id");
        Objects.requireNonNull(email, "email");
        if (!email.contains("@")) throw new IllegalArgumentException("bad email");
        System.out.println("Created: " + id + " " + email + " " + displayName);
    }
}
