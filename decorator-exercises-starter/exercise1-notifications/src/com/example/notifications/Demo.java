package com.example.notifications;

public class Demo {
    public static void main(String[] args) {
        Notifier base = new EmailNotifier("user@example.com");

        // a) Email + SMS
        Notifier emailAndSms = new SmsDecorator(base, "+91-99999-11111");
        emailAndSms.notify("Build green ✅");

        System.out.println();

        // b) Email + WhatsApp
        Notifier emailAndWhatsApp = new WhatsAppDecorator(base, "user_wa");
        emailAndWhatsApp.notify("Code review needed 👀");

        System.out.println();

        // c) Email + Slack
        Notifier emailAndSlack = new SlackDecorator(base, "dev-alerts");
        emailAndSlack.notify("New PR opened 🔔");

        System.out.println();

        // d) Email + WhatsApp + Slack
        Notifier full = new SlackDecorator(
                            new WhatsAppDecorator(base, "user_wa"),
                            "deployments");
        full.notify("Deployment completed 🚀");
    }
}
