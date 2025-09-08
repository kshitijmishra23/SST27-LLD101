package com.example.notifications;

public class SlackDecorator extends NotifierDecorator {
    private final String channel;

    public SlackDecorator(Notifier wrappee, String channel) {
        super(wrappee);
        this.channel = channel;
    }

    @Override
    public void notify(String text) {
        super.notify(text);
        System.out.println("[Slack #" + channel + "]: " + text);
    }
}
