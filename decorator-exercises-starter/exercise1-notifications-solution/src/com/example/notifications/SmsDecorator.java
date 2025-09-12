package com.example.notifications;

/** ConcreteDecorator: adds SMS sending before delegating. */
public class SmsDecorator extends NotifierDecorator {
    private final String phone;
    public SmsDecorator(Notifier inner, String phone) { super(inner); this.phone = phone; }
    @Override public void notify(String text) {
        System.out.println("[SMS   -> " + phone + "]: " + text);
        super.notify(text);
    }
}
