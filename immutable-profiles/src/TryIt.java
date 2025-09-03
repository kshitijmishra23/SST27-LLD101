import com.example.profiles.*;

public class TryIt {
    public static void main(String[] args) {
        ProfileService svc = new ProfileService();
        UserProfile p = svc.createMinimal("u1", "a@b.com");
        System.out.println("Email: " + p.getEmail());

        // Attempt to change: there are no setters now. We create a new instance instead.
        UserProfile p2 = p.toBuilder().email("new@example.com").build();
        System.out.println("Original Email (unchanged): " + p.getEmail());
        System.out.println("New Profile Email:          " + p2.getEmail());

        // Service method returns a new instance when updating display name
        UserProfile named = svc.updateDisplayName(p2, "Alice Wonderland");
        System.out.println("Display Name set on new instance: " + named.getDisplayName());
    }
}
