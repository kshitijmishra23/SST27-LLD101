package com.example.notifications;

/** ConcreteDecorator: adds Slack channel notification before delegating. */
public class SlackDecorator extends NotifierDecorator {
    private final String channel;
    public SlackDecorator(Notifier inner, String channel) { super(inner); this.channel = channel; }
    @Override public void notify(String text) {
        System.out.println("[SLACK -> #" + channel + "]: " + text);
        super.notify(text);
    }
}
