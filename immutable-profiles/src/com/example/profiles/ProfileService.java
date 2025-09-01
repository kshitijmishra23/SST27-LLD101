package com.example.profiles;

import java.util.Objects;

import com.example.profiles.UserProfile.Builder;

/**
 * Assembles profiles with scattered, inconsistent validation.
 */
public class ProfileService {

    // returns a fully built profile but mutates it afterwards (bug-friendly)
    public UserProfile createMinimal(String id, String email) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("bad id");
        if (email == null || !email.contains("@")) throw new IllegalArgumentException("bad email");

        Builder builder = new Builder();
        UserProfile p = builder.setId(id).setEmail(email).build();
        return p;
    }

    // Remove the entire method as UserProfile is immutable
    
    // public void updateDisplayName(UserProfile p, String displayName) {
    //     Objects.requireNonNull(p, "profile");
    //     if (displayName != null && displayName.length() > 100) {
    //         // silently trim (inconsistent policy)
    //         displayName = displayName.substring(0, 100);
    //     }
    //     p.setDisplayName(displayName); // mutability leak
    // }

    // Possibly return a completely new UserProfile with the updated displayName;
    public UserProfile updateDisplayName(UserProfile p, String displayName) {
        Objects.requireNonNull(p, "profile");
        if (displayName != null && displayName.length() > 100) {
            // silently trim (inconsistent policy)
            displayName = displayName.substring(0, 100);
        }
        // Suggestions: Entirely remove this method as it causes mutability leak.
        // OR Possibly return a completely new UserProfile with the updated displayName;
        Builder builder = new Builder();
        UserProfile newP = builder.setId(p.getId()).setAddress(p.getAddress()).setEmail(p.getEmail())
                                        .setMarketingOptIn(p.isMarketingOptIn()).setPhone(p.getPhone())
                                        .setTwitter(p.getTwitter()).setGithub(p.getGithub())
                                        .setDisplayName(displayName).build();
        return newP;
    }
}