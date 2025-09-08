package com.example.notifications;

public class WhatsAppDecorator extends NotifierDecorator {
    private final String handle;

    public WhatsAppDecorator(Notifier wrappee, String handle) {
        super(wrappee);
        this.handle = handle;
    }

    @Override
    public void notify(String text) {
        super.notify(text);
        System.out.println("[WhatsApp -> " + handle + "]: " + text);
    }
}

