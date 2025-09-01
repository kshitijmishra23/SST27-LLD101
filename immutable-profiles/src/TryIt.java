import com.example.profiles.*;

public class TryIt {
    public static void main(String[] args) {
        ProfileService svc = new ProfileService();
        UserProfile p = svc.createMinimal("u1", "a@b.com");
        System.out.println("Before: " + p.getEmail());
        p.setEmail("evil@example.com"); // demonstrates mutability problem
        System.out.println("After:  " + p.getEmail());
        System.out.println("=> In the solution, this setter disappears and object becomes immutable.");
    }
}
