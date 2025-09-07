import com.example.profiles.*;

public class TryIt {
    public static void main(String[] args) {
        UserProfile p = new UserProfile.Builder()
                .id("u1")
                .email("a@b.com")
                .displayName("Alice")
                .marketingOptIn(true)
                .build();
        System.out.println(p.getId() + " " + p.getEmail() + " " + p.getDisplayName());
        System.out.println("No setters available; object is immutable.");
    }
}
