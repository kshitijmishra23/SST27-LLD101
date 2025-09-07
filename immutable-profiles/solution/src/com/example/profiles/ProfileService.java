package com.example.profiles;

public class ProfileService {
    public UserProfile createMinimal(String id, String email) {
        return new UserProfile.Builder()
                .id(id)
                .email(email)
                .build();
    }

    public UserProfile withDisplayName(UserProfile existing, String displayName) {
        return new UserProfile.Builder()
                .id(existing.getId())
                .email(existing.getEmail())
                .phone(existing.getPhone())
                .displayName(displayName)
                .address(existing.getAddress())
                .marketingOptIn(existing.isMarketingOptIn())
                .twitter(existing.getTwitter())
                .github(existing.getGithub())
                .build();
    }
}
