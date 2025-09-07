package com.example.profiles;

import java.util.Objects;

public final class Validation {
    private Validation() {}

    public static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static void requireNonBlank(String val, String name) {
        if (isBlank(val)) throw new IllegalArgumentException(name + " must not be blank");
    }

    public static void requireEmail(String email) {
        Objects.requireNonNull(email, "email");
        if (!email.contains("@")) throw new IllegalArgumentException("invalid email");
    }
}
