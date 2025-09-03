package com.example.profiles;

/**
 * Mutable and confusing. Multiple constructors + setters.
 */
public final class UserProfile {
    private final String id;
    private final String email;
    private final String phone;
    private final String displayName;
    private final String address;
    private final boolean marketingOptIn;
    private final String twitter;
    private final String github;

    private UserProfile(Builder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.phone = builder.phone;
        this.displayName = builder.displayName;
        this.address = builder.address;
        this.marketingOptIn = builder.marketingOptIn;
        this.twitter = builder.twitter;
        this.github = builder.github;
    }

    public static Builder builder(String id, String email) {
        return new Builder(id, email);
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    // getters
    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDisplayName() { return displayName; }
    public String getAddress() { return address; }
    public boolean isMarketingOptIn() { return marketingOptIn; }
    public String getTwitter() { return twitter; }
    public String getGithub() { return github; }

    public static final class Builder {
        private String id;
        private String email;
        private String phone;
        private String displayName;
        private String address;
        private boolean marketingOptIn;
        private String twitter;
        private String github;

        private Builder(String id, String email) {
            this.id = id;
            this.email = email;
        }

        private Builder(UserProfile profile) {
            this.id = profile.id;
            this.email = profile.email;
            this.phone = profile.phone;
            this.displayName = profile.displayName;
            this.address = profile.address;
            this.marketingOptIn = profile.marketingOptIn;
            this.twitter = profile.twitter;
            this.github = profile.github;
        }

        // allow overriding even required fields when copying
        public Builder email(String email) { this.email = email; return this; }

        public Builder phone(String phone) { this.phone = phone; return this; }
        public Builder displayName(String displayName) { this.displayName = displayName; return this; }
        public Builder address(String address) { this.address = address; return this; }
        public Builder marketingOptIn(boolean marketingOptIn) { this.marketingOptIn = marketingOptIn; return this; }
        public Builder twitter(String twitter) { this.twitter = twitter; return this; }
        public Builder github(String github) { this.github = github; return this; }

        public UserProfile build() {
            Validation.requireNonBlank(id, "id");
            Validation.requireEmail(email);

            if (displayName != null && displayName.length() > 100) {
                displayName = displayName.substring(0, 100);
            }

            return new UserProfile(this);
        }
    }
}
