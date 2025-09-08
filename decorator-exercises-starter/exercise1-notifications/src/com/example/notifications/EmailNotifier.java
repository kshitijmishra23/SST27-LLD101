package com.example.notifications;

/**
 * Existing notifier — sends notifications via Email.
 * You should not modify this class.
 */
public class EmailNotifier implements Notifier {
    private final String email;

    public EmailNotifier(String email) {
        this.email = email;
    }

    @Override
    public void notify(String text) {
        // Simulate sending an email
        System.out.println("[EMAIL -> " + email + "]: " + text);
    }
}
