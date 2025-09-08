package com.example.notifications;

public abstract class NotifierDecorator implements Notifier {
    protected final Notifier wrappee;

    public NotifierDecorator(Notifier wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void notify(String text) {
        // Always forward to the wrapped notifier first
        wrappee.notify(text);
    }
}
