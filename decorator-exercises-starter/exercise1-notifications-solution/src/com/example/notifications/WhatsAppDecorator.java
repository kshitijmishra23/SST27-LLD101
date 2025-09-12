package com.example.notifications;

/** ConcreteDecorator: adds WhatsApp sending before delegating. */
public class WhatsAppDecorator extends NotifierDecorator {
    private final String handle;
    public WhatsAppDecorator(Notifier inner, String handle) { super(inner); this.handle = handle; }
    @Override public void notify(String text) {
        System.out.println("[WA    -> " + handle + "]: " + text);
        super.notify(text);
    }
}
