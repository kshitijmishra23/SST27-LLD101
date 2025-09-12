package com.example.notifications;

/** Helper builder to assemble decorator stacks from simple config. */
public final class NotifierBuilder {
    public static class Config {
        public String email;
        public boolean whatsapp, sms, slack, metrics;
        public String waHandle, phone, slackChannel;
    }
    private NotifierBuilder() {}
    public static Notifier build(Config cfg) {
        Notifier n = new EmailNotifier(cfg.email);
        if (cfg.whatsapp) n = new WhatsAppDecorator(n, cfg.waHandle);
        if (cfg.sms)      n = new SmsDecorator(n, cfg.phone);
        if (cfg.slack)    n = new SlackDecorator(n, cfg.slackChannel);
        if (cfg.metrics)  n = new MetricsDecorator(n);
        return n;
    }
}
