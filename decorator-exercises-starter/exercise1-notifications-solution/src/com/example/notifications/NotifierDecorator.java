package com.example.notifications;

/** Base Decorator that forwards to the wrapped Notifier. */
public abstract class NotifierDecorator implements Notifier {
    protected final Notifier inner;
    protected NotifierDecorator(Notifier inner) { this.inner = inner; }
    @Override public void notify(String text) { inner.notify(text); }
}
