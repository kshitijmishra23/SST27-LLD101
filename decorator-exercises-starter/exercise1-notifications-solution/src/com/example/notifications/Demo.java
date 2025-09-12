package com.example.notifications;

/** Demo for notifications solution. */
public class Demo {
    public static void main(String[] args) {
        Notifier base = new EmailNotifier("user@example.com");
        base.notify("Baseline email only.");

        Notifier clientA = new WhatsAppDecorator(new EmailNotifier("a@example.com"), "user_wa_handle");
        clientA.notify("Build green ✅");

        Notifier clientB = new SmsDecorator(new EmailNotifier("b@example.com"), "+91-99999-11111");
        clientB.notify("Deploy started");

        Notifier clientC = new MetricsDecorator(
                               new SlackDecorator(
                                   new WhatsAppDecorator(new EmailNotifier("c@example.com"), "c_handle"),
                                   "deployments"));
        clientC.notify("Deployment completed 🚀");

        NotifierBuilder.Config cfg = new NotifierBuilder.Config();
        cfg.email = "builder@example.com";
        cfg.whatsapp = true; cfg.waHandle = "builder_wa";
        cfg.sms = true;      cfg.phone = "+91-88888-22222";
        cfg.metrics = true;
        Notifier built = NotifierBuilder.build(cfg);
        built.notify("Builder-composed notification");
    }
}
